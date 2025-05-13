import javax.swing.*;

public class CajeroAutomatico {
    private final CuentaBancaria cuenta;

    public CajeroAutomatico() {
        cuenta = new CuentaBancaria();
    }

    public void iniciar() {
        String[] opciones = {"Depositar", "Retirar", "Consultar Saldo", "Salir"};
        int opcion;

        do {
            opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción",
                    "Cajero Automático", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, opciones, opciones[0]);

            switch (opcion) {
                case 0 -> {
                    // Depositar
                    double deposito = obtenerMonto("Ingrese monto a depositar:");
                    cuenta.depositar(deposito);
                    JOptionPane.showMessageDialog(null, "Depósito realizado exitosamente.");
                }
                case 1 -> {
                    // Retirar
                    double retiro = obtenerMonto("Ingrese monto a retirar:");
                    if (cuenta.retirar(retiro)) {
                        JOptionPane.showMessageDialog(null, "Retiro realizado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Saldo insuficiente o monto inválido.");
                    }
                }
                case 2 -> // Consultar Saldo
                    JOptionPane.showMessageDialog(null, "Saldo actual: $" + cuenta.obtenerSaldo());
                case 3 -> // Salir
                    JOptionPane.showMessageDialog(null, "Gracias por utilizar el cajero automático.");
                default -> JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        } while (opcion != 3);
    }

    private double obtenerMonto(String mensaje) {
        double monto = 0;
        boolean valido = false;

        while (!valido) {
            String input = JOptionPane.showInputDialog(mensaje);
            if (input == null || input.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor.");
            } else {
                try {
                    monto = Double.parseDouble(input);
                    if (monto > 0) {
                        valido = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "El monto debe ser mayor a cero.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Valor no válido. Ingrese un número.");
                }
            }
        }
        return monto;
    }

    public static void main(String[] args) {
        CajeroAutomatico cajero = new CajeroAutomatico();
        cajero.iniciar();
    }
}
