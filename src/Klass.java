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