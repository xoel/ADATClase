/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package U1A3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class U1A3Ej2 {

    public static void main(String[] args) {
        String name;
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer, Integer> mapaNum = new TreeMap<>();

        System.out.println("Por favor introduzca el nombre del fichero de numeros aleatorios: ");
        name = sc.nextLine();
        File file = new File("C:\\Users\\usuario\\Desktop\\ADAT\\Ejercicios\\"+name);
        //System.out.println(file.canWrite());
        try {
            FileInputStream f = new FileInputStream(file);
            int datos;
            datos = f.read();
            while (datos != -1) {
                if (!mapaNum.containsKey(datos)) {
                    mapaNum.put(datos, 1);
                }else{
                    mapaNum.put(datos, mapaNum.get(datos)+1);
                }
                datos = f.read();
            }
            f.close();
        } catch (IOException ex) {
            Logger.getLogger(U1A3Ej1.class.getName()).log(Level.SEVERE, null, ex);
        }
        //sacara los que tienen mayor y menor incicendia
        System.out.println("Relacion numeros-incidencia de salida:");
        System.out.println(mapaNum.entrySet());
        System.out.println("Numeros con mayor incidencia de salida:");
        int mayor =0;
        String keyMayor="";
        for (Map.Entry entry : mapaNum.entrySet()) {
            if(Integer.parseInt(entry.getValue().toString())>mayor){
                mayor=Integer.parseInt(entry.getValue().toString());
                keyMayor=entry.getKey().toString();
            }else if(Integer.parseInt(entry.getValue().toString())==mayor){
                keyMayor=keyMayor.concat(","+entry.getKey().toString());
            }
        }       
        System.out.println("Numero: "+keyMayor+", incidencia maxima: "+mayor);
        System.out.println("Numeros con menor incidencia de salida:");
        int menor =150;
        String keyMenor="";
        for (Map.Entry entry : mapaNum.entrySet()) {
            if(Integer.parseInt(entry.getValue().toString())<menor){
               menor=Integer.parseInt(entry.getValue().toString());
                keyMenor=entry.getKey().toString();
            }else if(Integer.parseInt(entry.getValue().toString())==menor){
                keyMenor=keyMenor.concat(","+entry.getKey().toString());
            }
        }       
        System.out.println("Numero: "+keyMenor+", incidencia maxima: "+menor);
        
    }

}
