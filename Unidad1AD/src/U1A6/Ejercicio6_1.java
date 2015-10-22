/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package U1A6;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Ejercicio6_1 {

    static Scanner in;

    public static void main(String[] args) throws IOException {
        in = new Scanner(System.in);
        RandomAccessFile numeros = null;
        try {
            numeros = new RandomAccessFile("enteros.dat", "rw");
            introduceNumeros(numeros);
            modificaArchivo(numeros);
            muestraNumeros(numeros);
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        }

    }

    public static void modificaArchivo(RandomAccessFile fichero) {
 int pos, numero;
        long size;
        try {

            //calcular cuántos enteros tiene el fichero
            size = fichero.length();
            size = size / 4;
            System.out.println("El fichero tiene " + size + " enteros");

            //Modificar el entero que se encuentra en una posición determinada
            do {
                System.out.println("Introduce una posición (>=1 y <= " + size + "): ");
                pos = in.nextInt();
            } while (pos < 1 || pos > size);

            pos--;  //la posición 1 realmente es la 0
           
            //nos situamos en la posición (byte de inicio) del entero a modificar
            //en Java un entero ocupa 4 bytes
            fichero.seek(pos*4);

            //leemos y mostramos el valor actual
            System.out.println("Valor actual: " + fichero.readInt());
           
            //pedimos que se introduzca el nuevo valor
            System.out.println("Introduce nuevo valor: ");
            numero = in.nextInt();

            //nos situamos de nuevo en la posición del entero a modificar
            //esto es necesario porque después de la lectura que hemos realizado para mostrar
            //el valor el puntero de lectura/escritura ha avanzado al siguiente entero del fichero.
            //si no hacemos esto escribiremos sobre el siguiente entero
            fichero.seek(pos*4);

            //escribimos el entero
            fichero.writeInt(numero);

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static void introduceNumeros(RandomAccessFile archivo) throws IOException {
        int num;
        boolean salir = false;
        while (!salir) {

            System.out.println("");
            try {
                archivo.seek(archivo.length());
                System.out.println("Introduce un numero: ");
                num = Integer.parseInt(in.nextLine());
                archivo.writeInt(num);
                muestraNumeros(archivo);
            } catch (NumberFormatException E) {
                salir = true;

            }
        }
    }

    public static void muestraNumeros(RandomAccessFile archivo) {
        try {
            archivo.seek(0L);
            int numero;
            numero = archivo.readInt();
            System.out.println("");
            System.out.print("Numeros introducidos: \t");
            try {
                while (true) {
                    System.out.print(numero + " ");
                    numero = archivo.readInt();
                }
            } catch (IOException e) {
                System.out.println("");
            }
        } catch (IOException E) {
            System.out.println("Error E/L");
        }
    }
}
