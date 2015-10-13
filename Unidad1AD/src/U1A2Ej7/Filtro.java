/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package U1A2Ej7;

import java.io.File;
import java.io.FilenameFilter;



/**
 *
 * @author usuario
 */
public class Filtro implements FilenameFilter{
    String extension;
    public Filtro(String extension) {
        this.extension=extension;
    }

    @Override
    public boolean accept(File dir, String name) {
        return dir.isDirectory()||name.contains(extension);
    }
    
    
}
