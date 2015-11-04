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
import org.w3c.dom.Attr;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author xvazqdios
 */
public class U2A1Ej1 {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // CARGAMOS EL XML
        DocumentBuilderFactory dbf;
        DocumentBuilder constructor;
        String XMLDocument = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\ADATClase\\ADATClase\\Unidad2AD\\src\\U2A1\\Actores.xml";
        Document documento;
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
            //ignoramos comentarios y espacios en blanco, saltos de linea etc
            dbf.setIgnoringComments(true);
            dbf.setIgnoringElementContentWhitespace(true);

            //le metemos el espacio de nombres y esaas trapalladas
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
            System.out.println("****************    5    ************************");
            if (documento.getDoctype() != null) {
                System.out.println("Nombre del DTD: " + documento.getDoctype().getSystemId());
            } else {
                System.out.println("No tiene DTD");
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
            NodeList actores = documento.getChildNodes();
            visualizarHijos(actores);

            //8 ejecutar este codigo
            System.out.println("****************    8    ************************");
            Node nodo = raiz.getFirstChild().getNextSibling();
            System.out.println("Nombre nodo1 (actores): " + nodo.getNodeName() 
                    + " Valor del nodo: " + nodo.getNodeValue());
            System.out.println(nodo.getTextContent());
            //9 Muestra el  nodo actores
            System.out.println("****************    9    ************************");
            //Accedemos al hermano anterior para llegar al primer nodo
            nodo = nodo.getPreviousSibling();
            visualizarNodo(nodo);
            

            //10 obtener info nodo hermano dos pos hacia la derecha, nodo id=100
            System.out.println( "****************    10    ************************");
            System.out.println("Datos nodo hermano dos pos a la derecha id=100");
            //nodo = nodo.getParentNode().getNextSibling().getNextSibling();
            nodo = raiz.getFirstChild().getNextSibling().getNextSibling();
            visualizarNodo(nodo);
            //11 nodo izquierdo contiguo
            System.out.println( "****************    11    ************************");
            System.out.println("Obten hermano izquierdo contiguo");
            nodo = raiz.getFirstChild().getNextSibling();
            visualizarNodo(nodo);

            //12 Leer todo el arbol de manera recursiva
            System.out.println(
                    "****************    12    ************************");
            System.out.println(
                    "Leer todo el arbol recursivamente");
            //TODO corregir, falla
            leerNodosRecursivos(raiz.getFirstChild());

        } catch (ParserConfigurationException ex) {
            System.err.println("Error Parse al obtener el documentBuilder");
        } catch (SAXException ex) {
            System.err.println("SAX Exception");
        } catch (IOException ex) {
            System.err.println("IO Exception");
        }

    }
    
    public static void visualizarNodo(Node nodo){
        System.out.println("Nombre del primer nodo actor: " + nodo.getNodeName() + " Valor del  nodo: " + nodo.getNodeValue());
        NamedNodeMap att = nodo.getAttributes();
        if(att!=null){
            for (int i = 0; i < att.getLength(); i++) {
                System.out.println("Atributo: <"+att.item(i).getNodeName()+">:"+att.item(i).getNodeValue());
            }
        }   
        visualizarHijos(nodo.getChildNodes());
    }

    public static void visualizarHijos(NodeList lista) {
        for (int i = 0; i < lista.getLength(); i++) {
            Node actor = lista.item(i);
            NodeList hijos = actor.getChildNodes();
            visualizarHijos(hijos);
            if (actor.getNodeValue() != null) {
                System.out.println("<" + actor.getParentNode().getNodeName() + ">: " + actor.getNodeValue());
            }
        }
    }

    private static void leerNodosRecursivos(Node nodo) {
        if(nodo!=null){
            System.out.println("nombre del nodo: "+nodo.getNodeName()+" Valor nodo: "+nodo.getNodeValue());
            if(nodo.hasAttributes()){
                NamedNodeMap atributos = nodo.getAttributes();
                for (int i = 0; i < atributos.getLength(); i++) {
                    Attr atrib =(Attr) atributos.item(i);
                    System.out.println("<"+atrib.getName()+">:"+atrib.getValue());
                }
                NodeList hijos=nodo.getChildNodes();
                for (int i = 0; i < hijos.getLength(); i++) {
                    Node nietos = hijos.item(i);
                    leerNodosRecursivos(nietos);
                }
            }
        }

    }

    

}
