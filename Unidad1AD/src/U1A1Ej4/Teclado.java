/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package U1A1Ej4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author xvazqdios
 */
public class Teclado {
    
    public static String leerCadena(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }   
    
    public static char leerChar(){
        Scanner sc = new Scanner(System.in); 
        return (char)sc.nextByte();        
    }    
    
    public static int leerInt() {
        Scanner sc = new Scanner(System.in);    
        return sc.nextInt();        
    }
    
    public static Double leerDouble() throws IOException{
        Scanner sc = new Scanner(System.in);   
        return sc.nextDouble();        
    }
    public static int leerPositivo() throws IOException{
        boolean positivo=false;
        int num = 0;
        Scanner sc = new Scanner(System.in);
        while(positivo==false){
            try{            
                num=esPositivo(sc.nextInt());
                positivo=true;
            }catch(positiveException e){
                System.out.println(e.getMessage());
            } 
        }
        return num;
    }
    
    public static int esPositivo(int num) throws positiveException{
        if(num<0){
            throw new positiveException("Numero introducido no positivo"); 
        }else return num;
    }
    
}
