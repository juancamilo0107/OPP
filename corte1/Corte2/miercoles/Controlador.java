import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Controlador implements ActionListener {

    private Vista vista;
    private Modelo modelo;

    public Controlador(Vista vista, Modelo modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.setControlador(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int grado = vista.getGradoSeleccionado();
        double[] coeficientes = vista.getCoeficientes();

        List<String> resultados = modelo.resolverPolinomio(grado, coeficientes);

        StringBuilder salida = new StringBuilder();
        for (String r : resultados) {
            salida.append(r).append("\n");
        }

        vista.mostrarResultado(salida.toString());
    }
}

