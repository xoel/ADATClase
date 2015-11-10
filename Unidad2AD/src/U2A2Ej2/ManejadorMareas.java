/*
 * Gestiona los eventos cuando se procesa un documento xml.
 * Se le indica al analizador lo que tiene que hacer.
 */
package U2A2Ej2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Xvazqdios
 */
public class ManejadorMareas extends DefaultHandler {
    private boolean title = false;
    private boolean date = false;
    @Override
    public void startDocument() throws SAXException {

        System.out.println("*********** TABOA DE MAREAS ***********");
        System.out.println("----------------------------------------------");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("*********** Fin del Documento ***********");
    }

    @Override
    public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {

        if (localName.equalsIgnoreCase("title")) {
            title=true;
        }
        if(localName.equalsIgnoreCase("date")){
            date=true;
        }
        if(localName.equalsIgnoreCase("mareas")){
            System.out.println("Estado: "+attributes.getValue(0)+" hora: "+attributes.getValue(1)+" altura: "+attributes.getValue(2));
            
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(title){
            System.out.println("================================================");
            System.out.println(String.valueOf(ch, start, length));
            title=false;
        }else if(date){
            System.out.println("Fecha de la Predicción: "+String.valueOf(ch, start, length).replaceAll("[ZT]", " "));
            date=false;
            
        }
     }

    @Override
    public void endElement(String uri, String localName, String name) throws SAXException {
        if(localName.equalsIgnoreCase("item")){
            System.out.println();
        }
    }

}
