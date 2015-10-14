/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package U1A5;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class U1A5Ej1 {

    public static void main(String[] args) {
        FileReader r;
        try {
            FileWriter salida = new FileWriter("C:\\Users\\usuario\\Desktop\\ADAT\\Ejercicios\\Salida.txt");
        } catch (IOException ex) {
            System.err.println("No se pudo acceder al fichero");
        }
        for (String fichero : args) {
            try {
                r = new FileReader(fichero);
                StreamTokenizer tokens = new StreamTokenizer(r);
                while (tokens.nextToken() != StreamTokenizer.TT_EOF) {
                    if (tokens.ttype == StreamTokenizer.TT_WORD) {
                        System.out.println(tokens.sval);
                    } else if (tokens.ttype == StreamTokenizer.TT_NUMBER) {
                        System.out.println((int) tokens.nval);
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(U1A5Ej1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(U1A5Ej1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
