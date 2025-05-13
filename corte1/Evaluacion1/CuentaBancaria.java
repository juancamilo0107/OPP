public class CuentaBancaria {
    private double saldo;

    public CuentaBancaria() {
        saldo = 0;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
        }
    }

    public boolean retirar(double monto) {
        if (monto > 0 && saldo >= monto) {
            saldo -= monto;
            return true;
        }
        return false;
    }

    public double obtenerSaldo() {
        return saldo;
    }
}



