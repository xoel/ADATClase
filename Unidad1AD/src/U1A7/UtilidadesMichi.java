/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package U1A7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StreamTokenizer;

/**
 *
 * @author xvazqdios
 */
public class UtilidadesMichi {
    
    public static void main(String[] args) {
//        crearCarpetas("C:\\Users\\Miguel\\Desktop\\DAM2\\Acceso a datos\\Unidad 1\\Ejercicios\\Acceso a Datos\\DAM2","alumnos.txt");
//          moverFichero("C:\\Users\\Miguel\\Desktop\\DAM2\\Acceso a datos\\Unidad 1\\Ejercicios\\Acceso a Datos\\DAM2\\destino.txt", 
//                  "C:\\Users\\Miguel\\Desktop\\DAM2\\Acceso a datos\\Unidad 1\\Ejercicios\\Acceso a Datos\\DAM2\\destino");
          File d1 = new File ("Z:\\escritorio_windows - copia");
          File d2 = new File ("Z:\\");
          copiarDirectorio(d1,d2);
    }
    
    public static void crearCarpetas(String dir,String fichero){
        File alumnos = new File(fichero);
        File directorio = new File(dir);
        
        if (directorio.exists()){
            if (directorio.isDirectory()){
                try {
                    FileReader lista = new FileReader(alumnos);
                    StreamTokenizer tokens = new StreamTokenizer(lista);
                    String nombre,nombrecomp="";
                    while (tokens.nextToken()!=StreamTokenizer.TT_EOF){
                        if (tokens.ttype==StreamTokenizer.TT_WORD){
                        nombre=tokens.sval;
                        nombrecomp=nombrecomp.concat(nombre.substring(0,3));
                        if (nombrecomp.length()==9){
                            File carpeta=new File(directorio,nombrecomp);
                            if (!carpeta.exists()){
                                carpeta.mkdir();  
                            }
                            nombrecomp="";
                        }
                        }
                        
                    }
                } catch (FileNotFoundException ex) {
                    System.out.println("Error con la lista de alumnos.");
                } catch (IOException ex) {
                    System.out.println("Error");
                }
                
            }
            else {
                System.out.println("El directorio no existe. Se está creando...");
                directorio.mkdir();
                System.out.println("Directorio creado!");
            }
        }
        
        
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
    
    public static void copiarDirectorio(File origen, File destino){
        if (origen.isDirectory()){
            if (!destino.exists()){
                destino.mkdir();
            }
            System.out.println("Creando directorio "+destino.toString());
            //Scamos todos los ficheros del directorio
            String [] ficheros = origen.list();
            for (int i = 0; i < ficheros.length; i++) {
                copiarDirectorio(new File(origen,ficheros[i]), new File(destino,ficheros[i]));
            }
        }else{
            copiarFichero(origen, destino);
        }
    }
    
    public static void moverFichero(String fichero,String destino){
        File archivo = new File (fichero);
        File dirdestino = new File (destino);
        if (!dirdestino.exists()){
            System.out.println("Direccion destino NO existe. Direccion de destino creada!");
            dirdestino.mkdir();
            File arcdestino = new File(dirdestino+"\\"+archivo.getName());
            archivo.renameTo(arcdestino);
        }
        else{
            System.out.println("La direccion de destino existe. Creando carpeta...");
            File arcdestino = new File(dirdestino+"\\destino.txt");
            archivo.renameTo(arcdestino);
        }
        
        
    }
    
}
