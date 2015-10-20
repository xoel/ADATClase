/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package U1A7;

import static U1A7.UtilidadesMichi.copiarDirectorio;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StreamTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Utilidades {
    public static void main(String[] args) {
        File f = new File("C:\\Users\\usuario\\Desktop\\ADAT\\Ejercicios");
        File f2 = new File("C:\\Users\\usuario\\Desktop\\ADAT\\Teoria");
        copiarDirectorio(f, f2);
    }

    
    
    public void crearCarpetas(File directorio, String fichero){
        FileReader entrada= null;
        String nombre, apellido1, apellido2;
        String[] cadena = null;
        try {
            File alumnos = new File(fichero);
            entrada = new FileReader(alumnos);
            StreamTokenizer tokens = new StreamTokenizer(entrada);            
            while (tokens.nextToken() != StreamTokenizer.TT_EOF) {
                //Por cada linea leer lo que hay dentro y crear la carpeta
                while (tokens.nextToken() != StreamTokenizer.TT_EOL) {
                    int i=0;
                    if (tokens.ttype == StreamTokenizer.TT_WORD) {
                        cadena[i]=tokens.sval;
                        i++;
                    }
                    //ahora debemos coger cada cosa y hacer la carpeta
                }
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } finally {
            try {
                entrada.close();
            } catch (IOException ex) {
            }
        }
        
    }
    
    public static void copiarDirectorio(File origen, File destino){
        //TODO copia lo de dentro de uno 3en otro en lugar de copiar el directorio con sus
        //cosas en si
        //destino.renameTo(new File(destino.getAbsoluteFile()+origen.getName()));
        if(origen.isDirectory()){
            if(!destino.exists()){
                destino.mkdirs();
            }
            String[] ficheros = origen.list();
            for (String fichero : ficheros) {
                copiarDirectorio(new File(origen, fichero), new File(destino, fichero));
            }            
        }else{
            copiarFichero(origen,destino);
        }      
    }
    
    public void moverFichero(File fichero, File destino){
        copiarFichero(fichero, destino);
        fichero.delete();
    }
    
    public static void copiarFichero (File d1, File d2){
        InputStream in;
        OutputStream out;
        int len;
        byte [] buf = new byte [1024];        
        try{
            in = new FileInputStream (d1);
            out = new FileOutputStream(d2);
            while ((len=in.read(buf)) > 0){
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
            System.out.println("Copiando fichero "+d1.toString());  
        }catch (IOException IOE){            
        }    
    }
    
    
    
}
