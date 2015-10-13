/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package U1A2Ej3;


import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class U1A2Ej3 {
    static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy H:m" );
    static DecimalFormat df = new DecimalFormat("###.###");
    public static void main(String[] args) {
        String ruta;
        Scanner sc = new Scanner(System.in);
        System.out.println("Buenos dias señor Usuario, introduzca un directorio: ");
        ruta=sc.nextLine();        
        File directorio=new File(ruta);   
        System.out.println("--- LISTANDO EL DIRECTORIO " + ruta);
        try{
            esFichero(directorio);
            esPunteroNulo(directorio);
            File[] ficheros = directorio.listFiles();
            for (File f : ficheros) {
                infoFichero(f.getAbsolutePath());
            }
        }catch(NoDirectoryException | ParamNoExisteException e){
            System.out.println(e.getMessage());
        }
    }
    
    private static void esPunteroNulo(File fichero) throws ParamNoExisteException{
        if(!fichero.exists()){
            throw new ParamNoExisteException("La ruta especificada no existe.");
        }
    }
    
    private static void esFichero(File fichero) throws NoDirectoryException{
        if(fichero.isFile()){
            throw new NoDirectoryException("La ruta especificada no es un directorio");
        }
    }
    private static void infoFichero(String ruta) {
        File f= new File(ruta);
        String op1="DIR";
        String op2="FICHEIRO";
        String tipo=f.isDirectory()==true?op1:op2;
        System.out.println(f.getName()+" <"+tipo+"> "+df.format((double)f.getTotalSpace()/1232896)+" Kbytes "+formato.format(f.lastModified()));
    }
    
}
