import org.junit.Assert;
import org.junit.Test;

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
