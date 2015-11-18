/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package U2A4Ej3;

import javax.xml.bind.annotation.*;

/**
 *
 * @author Xvazqdios
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"dni","nombre","edad"})
public class Empleado {
    String nombre, dni;
    int edad;

    public Empleado(String nombre, String dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public Empleado() {
    }   
    @XmlElement(name="Nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @XmlElement(name="Dni")
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    @XmlElement(name="Edad")
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
      
    
}
