/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package U2A2;

import java.io.FileInputStream;
import java.io.IOException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author Xvazqdios
 */
public class U2A2Ej1 {
    // CARGAMOS EL XML
    private final static String XMLDocument = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\ADATClase\\ADATClase\\Unidad2AD\\src\\U2A2\\Actores.xml";
    //Características del analizador
    private static final String val = "http://xml.org/sax/features/validation";
    private static final String namespaces = "http://xml.org/sax/features/namespaces";
    private static final String esquemas = "http://apache.org/xml/features/validation/schema";

    public static void main(String[] args) {
        // Creamos la factoria de parseadores con sus caracteristicas por defecto
        XMLReader analizador;
        try {
            analizador = XMLReaderFactory.createXMLReader();
            if (analizador.getFeature(val)) {
                System.out.println("Esta activada la validación");
            } else {
                System.out.println("NO Esta activada la validación. Se va a establecer");
                analizador.setFeature(val, true);
            }
            if (analizador.getFeature(namespaces)) {
                System.out.println("Soporta espacios de nombres");
            } else {
                System.out.println("NO soporta espacios de nombres. Se van a establecer");
                analizador.setFeature(namespaces, true);
            }
            if (analizador.getFeature(esquemas)) {
                System.out.println("Soporta validacion con esquemas");
            } else {
                System.out.println("NO soporta validación con esquemas. Se va a establecer");
                analizador.setFeature(esquemas, true);
            }
            //le metemos el manejador del xml
            analizador.setContentHandler(new Manejador());
            //le metemos el manejador de errores
            analizador.setErrorHandler(new SimpleErrorHandler());
            //Procesamos el documento
            analizador.parse(new InputSource(new FileInputStream(XMLDocument)));

        } catch (SAXException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

    }
}
