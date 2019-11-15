import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;

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
        Str.stream()//Utiliza o Stream do Java 8 para manipular listas
        .sorted()//Coloca em ordem alfabetica
        .filter(//Só exibe conforme o critério
                (s) -> s.startsWith("J"))//O critério é começar com J
                .forEach(System.out::println);//Imprime no console o que passou no critério;
    }
}