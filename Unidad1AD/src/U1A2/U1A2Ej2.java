/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package U1A2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class U1A2Ej2 {
    static PrintStream escribir = null;
    static DecimalFormat df = new DecimalFormat("###.###");
    static NumberFormat nf = NumberFormat.getInstance();
    static long constante = 1073741824;
    
    public static void main(String[] args) {
        int op;
        Scanner sc = new Scanner(System.in);
        
        do{
            System.out.println("¿Como quiere visualizar los datos?");
            System.out.println("1.Por Pantalla");
            System.out.println("2.En un fichero");
            op=sc.nextInt();            
        }while(op!=1&&op!=2);       
        
        File[] froots= File.listRoots();
        if(op==1){
            System.out.println("--- LISTANDO UNIDADES ---");
            for (File f: froots) {            
                infoDisco(f.getAbsolutePath());           
            }
        }else{
            abrirFichero();
            escribir.println("--- LISTANDO UNIDADES ---");
            for (File f: froots) {                
                grabarInfoDisco(f.getAbsolutePath());           
            }
            cerrarFichero();
        }        
    }
    static void abrirFichero() {
        try{
        escribir=new PrintStream("C:\\Users\\usuario\\Documents\\NetBeansProjects\\Unidad1AD\\src\\U1A2\\infoDiscos.txt");
        }
        catch(FileNotFoundException e){
            System.out.println("Fichero no encontrado");
        }catch(NullPointerException e){
            System.out.println("Direccion incorrecta");
        }
    }    

    private static void cerrarFichero() {
        if (escribir!=null) {
            escribir.close();
        }
    }
    static void grabarInfoDisco(String ruta) {
        File f= new File(ruta);
        escribir.println("Unidad "+ruta);
        escribir.println("    Espacio libre: "+nf.format(f.getFreeSpace())+" bytes ("+df.format((double)f.getFreeSpace()/1073741824)+" GB)");
        escribir.println("    Espacio ocupado: "+nf.format((f.getTotalSpace()-f.getFreeSpace()))+" bytes ("+df.format(((double)f.getTotalSpace()-(double)f.getFreeSpace())/1073741824)+" GB)");
        escribir.println("    Espacio total: "+nf.format(f.getTotalSpace())+" bytes ("+df.format((double)f.getTotalSpace()/1073741824)+" GB)");
    }
    
    public static void infoDisco(String ruta){        
        File f= new File(ruta);
        System.out.println("Unidad "+ruta);
        System.out.println("    Espacio libre: "+nf.format(f.getFreeSpace())+" bytes ("+df.format((double)f.getFreeSpace()/1073741824)+" GB)");
        System.out.println("    Espacio ocupado: "+nf.format((f.getTotalSpace()-f.getFreeSpace()))+" bytes ("+df.format(((double)f.getTotalSpace()-(double)f.getFreeSpace())/1073741824)+" GB)");
        System.out.println("    Espacio total: "+nf.format(f.getTotalSpace())+" bytes ("+df.format((double)f.getTotalSpace()/1073741824)+" GB)");
    }
    
}
