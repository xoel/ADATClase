/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package U1A6Michi;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 *
 * @author Miguel
 */
public class Ejercicio6_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RandomAccessFile fichero = null;
        String palabra, cadena;
        StringBuilder auxBuilder;
        long pos = 0;
        int indice;
        try {
            //se abre el fichero para lectura/escritura
            fichero = new RandomAccessFile("/ficheros/texto.txt", "rw");

            //Se pide la palabra a buscar
            System.out.print("Introduce palabra: ");
            palabra = sc.nextLine();

            //lectura del fichero
            cadena = fichero.readLine(); //leemos la primera línea
            while (cadena != null) {         //mientras no lleguemos al final del fichero
                indice = cadena.indexOf(palabra); //buscamos la palabra en la línea leída
                while (indice != -1) { //mientras la línea contenga esa palabra (por si está repetida)

                    //paso la línea a un StringBuilder para modificarlo
                    auxBuilder = new StringBuilder(cadena);
                    auxBuilder.replace(indice, indice + palabra.length(), palabra.toUpperCase());
                    cadena = auxBuilder.toString();

                    //nos posicionamos al principio de la línea actual y se sobrescribe la
                    //línea completa
                    //La posición donde empieza la línea actual la estoy guardando
                    //en la variable pos
                    fichero.seek(pos);
                    fichero.writeBytes(cadena);

                    //compruebo si se repite la misma palabra en la línea
                    indice = cadena.indexOf(palabra);
                }
                pos = fichero.getFilePointer(); //posición de la línea actual que voy a leer
                cadena = fichero.readLine();    //lectura de la línea
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
