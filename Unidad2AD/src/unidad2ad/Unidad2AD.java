/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidad2ad;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 *
 * @author xvazqdios
 */
public class Unidad2AD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // CARGAMOS EL XML
        DocumentBuilderFactory dbf;
        DocumentBuilder constructor;
        String XMLDocument = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\ADATClase\\ADATClase\\Unidad2AD\\src\\unidad2ad\\Actores.xml";
        Document documento = null;
        try {
            //inicializamos el constructor de documentos
            dbf = DocumentBuilderFactory.newInstance();
            constructor = dbf.newDocumentBuilder();
            
            //Posibles comportamientos que se pueden establecer:
            //comprueba si la factoría esta configurada para producir parsers que validen el
            //documento
            System.out.println("isValidating: \t\t\t" + dbf.isValidating());
            //comprueba si los parsers producidos soportaran espacios de nombres
            System.out.println("isNamespaceAware: \t\t" + dbf.isNamespaceAware());
            //comprueba si los parsers producidos ignoraran los comentarios
            System.out.println("isIgnoringComments\t\t"+ dbf.isIgnoringComments());
            //Cambiamos comportamiento
            dbf.setValidating(true);
            dbf.setNamespaceAware(true);
            dbf.setIgnoringComments(true);
            
            //construimos el documento          
            documento = constructor.parse(new File(XMLDocument));
            System.out.println("Documento cargado con exito");
            
            //Obtenemos el tipo de codificacion
            System.out.println("Codificacion: "+documento.getXmlEncoding());
            //Tiene dtd?s tiene mostramos el nombre
            System.out.println("Tiene dtd: "+documento.getXmlStandalone());
            if(documento.getXmlStandalone()){
                System.out.println("AQUI DEBERIAMOS OBTENER EL NOM DEL DTD");
            }
            //Visualizar el elemento raiz, valor del nodo y num de hijos
            //Node padre = documento.getParentNode();
            System.out.println(documento.getNodeName());
            System.out.println(documento.getNodeValue());
            System.out.println(documento.getChildNodes().getLength());
           
            
        } catch (ParserConfigurationException ex) {
            System.err.println("Error Parse al obtener el documentBuilder");
        }catch (SAXException ex) {
            System.err.println("SAX Exception");
        } catch (IOException ex) {
            System.err.println("IO Exception");
        }

    }

}
