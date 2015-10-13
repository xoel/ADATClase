/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package U1A2Ej5Ej6;

import java.io.File;
import java.util.Comparator;

/**
 *
 * @author usuario
 */
class compararNombres implements Comparator<File>{


    @Override
    public int compare(File o1, File o2) {
        return o2.getName().compareTo(o1.getName());
    }
    
}
