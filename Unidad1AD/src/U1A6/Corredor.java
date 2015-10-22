/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package U1A6;

import java.io.Serializable;

/**
 *
 * @author usuario
 */
public class Corredor implements Serializable {
    String nombre;
    int dorsal;
    String tiempo;
    Boolean borrado;

    public Corredor(String nombre, int dorsal, String tiempo,Boolean borrado) {
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.tiempo = tiempo;
        this.borrado=borrado;
    }

    public String getNombre() {
        return nombre;
    }

    public Boolean getBorrado() {
        return borrado;
    }

    public void setBorrado(Boolean borrado) {
        this.borrado = borrado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    
}
