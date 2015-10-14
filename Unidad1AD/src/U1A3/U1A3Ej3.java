/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package U1A3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class U1A3Ej3 {

    public static void main(String[] args) {
        File f = crearFichero();
        try {
            escribirFichero(f);
            leerFichero(f);
        } catch (NullPointerException e) {
            System.out.println("Saliendo");
        }
    }

    private static File crearFichero() {
        String op, name;
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor introduzca el nombre del fichero de numeros aleatorios: ");
        name = sc.nextLine();
        File f = new File("C:\\Users\\usuario\\Desktop\\ADAT\\Ejercicios\\" + name);
        if (f.exists()) {
            System.out.println("El fichero ya existe. Sobreescribir? (y/n)");
            op = sc.nextLine();
            while (!op.matches("[ynYN]")) {
                System.out.println("Entrada incorrecta.El fichero ya existe. �Sobreescribir? (y/n)");
                op = sc.nextLine();
            }
            if (op.matches("[nN]")) {
                return null;
            } else {
                return f;
            }
        } else {
            return f;
        }
    }

    private static void escribirFichero(File file) {
        int actual;
        int min = Integer.MIN_VALUE;
        Scanner sc = new Scanner(System.in);
        try {
            DataOutputStream salida = new DataOutputStream(new FileOutputStream(file));
            try {
                do {
                    System.out.println("Introduzca un numero o un caracter para salir.");
                    actual = sc.nextInt();
                    if (actual > min) {
                        min = actual;
                        salida.write(actual);
                    } else {
                        try {
                            throw new MissSecuenceException();
                        } catch (MissSecuenceException e) {
                            System.err.println(e.getMessage());
                        }
                    }
                } while (true);

            } catch (InputMismatchException ex) {
                System.out.println("saliendo.");
            } catch (IOException ex) {
                Logger.getLogger(U1A3Ej3.class.getName()).log(Level.SEVERE, null, ex);
            }
            salida.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error: " + ex);
        } catch (IOException ex) {
            Logger.getLogger(U1A3Ej3.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void leerFichero(File file) {
        try {
            DataInputStream salida = new DataInputStream(new FileInputStream(file));
            int datos;
            datos = salida.read();
            while (datos != -1) {
                System.out.print(datos + ",");
                datos = salida.read();
            }
            salida.close();
        } catch (IOException ex) {
            Logger.getLogger(U1A3Ej1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
