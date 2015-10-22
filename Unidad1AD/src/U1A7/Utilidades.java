/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
 * @author usuario
 */
public class Utilidades {

    public static void main(String[] args) {
        File f = new File("C:\\Users\\Xoel\\Desktop\\DAM2\\ADAT\\Ejercicios");
        File f2 = new File("C:\\Users\\Xoel\\Desktop\\DAM2\\ADAT\\Unidad1");
        File f3 = new File("C:\\Users\\Xoel\\Desktop\\DAM2\\ADAT\\Ejercicios\\nombres.txt");
        //copiarDirectorio(f, f2);
        crearCarpetas(f, f3);
    }

    public static void crearCarpetas(File directorio, File alumnos) {

        String carpeta="";
        if (!directorio.exists()) {
            directorio.mkdirs();
        }
        try {
            FileReader entrada = new FileReader(alumnos);
            StreamTokenizer tokens = new StreamTokenizer(entrada);
            while (tokens.nextToken() != StreamTokenizer.TT_EOF) {
                //Por cada linea leer lo que hay dentro y crear la carpeta

                if (tokens.ttype == StreamTokenizer.TT_WORD) {
                    System.out.println(tokens.sval);
                    carpeta=carpeta.concat(tokens.sval.substring(0,3));
                    if(carpeta.length()==9){
                        File f1 = new File(directorio,carpeta);
                        f1.mkdir();
                        carpeta="";
                    }
                }
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }

    }

    public static void copiarDirectorio(File origen, File destino) {
        //TODO copia lo de dentro de uno 3en otro en lugar de copiar el directorio con sus
        //cosas en si
        //destino.renameTo(new File(destino.getAbsoluteFile()+origen.getName()));
        if (origen.isDirectory()) {
            if (!destino.exists()) {
                destino.mkdirs();
            }
            String[] ficheros = origen.list();
            for (String fichero : ficheros) {
                copiarDirectorio(new File(origen, fichero), new File(destino, fichero));
            }
        } else {
            copiarFichero(origen, destino);
        }
    }

    public void moverFichero(File fichero, File destino) {
        copiarFichero(fichero, destino);
        fichero.delete();
    }

    public static void copiarFichero(File d1, File d2) {
        InputStream in;
        OutputStream out;
        int len;
        byte[] buf = new byte[1024];
        try {
            in = new FileInputStream(d1);
            out = new FileOutputStream(d2);
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
            System.out.println("Copiando fichero " + d1.toString());
        } catch (IOException IOE) {
        }
    }

}
