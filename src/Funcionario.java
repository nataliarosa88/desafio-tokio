public class Funcionario {
        protected double salario;
        public double showBonus() {
            return this.salario * 0.10;
        }
        public void setSalario(double valor){
            this.salario=valor;
        }
}
