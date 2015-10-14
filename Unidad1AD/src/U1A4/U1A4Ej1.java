/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package U1A4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class U1A4Ej1 {

    public static void main(String[] args) {
        int op = 0;
        Scanner sc = new Scanner(System.in);
        File f = null;
        do {
            System.out.println("Menu de Opciones");
            System.out.println("----------------");
            System.out.println("1.-Crear Archivo");
            System.out.println("2.-Anhadir registros");
            System.out.println("3.-Consultar un registro");
            System.out.println("4.-Consultar todos los registros");
            System.out.println("5.-Modificar un registro");
            System.out.println("6.-Borrar");
            System.out.println("7.-Salir");
            try {
                op = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Entrada incorrecta, escriba un entero");
            }

            switch (op) {
                case 1:
                    f = crearArchivo();
                    break;
                case 2:
                    anhadirRegistro(f);
                    break;
                case 3:
                    consultarRegistro(f);
                    break;
                case 4:
                    consultarRegistros(f);
                    break;
                case 5:
                    modificarRegistro(f);
                    break;
                case 6:
                    borrar(f);
                    break;
            }
        } while (op != 7);
    }

    /**
     * Creamos el archivo y le metemos los primeros "ficheros" en forma de
     * objetos No se puede permitir que se repita el dorsal, acabamos al
     * introducir *
     */
    private static File crearArchivo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Crear Archivo");
        File f = accederFichero();
        if (sobreEscribirFichero(f)) {
            introducirDatos(f, false);
        }
        return f;

    }

    private static void anhadirRegistro(File f) {
        introducirDatos(f, true);
    }

    private static int consultarRegistro(File f) {
        Scanner sc = new Scanner(System.in);
        int dorsal = 0;
        boolean existe = false;

        do {
            System.out.println("Escriba su dorsal");
            try {
                dorsal = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Entrada incorrecta, escriba un entero");
            }
        } while (!String.valueOf(dorsal).matches("[0-9]+"));

        try {
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(f));
            try {
                while (true) {
                    Corredor corredor = (Corredor) entrada.readObject();
                    if (corredor.getDorsal() == dorsal) {
                        System.out.println("*******************************");
                        System.out.println("Nombre: " + corredor.getNombre());
                        System.out.println("Dorsal: " + dorsal);
                        System.out.println("Tiempo: " + corredor.getTiempo());
                        System.out.println("*******************************");
                        existe = true;
                    }
                }
            } catch (IOException ex) {
                //System.out.println("Final del archivo");
                entrada.close();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(U1A4Ej1.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (!existe) {
                System.out.println("No encontrado");
            }
        } catch (IOException ex) {
            Logger.getLogger(U1A4Ej1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dorsal;
    }

    private static void consultarRegistros(File f) {
        Scanner sc = new Scanner(System.in);
        try {
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(f));
            try {
                while (true) {
                    Corredor corredor = (Corredor) entrada.readObject();
                    System.out.println("*******************************");
                    System.out.println("Nombre: " + corredor.getNombre());
                    System.out.println("Dorsal: " + corredor.getDorsal());
                    System.out.println("Tiempo: " + corredor.getTiempo());
                    System.out.println("*******************************");
                }
            } catch (IOException ex) {
                //System.out.println("Final del archivo");
                entrada.close();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(U1A4Ej1.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(U1A4Ej1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void modificarRegistro(File f) {
        String op, nombre;
        int tiempo, dorsal;
        Scanner sc = new Scanner(System.in);

        //dorsal = consultarRegistro(f);
        System.out.println("Desea Modificar algun campo? (y/n)");
        System.out.println("Solo puede cambiar el nombre y el tiempo.");
        op = sc.nextLine();
        while (!op.matches("[ynYN]")) {
            System.out.println("Entrada incorrecta.Desea Modificar algun campo? (y/n)");
            op = sc.nextLine();
        }

        if (op.matches("[Yy]")) {
            dorsal = borrar(f);
            System.out.println("Introduzca el nuevo nombre.");
            nombre = sc.nextLine();
            System.out.println("Introduzca el nuevo tiempo.");
            tiempo = sc.nextInt();
            sc.nextLine();
            try {
                MiObjectOutputStream salida = new MiObjectOutputStream(new FileOutputStream(f, true));
                salida.writeObject(new Corredor(nombre, dorsal, tiempo));
            } catch (IOException e) {
                System.err.println("Error de acceso al fichero");
            }
        }
    }

    private static int borrar(File f) {
        int dorsal = 0, tiempo;
        String nombre;
        boolean existe;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Escriba el dorsal");
            try {
                dorsal = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Entrada incorrecta, escriba un entero");
            }
        } while (!String.valueOf(dorsal).matches("[0-9]+"));
        existe = existeDorsal(f, dorsal);
        if (existe) {
            try {
                ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(f));
                File f2 = new File("C:\\Users\\usuario\\Desktop\\ADAT\\Ejercicios\\Auxiliar");
                ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(f2, false));
                try {
                    while (true) {
                        Corredor corredor = (Corredor) entrada.readObject();
                        if (corredor.getDorsal() != dorsal) {
                            salida.writeObject(new Corredor(corredor.getNombre(), corredor.getDorsal(), corredor.getTiempo()));
                        }
                    }
                } catch (IOException ex) {
                    //System.out.println("Final del archivo");
                    entrada.close();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(U1A4Ej1.class.getName()).log(Level.SEVERE, null, ex);
                }
                salida.close();
                f.delete();
                f2.renameTo(f);
            } catch (IOException ex) {
                Logger.getLogger(U1A4Ej1.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("No hay registros con ese dorsal.");
        }
        return dorsal;

    }

    private static File accederFichero() {
        String name;
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor introduzca el nombre del Archivo a crear: ");
        name = sc.nextLine();
        File f = new File("C:\\Users\\usuario\\Desktop\\ADAT\\Ejercicios\\" + name);
        return f;
    }

    private static boolean existeDorsal(File f, int dorsal) {
        boolean bool = false;
        Corredor corredor;
        try {
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(f));
            try {
                while (true) {
                    corredor = (Corredor) entrada.readObject();
                    if (corredor.getDorsal() == dorsal) {
                        bool = true;
                    }
                }
            } catch (IOException ex) {
                entrada.close();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(U1A4Ej1.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(U1A4Ej1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bool;
    }

    private static void introducirDatos(File f, boolean sobreEscribir) {
        String nombre;
        Scanner sc = new Scanner(System.in);
        int dorsal, tiempo;
        ObjectOutputStream salida;
        try {
            if (sobreEscribir) {
                salida = new MiObjectOutputStream(new FileOutputStream(f, sobreEscribir));
            } else {
                salida = new ObjectOutputStream(new FileOutputStream(f, sobreEscribir));
            }

            do {
                System.out.println("Escriba el nombre");
                nombre = sc.nextLine();
                if (!nombre.toString().equals("*")) {
                    System.out.println("Escriba el dorsal");
                    dorsal = sc.nextInt();
                    sc.nextLine();
                    while (existeDorsal(f, dorsal)) {
                        System.out.println("El dorsal ya existe, introduzca de nuevo");
                        dorsal = sc.nextInt();
                        sc.nextLine();
                    }
                    System.out.println("Escriba el tiempo");
                    tiempo = sc.nextInt();
                    sc.nextLine();
                    salida.writeObject(new Corredor(nombre, dorsal, tiempo));
                }
            } while (!nombre.toString().equals("*"));
            salida.close();
        } catch (NullPointerException e) {
            System.out.println("Excepcion de puntero nulo.");
        } catch (FileNotFoundException ex) {
            System.out.println("No acceso al fichero");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private static boolean sobreEscribirFichero(File f) {
        Scanner sc = new Scanner(System.in);
        String op;
        if (f.exists()) {
            System.out.println("El fichero ya existe. Sobreescribir? (y/n)");
            op = sc.nextLine();
            while (!op.matches("[ynYN]")) {
                System.out.println("Entrada incorrecta.El fichero ya existe. Sobreescribir? (y/n)");
                op = sc.nextLine();
            }
            return op.matches("[yY]");
        } else {
            return true;
        }
    }
}
