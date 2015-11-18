/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package U2A4Ej3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Xvazqdios
 */
public class MainJAXB {

    public static JAXBContext contexto = null;
    public static Marshaller m = null;

    public static void main(String[] args) {
        Empresa empresa = new Empresa("Xoia Software Development","76930837t");
        empresa.add(new Empleado("xoel","76930837t",27));
        empresa.add(new Empleado("Manolo","76930837t",28));
        empresa.add(new Empleado("Paco","76930837t",29));
        empresa.add(new Empleado("Arfonso","76930837t",30));
        try {
            contexto = JAXBContext.newInstance(Empresa.class);
            m = contexto.createMarshaller();
            //Definimos las propiedades del Marshaller
            //Con esta le decimos que le damos sangrias y tabuladores al XML de salida
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            //Le damos espacio de nombre
            //m.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "empresa.xsd");
            //Salida del XML por pantalla
            m.marshal(empresa, System.out);
            //mapear a un fichero
            Writer w = new FileWriter("Empresa.xml");
            m.marshal(empresa, w);
        } catch (JAXBException ex) {
            System.err.println("Error al crear el Marshaeller: " + ex);
        } catch (IOException ex) {
            System.err.println("IO Exception: " + ex);
        }

    }

}
