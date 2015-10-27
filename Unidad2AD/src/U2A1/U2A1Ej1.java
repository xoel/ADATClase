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
import org.w3c.dom.Document;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author xvazqdios
 */
public class U2A1Ej1 {

    //Especifica el lenguaje utilizado por el parser en el análisis
    static final String JAXP_SCHEMA_LANGUAGE
            = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
    //especifica el espacio de nombres
    static final String W3C_XML_SCHEMA
            = "http://www.w3.org/2001/XMLSchema";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // CARGAMOS EL XML
        DocumentBuilderFactory dbf;
        DocumentBuilder constructor;
        String XMLDocument = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\ADATClase\\ADATClase\\Unidad2AD\\src\\U2A1\\Actores.xml";
        Document documento = null;
        //inicializamos el constructor de documentos
        dbf = DocumentBuilderFactory.newInstance();
        try {
            //2 Posibles comportamientos que se pueden establecer:
            //comprueba si la factoría esta configurada para producir parsers que validen el
            //documento por ello hay que comprobar las propiedades y cambiarlas antes de construirlo
            System.out.println("isValidating: \t\t\t" + dbf.isValidating());
            //comprueba si los parsers producidos soportaran espacios de nombres
            System.out.println("isNamespaceAware: \t\t" + dbf.isNamespaceAware());
            //comprueba si los parsers producidos ignoraran los comentarios
            System.out.println("isIgnoringComments\t\t" + dbf.isIgnoringComments());
            //Cambiamos comportamiento
            dbf.setValidating(true);
            System.out.println("isValidating now?: \t\t" + dbf.isValidating());
            dbf.setNamespaceAware(true);
            //ignoramos comentarios y espacios en blanco
            dbf.setIgnoringComments(true);
            dbf.setIgnoringElementContentWhitespace(true);
            
            //le metemos el espacio de nombres y esaas trapaladas
            //SE LO METEMOS SOLO PARA SCHEMAS
            //TODO
            //dbf.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
            
            
            //se construye ahora despues de comprobar la configuracion y cambiarla
            constructor = dbf.newDocumentBuilder();
            //Toca analizar los errores del xml en base al dtd
            constructor.setErrorHandler(new SimpleErrorHandler());
            //3 construimos el documento          
            documento = constructor.parse(new File(XMLDocument));
            System.out.println("Documento cargado con exito");

            //4 Obtenemos el tipo de codificacion
            System.out.println("Codificacion: " + documento.getXmlEncoding());
            //5 Tiene dtd?s tiene mostramos el nombre
            System.out.println("Tiene dtd: " + documento.getXmlStandalone());
            if (documento.getXmlStandalone()) {
                System.out.println(documento.getDoctype());
            }
            System.out.println("****************    6    ************************");
            //6 Visualizar el elemento raiz, valor del nodo y num de hijos
            Node raiz = documento.getDocumentElement();
            System.out.println("Nombre raiz: " + raiz.getNodeName());
            System.out.println("Valor: " + raiz.getNodeValue());
            System.out.println("Hijos: " + raiz.getChildNodes().getLength());
            System.out.println("****************    7    ************************");
            //7 texto de raiz y descendientes
            //La siguiente introducción retorna una lista NodeList con los nodos que tengan como elemento Actor
            NodeList Actores = documento.getElementsByTagName("Actor");
            //Se puede recorrer la lista
            for (int i = 0; i < Actores.getLength(); i++) {
                Node actor = Actores.item(i);
                System.out.println(actor.getTextContent());
            }
            //Las siguientes instrucciones retornan una lista de NodeList de
            //los nodos que contenga como elemento Nome y visualiza su texto por pantalla
            NodeList nombres = documento.getElementsByTagName("nome");//
            for (int i = 0; i < nombres.getLength(); i++) {
                Node nom = nombres.item(i);
                //visualiza el texto del nodo
                System.out.println("nombre:" + nom.getTextContent());
            }
            //8 ejecutar este codigo
            System.out.println("****************    8    ************************");
            Node nodo = raiz.getFirstChild().getNextSibling();
            System.out.println("Nombre nodo1 (actores): " + nodo.getNodeName() + " Valor del nodo: " + nodo.getNodeValue());
            System.out.println(nodo.getTextContent());
//            //9 Muestra el  nodo actores
//            System.out.println("****************    6    ************************");
//            nodo = nodo.getFirstChild().getNextSibling();
//            System.out.println("Nombre del primer nodo actor: " + nodo.getNodeName() + " Valor del  nodo: " + nodo.getNodeValue());
//            System.out.println(nodo.getTextContent());
//            //10 obtener info nodo hermano dos pos hacia la derecha, nodo id=100
//            System.out.println("Datos nodo hermano dos pos a la derecha id=100");
//            nodo = nodo.getNextSibling().getNextSibling();
//            System.out.println(nodo.getTextContent());
//            //11 nodo izquierdo contiguo
//            System.out.println("hermano izquierdo contiguo");
//            nodo = nodo.getPreviousSibling();
//            System.out.println(nodo.getTextContent());
//            //12 Leer todo el arbol de manera recursiva
//            System.out.println("Leer todo el arbol recursivamente");
//            //TODO corregir, falla
//            //leerNodosRecursivos(documento.getFirstChild());

        } catch (ParserConfigurationException ex) {
            System.err.println("Error Parse al obtener el documentBuilder");
        } catch (SAXException ex) {
            System.err.println("SAX Exception");
        } catch (IOException ex) {
            System.err.println("IO Exception");
        }

    }

    private static void leerNodosRecursivos(Node nodo) {
        //falla
        System.out.println("Nombre nodo: " + nodo.getNodeName() + ", Valor del nodo: " + nodo.getNodeValue());
        System.out.println(nodo.getTextContent());
        if (nodo.hasChildNodes()) {
            nodo = nodo.getFirstChild();
            leerNodosRecursivos(nodo);
        } else {
            nodo = nodo.getNextSibling();
            leerNodosRecursivos(nodo);
        }
    }

}
