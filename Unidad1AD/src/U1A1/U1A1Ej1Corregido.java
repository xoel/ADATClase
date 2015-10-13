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
public class U1A1Ej1Corregido {
    static int entero1, entero2;
    public static void main(String[] args) {
        leerEnteros();
        operaciones();
    }
    
    public static void leerEnteros() {
        BufferedReader teclado =null;
        try{
            teclado= new BufferedReader (new InputStreamReader(System.in));
            System.out.println("Introducir primer digito: ");
            entero1=Integer.parseInt(teclado.readLine());
            System.out.println("Introducir segundo digito: ");
            entero2=Integer.parseInt(teclado.readLine());
        }catch(NumberFormatException e){
            System.out.println("No es un numero entero");
        }catch(IOException e){
            System.out.println("Error de lectura del numero");
        }finally{
            try{
                teclado.close();
            }catch(IOException e){
                System.out.println("Error al cerrar del buffer del teclado");
            }
        }
    }
    
    public static void operaciones(){
        System.out.println("La suma es: "+(entero1+entero2));
        System.out.println("La resta es: "+(entero1-entero2));
        System.out.println("La multiplicacion es: "+(entero1*entero2));
        try{
            System.out.println("La division entera es: "+(entero1/entero2));
        }catch(ArithmeticException e){
            System.out.println("Error, no se puede dividir entre cero");
        }
        //la division real entre cero funciona distinto, puede dar infinito
        System.out.println("La division real es: "+((float)entero1/(float)entero2));
        try{
            System.out.println("El resto es: "+(entero1%entero2));
        }catch(ArithmeticException e){
            System.out.println("Error, no se puede hayar el resto dividiendo por cero");
        }
    }
    
}
