/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package U2A4Ej5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;

/**
 *
 * @author Xvazqdios
 */
class Informacion {

    private Direccion direccion;
    private Set<Integer> listaTelf;

    public Informacion(Direccion direccion) {
        this.direccion = direccion;
        this.listaTelf = new HashSet();
    }

    public Informacion(Direccion direccion, Set<Integer> listaTelf) {
        this.direccion = direccion;
        this.listaTelf = listaTelf;
    }     

    public void add(int telefono) {
        listaTelf.add(telefono);
    }
    @XmlElement(name = "Direccion")
    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    @XmlElement(name = "Telefonos")
    @XmlList()
    public Set <Integer> getListaTelf() {
        return listaTelf;
    }

    public void setListaTelf(Set <Integer> listaTelf) {
        this.listaTelf = listaTelf;
    }

}
