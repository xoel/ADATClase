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
public class Rectangulo extends Figura{

    public Rectangulo(int x, int y) {
        super(x, y);
    }
    
    @Override
    public double area() {
        return Rectangulo.super.getX()*Rectangulo.super.getY();
    }
    
}
