/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package U2A4Ej5;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Xvazqdios
 */
public class MainJABX {
    public static JAXBContext contexto = null;
    public static Marshaller m = null;
    
    public static void main(String[] args) {
        Set <Integer> telefonos = new HashSet();
        telefonos.add(986865665);
        telefonos.add(96871133);
        
        Estudiante estudiante = new Estudiante("Angel Rodriguez",23,
        new Informacion(new Direccion("Luna",6,"Pontevedra","Pontevedra"),telefonos),"Informatica","Santiago");
        
        Trabajador trabajador = new Trabajador("Manuel Sanchez",45,
        new Informacion(new Direccion("Nube",16,"pontevedra","pontevedra"),telefonos/*new ArrayList<Integer>(int[]={123,234})*/),"El tornillo","Gerente",2000.00);
        
        Personas listaPersonas = new Personas();        
        listaPersonas.add(estudiante);
        listaPersonas.add(trabajador);
        
        try {
            //creamos el contexto de empresa
            contexto = JAXBContext.newInstance(Personas.class);
            //lo marshelamos
            m = contexto.createMarshaller();
            //Definimos las propiedades del Marshaller
            //Con esta le decimos que le damos sangrias y tabuladores al XML de salida
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            //Le damos espacio de nombre
            //m.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "empresa.xsd");
            //Salida del XML por pantalla
            m.marshal(listaPersonas, System.out);
            //mapear a un fichero
            Writer w = new FileWriter("Personas.xml");
            m.marshal(listaPersonas, w);
        } catch (JAXBException ex) {
            System.err.println("Error al crear el Marshaeller: " + ex);
        } catch (IOException ex) {
            System.err.println("IO Exception: " + ex);
        }
    }
    
}
