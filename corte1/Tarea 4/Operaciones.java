public class Operaciones {
    private double num1;  
    private double num2;  
    private double result; 

    
    public Operaciones(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    
    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    
    public void sumar() {
        result = num1 + num2;
    }

    
    public void restar() {
        result = num1 - num2;
    }

    
    public void multiplicar() {
        result = num1 * num2;
    }

    
    public double getResult() {
        return result;
    }
}



