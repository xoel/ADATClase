/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package U1A2Ej7;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class U1A2Ej7 {
    private static final SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy H:m" );
    private static final DecimalFormat df = new DecimalFormat("###.###");
    public static void main(String[] args) {
        String ruta,filtro;
        Scanner sc = new Scanner(System.in);
        System.out.println("Buenos dias señor Usuario, introduzca un directorio: ");
        ruta=sc.nextLine();        
        System.out.println("Lord Caballero, ahora introduzca un filtro: ");
        filtro=sc.nextLine();
        File directorio=new File(ruta);   
        System.out.println("--- LISTANDO EL DIRECTORIO " + ruta);
        try{
            esFichero(directorio);
            esPunteroNulo(directorio);
            File[] ficheros = directorio.listFiles(new Filtro(filtro));
            for (File f : ficheros) {
                infoFichero(f.getAbsolutePath(),"---",filtro);
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
    private static void infoFichero(String ruta,String secuencia,String filtro) {
        File directorio= new File(ruta);
        String op1="DIR";
        String op2="FICHEIRO";
        String tipo=directorio.isDirectory()==true?op1:op2;
        System.out.println("-"+directorio.getName()+" <"+tipo+"> "+df.format((double)directorio.length()/1024)+" Kbytes "
                +formato.format(directorio.lastModified()));
        if(directorio.isDirectory()){
            File[] ficheros = directorio.listFiles(new Filtro(filtro));
            for (File f : ficheros) {
                System.out.print(secuencia);
                infoFichero(f.getAbsolutePath(),secuencia+"---",filtro);                 
            }
        }
    }
    
}
