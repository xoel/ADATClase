/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package U1A1Ej3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author xvazqdios
 */
public class Teclado {
    
    public static String leerCadena(){
        BufferedReader teclado= new BufferedReader (new InputStreamReader(System.in));    
        try {
            return teclado.readLine();
        } catch (IOException ioe) {
            return "Error";
        }
    }   
    
    public static char leerChar() throws IOException{
        BufferedReader teclado= new BufferedReader (new InputStreamReader(System.in));    
        return (char)teclado.read();        
    }    
    
    public static int leerInt() throws IOException{
        BufferedReader teclado= new BufferedReader (new InputStreamReader(System.in));    
        return Integer.parseInt(teclado.readLine());        
    }
    
    public static Double leerDouble() throws IOException{
        BufferedReader teclado= new BufferedReader (new InputStreamReader(System.in));    
        return Double.parseDouble(teclado.readLine());        
    }
    public static int leerPositivo() throws IOException{
        boolean positivo=false;
        int num = 0;
        BufferedReader teclado= new BufferedReader (new InputStreamReader(System.in));
        while(positivo==false){
            try{            
                num=esPositivo(Integer.parseInt(teclado.readLine()));
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
