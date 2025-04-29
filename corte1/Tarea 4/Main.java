import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        try {
            
            String input1 = JOptionPane.showInputDialog("Ingrese el primer número:");
            String input2 = JOptionPane.showInputDialog("Ingrese el segundo número:");

            
            double numero1 = Double.parseDouble(input1);
            double numero2 = Double.parseDouble(input2);

            
            Operaciones operacion = new Operaciones(numero1, numero2);

            
            String[] opciones = {"Sumar", "Restar", "Multiplicar"};
            int operacionSeleccionada = JOptionPane.showOptionDialog(null, "Seleccione una operación", 
                    "Operaciones", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, 
                    null, opciones, opciones[0]);

            
            switch (operacionSeleccionada) {
                case 0: 
                    operacion.sumar();
                    JOptionPane.showMessageDialog(null, "El resultado de la suma es: " + operacion.getResult());
                    break;
                case 1:
                    operacion.restar();
                    JOptionPane.showMessageDialog(null, "El resultado de la resta es: " + operacion.getResult());
                    break;
                case 2: 
                    operacion.multiplicar();
                    JOptionPane.showMessageDialog(null, "El resultado de la multiplicación es: " + operacion.getResult());
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "No se seleccionó ninguna operación.");
            }
        } catch (NumberFormatException e) {
            
            JOptionPane.showMessageDialog(null, "Por favor, ingrese números válidos.");
        }
    }
}
