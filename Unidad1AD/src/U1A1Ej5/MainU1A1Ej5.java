package U1A1Ej5;


import java.io.*;
import java.util.*;


public class MainU1A1Ej5 {
    
    static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream salida = null;

    public static void main(String[] args) {

        abrirFichero();
        System.out.print("Introduce el numero de enteros positivos para grabar en el fichero: ");
        int num = leerPositivo();
        for (int i = 1; i <= num; i++) {
            System.out.println("Numero " + i + ":");
            grabarFichero(leerPositivo());
        }
        cerrarFichero();
        leerFichero();
    }

    static void abrirFichero() {
        try{
        salida=new PrintStream("D:/FicheroPositivos.txt");
        }
        catch(FileNotFoundException e){
            System.out.println("Fichero no encontrado");
        }
    }


    static void grabarFichero(int i) {
        salida.print(i+";");
    }

    private static void cerrarFichero() {
        if (salida!=null) {
            salida.close();
        }
    }

    private static void leerFichero() {
        Scanner entrada=null;
        File fichero = new File("D:/FicheroPositivos.txt");
        try{
        entrada=new Scanner (fichero);
        entrada.useDelimiter(";");
            System.out.println("LECTURA DEL ARCHIVO");
            boolean s = true;
            while(s){
                try{
                    System.out.print(entrada.nextInt()+", ");
                }catch(NoSuchElementException y){
                    System.out.println("");
                    System.out.println("FIN DE ARCHIVO");
                    s=false;
                }
            }
                
        }
        catch(FileNotFoundException e){
            System.out.println("Fichero no encontrado");
        }
    }
    
    public static int leerPositivo(){
        boolean positivo=false;
        int num = 0;
        Scanner sc = new Scanner(System.in);
        while(positivo==false){
            try{            
                num=esPositivo(sc.nextInt());
                positivo=true;
            }catch(positiveException e){
                System.out.println(e.getMessage());
            }
        }
        return num;
    }
    
    public static int esPositivo(int num) throws positiveException{
        if(num<0){
            throw new positiveException("Numero introducido no positivo"); 
        }else return num;
    }
}
