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
