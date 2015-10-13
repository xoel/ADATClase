/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package U1A3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
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
public class U1A3Ej4 {

    public static void main(String[] args) {

        System.out.println("Creamos el primer Fichero Num1.dat");
        File f = crearFichero("Num1.dat");
        try {
            escribirFichero(f);
        } catch (NullPointerException e) {
            System.out.println("Continuamos");
        }
        System.out.println("Creamos el segundo Fcihero Num2.dat");
        File f2 = crearFichero("Num2.dat");
        try {
            escribirFichero(f2);
        } catch (NullPointerException e) {
            System.out.println("Continuamos");
        }
        System.out.println("Mezclamos y ordenamos ambos archivos");
        leerFichero(ordenar(f, f2));
    }

    private static File crearFichero(String name) {
        String op;
        Scanner sc = new Scanner(System.in);
        File f = new File("C:\\Users\\usuario\\Desktop\\ADAT\\Ejercicios\\" + name);
        if (f.exists()) {
            System.out.println("El fichero ya existe. ¿Sobreescribir? (y/n)");
            op = sc.nextLine();
            while (!op.matches("[ynYN]")) {
                System.out.println("Entrada incorrecta.El fichero ya existe. ¿Sobreescribir? (y/n)");
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

    private static File ordenar(File f, File f2) {
        int datos1, datos2;
        boolean cont = true;
        File file = crearFichero("Mezcla.dat");
        try {
            DataInputStream salida1 = new DataInputStream(new FileInputStream(f));
            DataInputStream salida2 = new DataInputStream(new FileInputStream(f2));
            DataOutputStream entrada = new DataOutputStream(new FileOutputStream(file));

            datos1 = salida1.read();
            datos2 = salida2.read();
            System.out.println(datos1+" "+datos2);
            while (cont) {
                if (datos1 <= datos2) {
                    entrada.write(datos1);
                    try {
                        datos1 = salida1.read();
                    } catch (EOFException e) {
                        System.out.println("Archivo uno acabado");
                        try {
                            while (true) {
                                datos2 = salida2.read();
                                entrada.write(datos2);
                            }
                        } catch (EOFException eX) {
                            System.out.println("Archivo uno y dos acabado");
                            cont = false;
                        }
                    }
                } else {
                    entrada.write(datos2);
                    try {
                        datos2 = salida2.read();
                    }catch (EOFException e) {
                        System.out.println("Archivo dos acabado");
                        try {
                            while (true) {
                                datos1 = salida1.read();
                                entrada.write(datos1);
                            }
                        } catch (EOFException eX) {
                            System.out.println("Archivo uno y dos acabado");
                            cont = false;
                        }
                    }
                }
            }
            salida1.close();
            salida2.close();
            entrada.close();
        } catch (IOException ex) {
            Logger.getLogger(U1A3Ej1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return file;
    }
}
