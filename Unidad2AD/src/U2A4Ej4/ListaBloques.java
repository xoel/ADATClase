/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package U2A4Ej4;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Xvazqdios
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Modulo")
@XmlType(propOrder = {"nombre","lista"})
public class ListaBloques {
    @XmlElement(name="Nome")
    String nombre;
    @XmlElementWrapper(name="contidos")
    @XmlElement(name = "Bloque")
    ArrayList<Bloque> lista;

    public ListaBloques() {
    }

    public ListaBloques(String nombre) {
        this.nombre = nombre;
        lista = new ArrayList<>();
    }

    public void add(Bloque bloque){
        lista.add(bloque);
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Bloque> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Bloque> lista) {
        this.lista = lista;
    }
    
    
    
    
    
}
