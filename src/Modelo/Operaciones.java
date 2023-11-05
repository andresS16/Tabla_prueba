
package Modelo;


public class Operaciones {
    int a; 
    int b;

    public Operaciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
    public int suma(){
       return a+b;
    }

public int resta(){
       return a-b;
    }
public int mult(){
       return a*b;
    }
public double div(){
       return (double) a/b;
    }
    
}
