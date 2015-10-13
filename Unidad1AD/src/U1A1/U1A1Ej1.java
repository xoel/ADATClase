/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package U1A1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author xvazqdios
 */
public class U1A1Ej1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String texto = null;
        int entero1 = 0,entero2 = 0;
        BufferedReader entradabuffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introduzca el primer numero: ");        
        try {
            texto = entradabuffer.readLine();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }       
        try {
            entero1 = Integer.parseInt(texto);
        } catch (java.lang.NumberFormatException e) {
            System.out.println("Error, no se puede convertir, el numero no es un entero");
        }
        System.out.println("Introduzca el segundo numero: ");        
        try {
            texto = entradabuffer.readLine();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }       
        try {
            entero2 = Integer.parseInt(texto);
        } catch (java.lang.NumberFormatException e) {
            System.out.println("Error, no se puede convertir, el numero no es un entero");
        }
        System.out.println("La suma es: "+(entero1+entero2));
        System.out.println("La resta es: "+(entero1-entero2));
        System.out.println("La multiplicacion es: "+(entero1*entero2));
        System.out.println("La division entera es: "+(entero1/entero2));
        System.out.println("El resto es: "+(entero1%entero2));
        System.out.println("La division real es: "+((float)entero1/(float)entero2));
        
    }
}
