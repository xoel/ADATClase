/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package U2A4Ej5;

import javax.xml.bind.annotation.*;

/**
 *
 * @author Xvazqdios
 */
@XmlType(propOrder = {"nombre","edad","informacion"})
public class Persona {
    private String nombre;
    private int edad;
    private Informacion informacion;

    public Persona(String nombre, int edad, Informacion informacion) {
        this.nombre = nombre;
        this.edad = edad;
        this.informacion = informacion;
    }    
    @XmlElement(name="Nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @XmlElement(name="Edad")
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    @XmlElement(name="Informacion")
    public Informacion getInformacion() {
        return informacion;
    }

    public void setInformacion(Informacion informacion) {
        this.informacion = informacion;
    }
}
