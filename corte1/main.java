
package calculadora.magica;

public class main {
    public static void main(String[] args) {
        Operations resultado = new Operations();
        
        resultado.sumar(3, 2);
        System.out.println("La suma es igual a: " + resultado.r);
        
        resultado.restar(5, 2);
        System.out.println("La resta es igual a: " + resultado.r);
        
        resultado.multiplicar(3, 2);
        System.out.println("La multiplicación es igual a: " + resultado.r);
    }
}

class Operations {
    int r;

    public void sumar(int a, int b) {
        r = a + b;
    }

    public void restar(int a, int b) {
        r = a - b;
    }

    public void multiplicar(int a, int b) {
        r = a * b;
    }
}
