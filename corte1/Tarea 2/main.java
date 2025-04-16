package calculadora.magica;

public class main {
    public static void main(String[] args) {
        Operations resultado = new Operations();
        
        resultado.sumar(3, 2);
        System.out.println("La suma es igual a: " + resultado.getResultado());
        
        resultado.restar(5, 2);
        System.out.println("La resta es igual a: " + resultado.getResultado());
        
        resultado.multiplicar(3, 2);
        System.out.println("La multiplicación es igual a: " + resultado.getResultado());
    }

    // Clase interna privada
    private static class Operations {
        private int r;

        private void sumar(int a, int b) {
            r = a + b;
        }

        private void restar(int a, int b) {
            r = a - b;
        }

        private void multiplicar(int a, int b) {
            r = a * b;
        }

        private int getResultado() {
            return r;
        }
    }
}

