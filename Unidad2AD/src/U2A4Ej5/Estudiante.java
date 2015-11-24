/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package U2A4Ej5;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Xvazqdios
 */
public class Estudiante extends Persona{
    
    private String carrera,universidad;
    
    public Estudiante(String nombre, int edad, Informacion informacion,String universidad,String carrera) {
        super(nombre, edad, informacion);
        this.carrera=carrera;
        this.universidad=universidad;
    }
    @XmlElement(name="Universidad")
    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }
    
    @XmlElement(name="Carrera")
    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    

    
    
    
}
