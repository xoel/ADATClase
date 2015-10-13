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
public class U1A1Ej2v2 {
    static int entero1,entero2;
    public static void main(String[] args) {
        System.out.println("Introduzca el primer numero: "); 
        entero1=LeerEntero();
        System.out.println("Introduzca el segundo numero: "); 
        entero2=LeerEntero();
        operaciones();
    }
    private static int LeerEntero() {
        String texto = null;
        int num = 0;
        BufferedReader entradabuffer = new BufferedReader(new InputStreamReader(System.in));

        try {
            texto = entradabuffer.readLine();
            num= Integer.parseInt(texto);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("Error de lectura");
        }catch (java.lang.NumberFormatException e) {
            System.out.println("El numero no es un entero, introducelo de nuevo");
            num=LeerEntero();
        }finally{
            try{
                entradabuffer.close();
            }catch(IOException e){
                System.out.println("Error al cerrar del buffer del teclado");
            }
        }
        return num;
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
