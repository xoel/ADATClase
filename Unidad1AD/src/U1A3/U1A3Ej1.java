/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package U1A3;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Crear un programa que gener 150 0numeros aleatorios entre 20 y 80, los grabe
 * en un fichero binarios cuyo nombre sea introducido por el usuario. A
 * continuacion visualizar el contenido por pantalla, controlar errores. Si el
 * fichero existe, se visualiza mensaje para sobreescribir o cancelar la
 * escritura.
 *
 * @author usuario
 */
public class U1A3Ej1 {

    public static void main(String[] args) {
        File f = crearFichero();
        if (f == null) {
            System.out.println("Salimos.");
        } else {
            escribirFichero(f);
            visualizarFichero(f);
        }
    }

    private static File crearFichero() {
        String op, name;
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor introduzca el nombre del fichero de numeros aleatorios: ");
        name = sc.nextLine();
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
        int num;
        try {
            FileOutputStream f = new FileOutputStream(file);
            for (int i = 0; i < 150; i++) {
                num = (int) (Math.random()*(80-20+1)+20);
                f.write(num);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No se puede escribir. No se encuentra el fichero");
        } catch (IOException ex) {
            System.out.println("No es posible escribir.");
        }

    }

    private static void visualizarFichero(File file) {
        try {
            FileInputStream f = new FileInputStream(file);
            int datos;
            datos = f.read();
            while (datos != -1) {
                System.out.print(datos+",");
                datos = f.read();
            }
            f.close();
        } catch (IOException ex) {
            Logger.getLogger(U1A3Ej1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
