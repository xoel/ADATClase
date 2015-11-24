/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package U2A4Ej4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Xvazqdios
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"sesiones","num","titulo","descripcion"})
public class Bloque {
    @XmlAttribute(name="sesións")
    private int sesiones;
    @XmlAttribute(name="num")
    private int num;
    @XmlElement(name = "Titulo") 
    private String titulo;
    @XmlElement(name = "Descripción") 
    private String descripcion;

    public Bloque() {
    }

    public Bloque(int sesiones, int num, String titulo, String descripcion) {
        this.sesiones = sesiones;
        this.num = num;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public int getSesiones() {
        return sesiones;
    }

    public void setSesiones(int sesiones) {
        this.sesiones = sesiones;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Bloque{" + "\n\tsesiones=" + sesiones + "\n\tnum=" + num + "\n\ttitulo=" + titulo + "\n\tdescripcion=" + descripcion + "\n}";
    }
    
    
    
    
}
