/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package U2A4Ej5;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Xvazqdios
 */
//@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Personas")
public class Personas {
    private ArrayList<Persona> listaPersonas;

    public Personas() {
        listaPersonas= new ArrayList<>();
    }

    public Personas(ArrayList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }
    
    public void add(Persona persona){
        listaPersonas.add(persona);
    }

    @XmlElements({
        @XmlElement(name="Estudiante", type=Estudiante.class),
        @XmlElement(name="Trabajador", type=Trabajador.class)
    })
    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(ArrayList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }
    
     
    
}
