public class Operaciones {
    private int num1; // Primer número
    private int num2; // Segundo número
    private int result;

    // Constructor: se ejecuta cuando se crea un objeto y guarda los números
    public Operaciones(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    // Métodos para obtener o cambiar los valores de num1 y num2 si es necesario
    public int getNum1() { return num1; }
    public void setNum1(int num1) { this.num1 = num1; }

    public int getNum2() { return num2; }
    public void setNum2(int num2) { this.num2 = num2; }

    // Método que suma los dos números
    public void sumar() {
        result = num1 + num2;
       
    }

    // Método que resta el segundo número al primero
    public void restar() {
       result = num1 - num2;
    }

    // Método que multiplica los dos números
    public void multiplicar() {
        result=  num1 * num2;
    
    }
    
  public int getResult(){
      System.out.print("Result = ");
      return result; 
  }
}