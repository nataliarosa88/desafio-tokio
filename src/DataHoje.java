import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
