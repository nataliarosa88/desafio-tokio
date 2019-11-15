# Teste Java - Tokio Marine - Backend Júnior

__Desenvolvido por:__ _Natália Rosa_ __Em:__ _15/11/2019_ 

__Consultoria:__ _Vermont_ 


## 1. Explique os princípios da orientação a objeto?

A O.O. destina-se a mapear o mundo real como uma coleção de objetos que incorporam estruturas de dados e conjuntos de operações que manipulam estes dados para o desenvolvimento do software acontecer de forma fluída e de acordo com os contextos reais em que o software esta inserido.

A maioria das linguagens de programação atualmente são orientadas a objeto. Os principais conceitos desse paradigma podem ser resumidos em 4 pilares, que são eles: Abstração, Encapsulamento, Herança, Polimorfismo.


1) **Abstração:** _Identificamos um objeto, passamos ao mesmo características e definimos ações._
2) **Encapsulamento:** _Adicionamos segurança a uma aplicação por meio de modificadores de acesso, métodos e estratégias de desenvolvimento._
3) **Herança:** _É uma das grandes vantagens da programação orientada a objetos, permite o reuso do código que otimiza tempo e linhas de código._
4) **Polimorfismo:** _Significa assumir muitas formas, ilustrando, seria uma chamada de método por exemplo ser executada de várias maneiras e quem decide a forma é o objeto que chama o método de acordo com sua implementação._

## 2. Defina encapsulamento, dê um exemplo (código).

Encapsular seria como proteger o objeto para que seu uso seja o mais aderente possível ao que ele se propõe.

No caso não basta no caso do campo Saldo de uma conta protegê-lo com private e usar getters e setters, pois alguém poderia setar um saldo diretamente. O correto seria um conjunto de métodos atualizarem esse atributo de acordo com as devidas regras de negócio:

```java
class Conta{
    private double saldo;

    public Conta(double saldoInicial){
        this.saldo = saldoInicial;
    }
    public double getSaldo(){
        return this.saldo;
    }

    public boolean saca(double valor) {
        if (this.saldo < valor)
            return false;
        else {
            this.saldo -= valor;
            return true;
        }
    }

    public void deposita(double valor) {
            this.saldo += valor;
    }

}
```

_E para testar a classe segue a classe de Teste com jUnit:_

```java
public class ContaTest {
    Conta conta;

    @Before
    public void setup(){
        conta = new Conta(100.0);
    }

    @Test
    public void testaSaque() {
        conta.saca(50.0);
        assertThat(conta.getSaldo(),is(50.0));
    }

    @Test
    public void testaDeposito() {
        conta.deposita(50.0);
        assertThat(conta.getSaldo(),is(150.0));
    }

    @After
    public void tearDown(){
        conta = null;
    }
}
```

## 3. Defina polimorfismo, dê um exemplo (código).

Polimorfismo é a capacidade de um objeto poder ser referenciado de várias formas.
Imagine uma porta na agência bancária com o seguinte aviso: "Permitida a entrada apenas de Funcionários". Um gerente pode passar nessa porta pois Gerente é um Funcionario. Podemos então fazer o gerente herdar de funcionário e apenas reescrever as particularidades, por exemplo uma regra de bônus especial:

```java
public class Funcionario {
        protected double salario;
        public double showBonus() {
            return this.salario * 0.10;
        }
        public void setSalario(double valor){
            this.salario=valor;
        }
}

public class Gerente extends Funcionario {

    @Override
    public double showBonus() {
        return this.salario * 0.15;
    }
}
```

_E para testar a classe segue a classe de Teste com jUnit:_
```java

public class FuncionarioTest {

    @Test
    public void testaBonusFuncionario() {
        Funcionario funcionario = new Funcionario();
        funcionario.setSalario(1000.0);
        Assert.assertEquals(100.0, funcionario.showBonus(), 0.01);
    }
    @Test
    public void testaBonusGerente() {
        //Podemos nos referir a um Gerente como sendo um Funcionario. (Polimorfismo)
        Funcionario gerente = new Gerente();
        gerente.setSalario(10000.0);
        Assert.assertEquals(1500.0, gerente.showBonus(), 0.01);
    }
}

```

## 4. Qual a diferença entre interface e classe abstrata?

A **interface** define as operações que um objeto será obrigado a implementar mas não contem implementação.

A **classe abstrata** é um tipo de classe que somente pode ser herdada e não instanciada. 
De certa forma, é uma classe conceitual que pode definir funcionalidades para que as subclasses possam implementá-las. Serve como modelo para outras classes que dela herdam.

Uma classe que implementa uma interface tem obrigatoriamente que implementar todos os métodos desta, mas o mesmo não é exigido no caso de uma classe abstrata. As classes abstratas são mais rápidas que as interfaces.

O Java não possui múltiplas heranças, ou seja, uma classe só pode herdar de uma outra única classe, mas a mesma pode estar herdando de outra e assim por diante.
Porém o Java permite múltiplas implementações de interface, ou seja, deve-se verificar de acordo com a necessidade onde é melhor interfaces e onde é melhor aplicar classes abstratas.
 
## 5. Quais as exceções serão lançadas respectivamente nos códigos abaixo?

a) 

```java
String s1 = null;
String s2 = s1.substring(11);
```

**Exceção:** _java.lang.NullPointerException_

b)
 
```java
String[] indices = new String[2]; //Adicionei ponto e vírgula para rodar
System.out.println(indices[2]); //Adicionei ponto e vírgula para rodar
```

**Exceção:** _java.lang.ArrayIndexOutOfBoundsException_

## 6. Escreva três tipo de dados primitivos da linguagem java.
* boolean
* int
* char

## 7. Qual a diferença entre os modificadores de acesso public , protected default e private?

* public: _Visto fora do escopo da classe_
* private: _Visto no escopo da classe_
<<<<<<< HEAD
* protected: _Visto no escopo do pacote e por herança_
=======
* protected: _Visto no escopo do pacote_
>>>>>>> 5d3065c8c9abb7078f92938c05cecb1a5a1e4eb0
* default: _Visto no escopo do pacote (Quando não é informado é default)_

## 8. Escreva o bloco de captura e tratamento da exception NullPointerException.

```java

public class ExercicioNullPointerException {
    public static void main(String[] args) {
        try {
            fazerAlgoQueDisparaNullPointerException();
        } catch (NullPointerException e) {
            System.out.print("Capturei um NullPointerException");
        }
    }

    public static void fazerAlgoQueDisparaNullPointerException() {
        String textoNulo = null;
        textoNulo.endsWith("Alguma palavra");
    }
}

```

## 9. Qual mensagem será enviada para a saída padrão no código abaixo?

a)

```java
String v1 = new String(“linux”);
String v2 = new String(“linux”);
if(s1==s2)
    System.out.println("true");
else
    System.out.println("false");
int i = 1, j=2;
if(i==j)
    System.out.println("true");
else
    System.out.println("false");
```

_Segue código e retorno no comentário antes da condição_

```java

public class Mensagem {
    public static void main(String[] args) {
        String v1 = new String("linux");
        String v2 = new String("linux");
        //if(s1==s2) //nao compila pois não é possível localizar a variável s1 e s2
        //retorna false
        if(v1==v2)
            System.out.println("true");
        else
            System.out.println("false");
        //retorna true
        if(v1.equals(v2))
            System.out.println("true");
        else
            System.out.println("false");
        //retorna false
        int i = 1, j=2;
        if(i==j)
            System.out.println("true");
        else
            System.out.println("false");
        //extra retorna true
        int y= 300, x=300;
        if(y==x)
            System.out.println("true");
        else
            System.out.println("false");
    }
}

```

b)

```java
public class Klass {
    public static void main(String[] args) {
        int key = 2;
        switch (key) {
        case 1:
            System.out.println(1);
        case 2:
            System.out.println(2);
        case 3:
            System.out.println(3);
        default:
            System.out.println("default");
        }
    }
}
```

_Segue resultado ** 2,3,Default ** e sugestão no comentário **Incluir um break no final de cada case**_


```java

public class Klass {
    public static void main(String[] args) {
        int key = 2;
        switch (key) {
            case 1:
                System.out.println(1);
             case 2:
                System.out.println(2);
                 //faltou break para o comportamento adequado                
            case 3:
                System.out.println(3);
            default:
                System.out.println("default");
        }
    }
}

```





## 10. Analisando o código qual a saída que teremos

```java
List<String> Str = new ArrayList<>();
Str.add("HONDA");
Str.add("PEGEOT");
Str.add("BMW");
Str.add("FIAT");
Str.add("JEEP");
Str.add("JAC");
Str.add("JAGUAR");
Str.add("TOYOTA");
Str.stream().sorted().filter((s) -> s.startsWith("J")).forEach(System.out::println);
```

_A Saída que teremos será:_ 
* JAC
* JAGUAR
* JEEP

```java

class ExercicioArrayList {
    public static void main(String[] args) {

        ArrayList<String> Str = new ArrayList<>();
        Str.add("HONDA");
        Str.add("PEGEOT");
        Str.add("BMW");
        Str.add("FIAT");
        Str.add("JEEP");
        Str.add("JAC");
        Str.add("JAGUAR");
        Str.add("TOYOTA");

        //Java 7
        System.out.println("############ JAVA 7 #############");
        Collections.sort(Str);

        for(String cadaElementoDoArrayList : Str){
            if(cadaElementoDoArrayList.startsWith("J"))
                System.out.println(cadaElementoDoArrayList);
        }

        //Str.stream().forEach(cadaElementoDoArrayList -> System.out.println(cadaElementoDoArrayList));

        //Java 8
        System.out.println("############ JAVA 8 #############");
        Str.stream()//Utiliza o Stream do Java 8 para manipular listas ganhamos vários métodos com o Stream
        .sorted()//Coloca em ordem alfabetica
        .filter(//Só exibe conforme o critério
                (s) -> s.startsWith("J"))//O critério é começar com J
                .forEach(System.out::println);//Imprime no console o que passou no critério;
    }
}

```

## 11. Na sua opinião, qual a classe nativa mais indicada para armazenar e manipular datas? Implemente o código com a data de hoje.

_LocalDate na minha opinião é a classe nativa mais indicada para aplicações novas, encontramos em outras mais antigas Date e Calendar por exemplo._

```java

public class DataHoje {
    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatadaParaHumanos = hoje.format(formatador);
        System.out.println("Formatado");
        System.out.println(dataFormatadaParaHumanos);
    }
}

```
## 12. O que é exatamente uma expressão lambda (exemplo)?

_É uma função sem declaração, isto é, não é necessário colocar um nome, um tipo de retorno e o modificador de acesso. A ideia é que o método seja declarado no mesmo lugar em que será usado_

```java

public class ExercicioLambda {
    public static void main(String[] args) {

        //Exemplo 1
        Runnable r = new Runnable() {
            public void run() {
                System.out.println("Thread sem lambda!");
            }
        };
        new Thread(r).start();


        Runnable r2 = () -> System.out.println("Thread com lambda!");
        new Thread(r2).start();


        //Exemplo 2
        System.out.println("Imprime todos os elementos da lista!");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.forEach(System.out::println);
    }
}


```

## 13. O código abaixo representa qual desing pattern ?

```java
package util;
public final class ServerUtil{
    private static ServerUtil instance = null;
    private ServerUtil (){ }
    public static synchronized ServerUtil getInstance(){
        if (instance==null){
            instance = new ServerUtil ();
        }
        return instance;
}
public Object clone() throws CloneNotSupportedException{
    return instance;
}
}
```
<<<<<<< HEAD
Existem padrões parecidos mas com algumas particularidades, por exemplo:
*Prototype*_=Um novo objeto é criado toda vez que é injetado/procurado._
_Ele usará new AlgumaClasse() a cada vez._
*Singleton*_=O mesmo objeto é retornado toda vez que é injetado/procurado._
_Aqui, ele irá instanciar uma instância de AlgumaClasse() e, em seguida, retornará a cada vez._
**O Padrão de projeto utilizado que mais se assemelha:** _Singleton_
=======

**O Padrão de projeto utilizado é:** _Singleton_
>>>>>>> 5d3065c8c9abb7078f92938c05cecb1a5a1e4eb0

## 16 (18) – Cite pelo menos quatro nomes de design patterns.

* Singleton
* Strategy
* Builder
* MVC


## 14. Definir o que é DDD?

Domain-Driven Development
O DDD é uma modelagem OO mais pura esquecer de como os dados são persistidos e nos preocupar em como representar melhor as necessidades de negócio em classes e comportamentos (métodos). As nomeclaturas refletem as mesmas do negócio, tudo é feito como vários guarda chuvas onde o domínio é o foco e as especializações partem dele de acordo com a lógica e regras do dia a dia.

## 15. Definir o que é TDD?

TDD é o Desenvolvimento Orientado por Testes. Desenvolvemos o software baseado em testes que são escritos antes do código de produção com um ciclo de desenvolvimento onde codficamos um teste que inicialmente não passa, adicionamos uma nova funcionalidade no sistema, fazemos o Teste passar, refatoramos o código da nova funcionalidade e seguimos escrevendo os próximos Testes nessa hora a IDE ajuda muito criando classes, métodos para que os testes tenham suas dependências. Dessa forma não tem desculpa para não fazer testes e ajuda muito quando a empresa utiliza ferramentas e métricas apoiadas em testes.

## 16. Como você descreve as etapas do fluxo de desenvolvimento no SCRUM?

No Scrum, os projetos são divididos em ciclos (tipicamente mensais) chamados de Sprints. O Sprint representa um Time Box dentro do qual um conjunto de atividades deve ser executado. Metodologias ágeis de desenvolvimento de software são iterativas, ou seja, o trabalho é dividido em iterações, que são chamadas de Sprints no caso do Scrum.

As funcionalidades a serem implementadas em um projeto são mantidas em uma lista que é conhecida como Product Backlog. No início de cada Sprint, faz-se um Sprint Planning Meeting, ou seja, uma reunião de planejamento na qual o Product Owner prioriza os itens do Product Backlog e a equipe seleciona as atividades que ela será capaz de implementar durante o Sprint que se inicia. As tarefas alocadas em um Sprint são transferidas do Product Backlog para o Sprint Backlog.

A cada dia de uma Sprint, a equipe faz uma breve reunião (normalmente de manhã), chamada Daily Scrum. O objetivo é disseminar conhecimento sobre o que foi feito no dia anterior, identificar impedimentos e priorizar o trabalho do dia que se inicia.

Ao final de um Sprint, a equipe apresenta as funcionalidades implementadas em uma Sprint Review Meeting. Finalmente, faz-se uma Sprint Retrospective e a equipe parte para o planejamento do próximo Sprint. Assim reinicia-se o ciclo.

## 17. O que as anotações nas classes ou nos métodos abaixo estão indicando?

```java
@Test //Método de teste (jUnit)
public void calculoValorParcelaPendente() {
    ...
}
@Entity //Entidade mapeada pela JPA para persistência (Se não indicada também entitula a tabela no banco de dados)
public class ClientePEP() {
    ...
}
public class ClientePEP() {
    @ID //Define que o atributo anotado será a chave
    private Long id
}
@RestController //Informa que a referida classe é o controler dotado dos endpoints da aplicação no caso de uma API
public class InformarSinistroController() {

    @Autowired //Injeção de dependências o princípio da inversão de controle, onde em frameworks como spring não precisamos instanciar todas as dependências, utilizando do recurso da injeção declaramos e anotamos e o framework cuida dos aspectos técnicos para garantir o uso do objeto injetado
    private ClientService clientService;

    @GetMapping("/{id}") //end point do verbo GET utilizado para entrada de informações no controler no caso pegando o id do path da URI
    public BemSegurado read(@PathVariable Long id) throws Exception {}

}
```
