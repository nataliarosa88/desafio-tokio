public class Gerente extends Funcionario {

    @Override
    public double showBonus() {
        return this.salario * 0.15;
    }
}