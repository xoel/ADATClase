/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package U2A1;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author Xvazqdios
 */
public class U2A1Ej2 {

    public static void main(String[] args) {
        // CARGAMOS EL XML
        DocumentBuilderFactory dbf;
        DocumentBuilder constructor;
        String XMLDocument = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\ADATClase\\ADATClase\\Unidad2AD\\src\\U2A1\\Actores.xml";
        Document documento = null;

        dbf = DocumentBuilderFactory.newInstance();
        try {
            constructor = dbf.newDocumentBuilder();
            documento = constructor.parse(new File(XMLDocument));
            System.out.println("Documento cargado con exito");
            
            
            
        } catch (ParserConfigurationException ex) {
            System.err.println("Error Parse al obtener el documentBuilder");
        } catch (SAXException ex) {
            System.err.println("SAX Exception");
        } catch (IOException ex) {
            System.err.println("IO Exception");
        }
    }

}
