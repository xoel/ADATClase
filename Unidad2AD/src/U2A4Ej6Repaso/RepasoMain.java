/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package U2A4Ej6Repaso;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author Xvazqdios
 */
public class RepasoMain {
    private final static String XMLDocument = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\ADATClase\\ADATClase\\Unidad2AD\\src\\U2A4Ej6Repaso\\Empleados.xml";
    private static final String val = "http://xml.org/sax/features/validation";
    private static final String namespaces = "http://xml.org/sax/features/namespaces";
    private static final String esquemas = "http://apache.org/xml/features/validation/schema";

    public static void main(String[] args) {
        //Características del analizador

        try {
            // Creamos la factoria de parseadores por defecto
            XMLReader analizador = XMLReaderFactory.createXMLReader();
            //Personalizamos las caracteristicas del analizador 
//            if (analizador.getFeature(val)) {
//                System.out.println("Esta activada la validación");
//            } else {
//                System.out.println("NO Esta activada la validación. Se va a establecer");
//                analizador.setFeature(val, true);
//            }
//            if (analizador.getFeature(namespaces)) {
//                System.out.println("Soporta espacios de nombres");
//            } else {
//                System.out.println("NO soporta espacios de nombres. Se van a establecer");
//                analizador.setFeature(namespaces, true);
//            }
//            if (analizador.getFeature(esquemas)) {
//                System.out.println("Soporta validacion con esquemas");
//            } else {
//                System.out.println("NO soporta validación con esquemas. Se va a establecer");
//                analizador.setFeature(esquemas, true);
//            }

            // Añadimos nuestro manejador de eventos al analizador
            /*Manejador es una clase que implementa ContentHandler 
            (aquí hay que implementar todos su métodos, pero para solo implementar 
            los que necesitemos se extiende de DefaultHandler que implementa la interfaz 
            ContentHandler*/
            analizador.setContentHandler(new Manejador());
            // Procesamos el xml de ejemplo
            //le metemos el manejador de errores
            analizador.setErrorHandler(new SimpleErrorHandler());
            //Procesamos el documento
            analizador.parse(new InputSource(new FileInputStream(XMLDocument)));

        } catch (SAXException ex) {
            System.err.println("Sax Exception: " + ex);
        } catch (IOException ex) {
            System.err.println("IO exception: "+ex);
        }

    }

}
