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

b)
 
```java
String[] indices = new String[2]
System.out.println(indices[2])
```
## 6. Escreva três tipo de dados primitivos da linguagem java.

## 7. Qual a diferença entre os modificadores de acesso public , protected default e private?

## 8. Escreva o bloco de captura e tratamento da exception NullPointerException.

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
## 11. Na sua opinião, qual a classe nativa mais indicada para armazenar e manipular datas? Implemente o código com a data de hoje.

## 12. O que é exatamente uma expressão lambda (exemplo)?

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
## 16 (18) – Cite pelo menos quatro nomes de design patterns.

## 14. Definir o que é DDD?

## 15. Definir o que é TDD?

## 16. Como você descreve as etapas do fluxo de desenvolvimento no SCRUM?

## 17. O que as anotações nas classes ou nos métodos abaixo estão indicando?

```java
@Test
public void calculoValorParcelaPendente() {
    ...
}
@Entity
public class ClientePEP() {
    ...
}
public class ClientePEP() {
    @ID
    private Long id
}
@RestController
public class InformarSinistroController() {

    @Autowired
    private ClientService clientService;

    @GetMapping("/{id}")
    public BemSegurado read(@PathVariable Long id) throws Exception {}

}
```
