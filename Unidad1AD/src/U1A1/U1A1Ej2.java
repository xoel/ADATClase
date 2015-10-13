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
public class U1A1Ej2 {
    public static void main(String[] args) {
        System.out.println("Introduzca el primer numero: "); 
        int entero1=LeerEntero();
        System.out.println("Introduzca el segundo numero: "); 
        int entero2=LeerEntero();
        System.out.println("La suma es: "+(entero1+entero2));
        System.out.println("La resta es: "+(entero1-entero2));
        System.out.println("La multiplicacion es: "+(entero1*entero2));
        System.out.println("La division entera es: "+(entero1/entero2));
        System.out.println("El resto es: "+(entero1%entero2));
        System.out.println("La division real es: "+((float)entero1/(float)entero2));
        
    }
    private static int LeerEntero(){
        String texto = null;
        
        BufferedReader entradabuffer = new BufferedReader(new InputStreamReader(System.in));        
        do{
            try {
                texto = entradabuffer.readLine();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            if(!texto.matches("[0-9]*")){
                System.out.println("El numero no es un entero, introducelo de nuevo");
            }
        }while(!texto.matches("[0-9]*"));
                
        return Integer.parseInt(texto);
    }
    
}
