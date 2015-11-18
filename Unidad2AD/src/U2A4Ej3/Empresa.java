/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package U2A4Ej3;

import java.util.ArrayList;
import javax.xml.bind.annotation.*;

/**
 *
 * @author Xvazqdios
 */
//FIELD = sólo atributos públicos
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Empresa")
@XmlType(propOrder = {"cif","nombre","lista"})
public class Empresa {
    
    private String nombre;
    @XmlAttribute(name="CIF")
    private String cif;    
    @XmlElementWrapper(name="Empleados")
    @XmlElement(name = "Empleado")    
    private ArrayList<Empleado> lista;
    
    public Empresa() {
    }    
    
    public Empresa(String nombre, String cif) {
        this.nombre = nombre;
        this.cif = cif;
        lista = new ArrayList<>();
    }

    public void setLista(ArrayList<Empleado> lista) {
        this.lista = lista;
    }    
    
    public void add(Empleado empleado) {
        lista.add(empleado);
    }

    public ArrayList<Empleado> getLista() {
        return lista;
    }
     
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCif() {
        return cif;
    }
    
    public void setCif(String cif) {
        this.cif = cif;
    }

}
