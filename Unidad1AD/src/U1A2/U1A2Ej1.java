/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package U1A2;

import java.io.File;

/**
 *
 * @author usuario
 */
public class U1A2Ej1 {
    public static void main(String[] args) {
        
        
        System.out.println("--- LISTANDO UNIDADES ---");
        File[] froots= File.listRoots();
        for (File f: froots) {
            infoDisco(f.getAbsolutePath());
        }
        
    }
    public static void infoDisco(String ruta){
        File f= new File(ruta);
        System.out.println("Unidad "+ruta);
        System.out.println("    Espacio libre: "+f.getFreeSpace()+" bytes ("+(float)(f.getFreeSpace()/1000000000)+" GB)");
        System.out.println("    Espacio ocupado: "+(f.getTotalSpace()-f.getFreeSpace())+" bytes ("+(float)((f.getTotalSpace()-f.getFreeSpace())/1000000000)+" GB)");
        System.out.println("    Espacio total: "+f.getTotalSpace()+" bytes ("+(float)(f.getTotalSpace()/1000000000)+" GB)");
    }
    
}
