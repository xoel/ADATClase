/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package U1A5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StreamTokenizer;

/**
 *
 * @author usuario
 */
public class U1A5Ej1 {

    public static void main(String[] args) {
        FileReader r;
        FileWriter salida;
        File f;
        int numLineas;
        try {
            salida = new FileWriter("C:\\Users\\usuario\\Desktop\\ADAT\\Ejercicios\\Salida.txt", false);
            for (String fichero : args) {
                try {
                    System.out.println(fichero);
                    f = new File("C:\\Users\\usuario\\Desktop\\ADAT\\Ejercicios\\" + fichero);
                    if (f.getName().matches("\\w+.txt")) {
                        r = new FileReader(f);
                        StreamTokenizer tokens = new StreamTokenizer(r);
                        //bucle que recorra cada linea y aumente el contador

                        numLineas = 0;
                        while (tokens.nextToken() != StreamTokenizer.TT_EOF) {
                            //TODO NO ME LEE EL PUTO EOL, las palabras si pero EOL no, WHY?
                            if (tokens.ttype == StreamTokenizer.TT_EOL) {
                                numLineas++;
                                System.out.println("NumLineas por iteracion " + numLineas);
                            }
                        }
                        System.out.println("NumLineas totales " + numLineas);
                        salida.write("Nombre Fichero: " + fichero + " Num. Lineas: " + numLineas + ", ");
                        r.close();
                    } else {
                        System.out.println("No es un txt");
                        salida.write("Nombre Fichero: " + fichero + " No es un text, ");
                    }

                } catch (FileNotFoundException ex) {
                    System.out.println("file not found");
                    salida.write("Nombre Fichero: " + fichero + " Error, fichero no encontrado, ");
                } catch (IOException ex) {
                    System.out.println("Io exception");
                    salida.write("Nombre Fichero: " + fichero + " Error, IO exception, ");
                }
            }
            salida.close();
        } catch (IOException ex) {
            System.out.println("Io exception 2");
        }
    }
}
