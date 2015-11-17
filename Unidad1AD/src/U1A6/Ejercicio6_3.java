/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package U1A6;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Ejercicio6_3 {

    static Scanner in;

    public static void main(String[] args) throws IOException {
        in = new Scanner(System.in);
        int opc;
        boolean existe = false;
        try {
            do {
                RandomAccessFile corredores;
                File archivo = new File("Corredores.dat");
                System.out.println("Menú de opciones");
                System.out.println("-----------------");
                System.out.println("1.-Añadir registros");
                System.out.println("2-.Consultar un registro");
                System.out.println("3-.Consultar todos los registros");
                System.out.println("4-. Modificar un registro");
                System.out.println("5-. Borrar");
                System.out.println("6.-Salir");
                System.out.println("Elige una opcion <1-7>");
                opc = in.nextInt();
                if (opc == 1) {
                    corredores = compruebaArchivo(archivo);
                    escribeRegistro(corredores, existe);

                }

                if (opc == 2) {
                    corredores = new RandomAccessFile(archivo, "rw");
                    System.out.println("Introduce un dorsal: ");
                    int registroConsulta = in.nextInt();
                    consultaRegistro(corredores, registroConsulta);
                }

                if (opc == 3) {
                    System.out.println("Mostrando todos los registros...");
                    corredores = new RandomAccessFile(archivo, "r");
                    mostrarRegistros(corredores);
                }
                if (opc == 4) {
                    corredores = new RandomAccessFile(archivo, "rw");
                    modificaRegistro(corredores);

                }
                if (opc == 5) {
                    corredores = new RandomAccessFile(archivo, "rw");
                    borraRegistro(corredores);
                }
                if (opc == 6) {
                    System.out.println("");
                    borraAlSalir(archivo);
                    System.err.println("¡HA ELEGIDO SALIR DEL PROGRAMA!");
                }
            } while (opc != 6);
        } catch (FileNotFoundException e) {
            System.out.println("Error al encontrar el archivo");
        }

    }

    public static RandomAccessFile compruebaArchivo(File archivo) throws FileNotFoundException {
        boolean exi;
        RandomAccessFile corredores;
        if (!archivo.exists()) {
            System.out.println("El archivo no existe");
        } else {
            System.out.println("El archivo existe");
        }
        corredores = new RandomAccessFile(archivo, "rw");
        return corredores;
    }

    public static void escribeRegistro(RandomAccessFile corredores, boolean existe) throws FileNotFoundException {
        String nombre = "";
        String tiempo = "";
        int dorsal = 0;
        int desplazamiento = 0;
        boolean borrado = false;
        ArrayList<Integer> dorsales = new ArrayList();
        try {
            do {
                in.nextLine();
                System.out.println("Introduce nombre: ");
                nombre = in.nextLine();
                if (!nombre.equals("*")) {
                    System.out.println("Introduce el dorsal:");
                    dorsal = Integer.parseInt(in.nextLine());
                    while (verificaDorsal(dorsales, dorsal)) {
                        System.out.println("Introduce el dorsal de nuevo:");
                        dorsal = Integer.parseInt(in.nextLine());

                    }
                    dorsales.add(dorsal);
                    System.out.println("Introduce el tiempo");
                    tiempo = in.nextLine();
                    Corredor corredor = new Corredor(nombre, dorsal, tiempo, borrado);
                    int Nreg = (int) Math.ceil((double) corredores.length() / 80);
                    desplazamiento = Nreg;
                    corredores.seek(desplazamiento * 80);
                    corredores.writeUTF(corredor.getNombre());
                    corredores.writeInt(corredor.getDorsal());
                    corredores.writeUTF(corredor.getTiempo());
                    corredores.writeBoolean(corredor.getBorrado());
                    desplazamiento++;
                }
            } while (!nombre.equals("*"));
        } catch (IOException F) {
            System.out.println("Error de E/L");
        }
    }

    public static void mostrarRegistros(RandomAccessFile corredores) {
        try {
            String nombre, tiempo;
            int dorsal;
            int desplazamiento = 0;
            boolean borrado;
            while (true) {
                corredores.seek(desplazamiento * 80);
                nombre = corredores.readUTF();
                dorsal = corredores.readInt();
                tiempo = corredores.readUTF();
                borrado = corredores.readBoolean();
                System.out.println("Nombre: " + nombre + " Dorsal: " + dorsal + " Tiempo: " + tiempo + " Borrado: " + borrado);
                desplazamiento++;
            }
        } catch (EOFException E) {
            System.out.println("Fin de archivo.");
        } catch (IOException ex) {
            System.out.println("Error al mostrar los registros");
        }

    }

    public static void consultaRegistro(RandomAccessFile corredores, int registroConsulta) throws IOException {
        String nombre, nombre2 = "", tiempo2 = "", tiempo;
        int dorsal, dorsal2 = 0, cont = 0;
        boolean borrado;
        try {

            int desplazamiento = 0;
            while (true) {
                corredores.seek(desplazamiento * 80);
                nombre = corredores.readUTF();
                dorsal = corredores.readInt();
                tiempo = corredores.readUTF();
                borrado = corredores.readBoolean();
                if (desplazamiento == registroConsulta && !borrado) {
                    nombre2 = nombre;
                    tiempo2 = tiempo;
                    dorsal2 = dorsal;
                    cont++;
                }
                desplazamiento++;
            }
        } catch (EOFException E) {
            corredores.close();
            if (cont != 0) {
                System.out.println("Nombre " + nombre2 + "\tTiempo: " + tiempo2 + "\tDorsal: " + dorsal2);
            } else {
                System.out.println("No hay corredores con ese dorsal");
            }
            System.out.println("Fin de archivo.");
        } catch (IOException ex) {
            System.out.println("Error al mostrar los registros");
        }

    }

    public static void modificaRegistro(RandomAccessFile corredores) {
        try {
            int registro = 0;
            boolean borrado = false;
            int Nreg = (int) Math.ceil((double) corredores.length() / 80);
            System.out.println("Hay " + Nreg + " registros");
            do {
                System.out.println("Introduce un numero de registro a modificar: ");
                registro = in.nextInt();
            } while (registro < 0 && registro > Nreg);
            System.out.println("El registro elegido es el " + registro);
            corredores.seek((registro - 1) * 80);
            in.nextLine();
            System.out.println("Introduce nombre: ");
            String nombre = in.nextLine();
            System.out.println("Introduce el dorsal: ");
            int dorsal = Integer.parseInt(in.nextLine());
            System.out.println("Introduce el tiempo: ");
            String tiempo = in.nextLine();
            Corredor corredor = new Corredor(nombre, dorsal, tiempo, borrado);
            corredores.writeUTF(corredor.getNombre());
            corredores.writeInt(corredor.getDorsal());
            corredores.writeUTF(corredor.getTiempo());
            corredores.writeBoolean(corredor.getBorrado());
            corredores.close();
        } catch (IOException ex) {
            System.out.println("Error con el RandomAccess");
        }

    }

    public static void borraRegistro(RandomAccessFile corredores) {
        try {
            int registro = 0;
            boolean borrado = true;
            int Nreg = (int) Math.ceil((double) corredores.length() / 80);
            System.out.println("Hay " + Nreg + " registros");
            do {
                System.out.println("Introduce un numero de registro a borrar: ");
                registro = in.nextInt();
                registro = registro - 1;
            } while (registro < 0 && registro > Nreg);
            System.out.println("El registro elegido es el " + (registro + 1));
            corredores.seek(registro * 80);
            Corredor corredor = new Corredor(corredores.readUTF(), corredores.readInt(), corredores.readUTF(), borrado);
            corredores.seek(registro * 80);
            corredores.writeUTF(corredor.getNombre());
            corredores.writeInt(corredor.getDorsal());
            corredores.writeUTF(corredor.getTiempo());
            corredores.writeBoolean(corredor.getBorrado());
            corredores.close();
        } catch (IOException ex) {
            System.out.println("Error con el RandomAccess");
        }

    }

    public static boolean verificaDorsal(ArrayList<Integer> dorsales, int dorsal) {
        boolean presente = false;
        for (int i = 0; i < dorsales.size(); i++) {
            if (dorsal == dorsales.get(i)) {
                presente = true;
            }
        }
        return presente;
    }

    public static void borraAlSalir(File archivo) throws FileNotFoundException, IOException {
        File aux = new File("aux.dat");
        RandomAccessFile corredores = new RandomAccessFile (archivo,"rw");
        RandomAccessFile aux2 = new RandomAccessFile (aux,"rw");
        try {
            int desplazamiento=0,desplazamiento2=0;
            while (true) {
            corredores.seek(desplazamiento*80);
            corredores.readUTF();
            corredores.readInt();
            corredores.readUTF();
            corredores.readBoolean();
            
            if (!corredores.readBoolean()){
                aux2.seek(desplazamiento2*80);
                aux2.writeUTF(corredores.readUTF());
                aux2.writeInt(corredores.readInt());
                aux2.writeUTF(corredores.readUTF());
                aux2.writeBoolean(corredores.readBoolean());
                desplazamiento2++;
            }
           desplazamiento++;
        }
        } catch (EOFException EX){
                corredores.close();
                aux2.close();
                archivo.delete();
                aux.renameTo(new File ("Corredores.dat"));
            System.out.println("Fin del archivo.");
            
        }catch (IOException e) {
        
        }
        
    }
}
