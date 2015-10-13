/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package U1A4;

import java.io.Serializable;

/**
 *
 * @author usuario
 */
public class Corredor implements Serializable{
    private String nombre;
    private int dorsal, tiempo;

    public Corredor(String nombre, int dorsal, int tiempo) {
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.tiempo = tiempo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDorsal() {
        return dorsal;
    }

    public int getTiempo() {
        return tiempo;
    }
    
    
}
