import java.util.Arrays;
import java.util.List;

public class ExercicioLambda {
    public static void main(String[] args) {

        //Exemplo 1
        Runnable r = new Runnable() {
            public void run() {
                System.out.println("Thread sem lambda!");
            }
        };
        new Thread(r).start();

        Runnable r2 = () -> System.out.println("Thread sem lambda!");
        new Thread(r2).start();


        //Exemplo 2
        System.out.println("Imprime todos os elementos da lista!");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.forEach(System.out::println);
    }
}
