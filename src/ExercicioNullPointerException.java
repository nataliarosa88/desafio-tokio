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
