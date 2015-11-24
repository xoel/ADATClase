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
public class Trabajador extends Persona {
    private String empresa, puesto;
    private double salario;

    public Trabajador(String nombre, int edad, Informacion informacion,String empresa, String puesto, double salario) {
        super(nombre, edad, informacion);
        this.empresa = empresa;
        this.puesto = puesto;
        this.salario = salario;
    }
    @XmlElement(name="Empresa")
    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    @XmlElement(name="Puesto")
    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    @XmlElement(name="Salario")
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    
}
