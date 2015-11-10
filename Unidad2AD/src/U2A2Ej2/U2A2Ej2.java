/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package U2A2Ej2;


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
public class U2A2Ej2 {
    private final static String XMLUri = "http://servizos.meteogalicia.es/rss/predicion/rssMareas.action?request_locale=gl";
    private final static String XMLDocument ="C:\\Users\\usuario\\Documents\\NetBeansProjects\\ADATClase\\ADATClase\\Unidad2AD\\src\\U2A2Ej2\\rssMareas.xml";
    private final static String PROXYHOST = "196.168.0.11";
    private final static String PROXYPORT = "3128";
            
    public static void main(String[] args) {
        // Creamos la factoria de parseadores con sus caracteristicas por defecto
        XMLReader analizador;
        try {
            System.setProperty("http.proxyHost",PROXYHOST);
            System.setProperty("http.proxyPort",PROXYPORT);
            
            analizador = XMLReaderFactory.createXMLReader();
            
            //le metemos el manejador del xml
            analizador.setContentHandler(new ManejadorMareas());
            //le metemos el manejador de errores
            analizador.setErrorHandler(new SimpleErrorHandler());
            //Procesamos el documento
            System.out.println("Vamos a parsear documento");
            //analizador.parse(XMLUri);
            analizador.parse(new InputSource(new FileInputStream(XMLDocument)));
            System.out.println("Documento parseado");

        } catch (SAXException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

    }
    
}
