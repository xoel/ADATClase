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
class Direccion {
   private String calle,localidad,provincia;
   private int numero;

    public Direccion(String calle,int numero, String localidad, String provincia) {
        this.calle = calle;
        this.localidad = localidad;
        this.provincia = provincia;
        this.numero = numero;
    }
    @XmlElement(name="Calle")
    public String getCalle() {
        return calle;
    }
    @XmlElement(name="Localidad")
    public String getLocalidad() {
        return localidad;
    }
    @XmlElement(name="Provincia")
    public String getProvincia() {
        return provincia;
    }
    @XmlElement(name="Numero")
    public int getNumero() {
        return numero;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
   
   
   
}
