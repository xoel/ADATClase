/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package U1A1Ej3;

import java.io.IOException;

/**
 *
 * @author xvazqdios
 */
public class EjEntradaSalidaConsola {
    public static void main(String[] args) throws IOException{
        System.out.println("Leer Cadena: ");
        String s = Teclado.leerCadena();
        System.out.println("Leer Caracter: ");
        char car =Teclado.leerChar();
        System.out.println("Leer Int: ");
        int num1=Teclado.leerInt();
        System.out.println("Leer double: ");
        double num2=Teclado.leerDouble();
        System.out.println("Introducir un positivo");
        int num3=Teclado.leerPositivo();
        System.out.println("Cadena: "+s);
        System.out.println("Char: "+car);
        System.out.println("Integer: "+num1);
        System.out.println("Doule: "+num2);
        System.out.println("Positivo: "+num3);
        
    }
    
}
