public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            Vista vista = new Vista();
            Modelo modelo = new Modelo();
            new Controlador(vista, modelo);
            vista.setVisible(true);
        });
    }
}
