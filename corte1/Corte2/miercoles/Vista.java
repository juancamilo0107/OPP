import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Vista extends JFrame {

    private JComboBox<Integer> comboGrado;
    private JTextField[] camposCoeficientes;
    private JButton botonResolver;
    private JTextArea areaResultado;
    private JPanel panelCoeficientes;

    public Vista() {
        setTitle("Resolución de Polinomios (Grado 1 a 4)");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelSuperior = new JPanel();
        panelSuperior.add(new JLabel("Selecciona el grado:"));
        comboGrado = new JComboBox<>(new Integer[]{1, 2, 3, 4});
        panelSuperior.add(comboGrado);
        add(panelSuperior, BorderLayout.NORTH);

        panelCoeficientes = new JPanel();
        panelCoeficientes.setLayout(new GridLayout(5, 2));
        actualizarCamposCoeficientes(1);
        add(panelCoeficientes, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel(new BorderLayout());
        botonResolver = new JButton("Resolver");
        panelInferior.add(botonResolver, BorderLayout.NORTH);

        areaResultado = new JTextArea(6, 40);
        areaResultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaResultado);
        panelInferior.add(scroll, BorderLayout.CENTER);

        add(panelInferior, BorderLayout.SOUTH);

        comboGrado.addActionListener(e -> {
            int grado = (int) comboGrado.getSelectedItem();
            actualizarCamposCoeficientes(grado);
        });
    }

    private void actualizarCamposCoeficientes(int grado) {
        panelCoeficientes.removeAll();
        camposCoeficientes = new JTextField[grado + 1];
        for (int i = 0; i <= grado; i++) {
            panelCoeficientes.add(new JLabel("Coeficiente a" + i + ":"));
            camposCoeficientes[i] = new JTextField("0", 10);
            panelCoeficientes.add(camposCoeficientes[i]);
        }
        panelCoeficientes.revalidate();
        panelCoeficientes.repaint();
    }

    public int getGradoSeleccionado() {
        return (int) comboGrado.getSelectedItem();
    }

    public double[] getCoeficientes() {
        int grado = getGradoSeleccionado();
        double[] coef = new double[grado + 1];
        for (int i = 0; i <= grado; i++) {
            try {
                coef[i] = Double.parseDouble(camposCoeficientes[i].getText());
            } catch (NumberFormatException e) {
                coef[i] = 0;
            }
        }
        return coef;
    }

    public void mostrarResultado(String resultado) {
        areaResultado.setText(resultado);
    }

    public void setControlador(ActionListener al) {
        botonResolver.addActionListener(al);
    }
}
