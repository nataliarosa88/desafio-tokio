class Conta{
    private double saldo;

    public Conta(double saldoInicial){
        this.saldo = saldoInicial;
    }
    public double getSaldo(){
        return this.saldo;
    }

    public boolean saca(double valor) {
        if (this.saldo < valor)
            return false;
        else {
            this.saldo -= valor;
            return true;
        }
    }

    public void deposita(double valor) {
            this.saldo += valor;
    }

}