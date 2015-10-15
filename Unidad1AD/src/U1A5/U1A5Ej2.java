/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package U1A5;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StreamTokenizer;

/**
 *
 * @author usuario
 */
public class U1A5Ej2 {

    public static void main(String[] args) {
        FileReader r, r2;
        FileWriter salida;
        File f, f2;
        int numPalabras=0;
        try {
            salida = new FileWriter("C:\\Users\\usuario\\Desktop\\ADAT\\Ejercicios\\ContadorPalabras.txt", false);
            f = new File("C:\\Users\\usuario\\Desktop\\ADAT\\Ejercicios\\palabrasClave.txt");
            r = new FileReader(f);
            f2 = new File("C:\\Users\\usuario\\Desktop\\ADAT\\Ejercicios\\palabras.txt");
            r2 = new FileReader(f2);
            StreamTokenizer tokens = new StreamTokenizer(r);
            StreamTokenizer tokens2;
            //bucle que recorra cada linea y aumente el contador            
            while (tokens.nextToken() != StreamTokenizer.TT_EOF) {
                if (tokens.ttype == StreamTokenizer.TT_WORD) {
                    tokens2 = new StreamTokenizer(new FileReader(f2));
                    numPalabras=0;
                    while (tokens2.nextToken() != StreamTokenizer.TT_EOF) {
                        if (tokens.ttype == StreamTokenizer.TT_WORD) {
                            //si el token de la lista de palbras es igual
                            //al token del texto aumentamos contador
                            if(tokens.sval.equals(tokens2.sval)) {
                                numPalabras++;
                            }
                        }
                    }
                    salida.write(tokens.sval+" : "+numPalabras+", ");
                }
            }
            r.close();
            r2.close();
            salida.close();
        } catch (IOException ex) {
            System.out.println("IOException 2");
        }
    }

}
