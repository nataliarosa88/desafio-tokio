import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

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