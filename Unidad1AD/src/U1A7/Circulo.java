/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package U1A7;

/**
 *
 * @author Xoel Vazquez Dios
 */
public class Circulo extends Figura{
    private double radio;
    private static final double PI=3.1416;
    public Circulo(int x, int y, double radio) {
        super(x, y);
        this.radio=radio;
    }
    @Override
    public double area() {
        return PI*Math.sqrt(radio);
    }

    public double getRadio() {
        return radio;
    }
    
    
}
