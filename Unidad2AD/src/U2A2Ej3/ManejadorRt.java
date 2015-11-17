/*
 * Gestiona los eventos cuando se procesa un documento xml.
 * Se le indica al analizador lo que tiene que hacer.
 */
package U2A2Ej3;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Xvazqdios
 */
public class ManejadorRt extends DefaultHandler {

    private boolean title = false;
    private boolean date = false;
    private boolean autor = false;
    private boolean descripcion = false;
    private int countNot = 0;

    @Override
    public void startDocument() throws SAXException {

        System.out.println("*********** Titular de noticias de RT***********");
        System.out.println("----------------------------------------------");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("*********** Fin del Documento ***********");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (localName.equalsIgnoreCase("title")) {
            title = true;
            countNot++;
            System.out.println("==============Noticia " + countNot + "================");
        }
        if (localName.equalsIgnoreCase("pubDate")) {
            date = true;
        }
        if (qName.equalsIgnoreCase("dc:creator")) {
            autor = true;
        }
        if (localName.equalsIgnoreCase("description")) {
            descripcion = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (title) {

            System.out.println("Titular: " + String.valueOf(ch, start, length));
            title = false;
        } else if (date) {
            //TODO arreglar para poner la diferencia en horas entre la fecha actual y a de la noticia
//            Date fechaActual = new Date();
//            System.out.println(fechaActual);
//            String fechaNoticia = String.valueOf(ch, 5, 19);
//            fechaNoticia = fechaNoticia.replaceAll(" ", "-").trim();
//            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy-hh:mm:ss");
//            try {
//                Date d = formatoDelTexto.parse(fechaNoticia); 
//                System.out.println("Fecha de la Publicación: " + d);
//            }
//                catch(ParseException e){ System.out.println("Error al pasar de String a Fecha");
//            } 
            System.out.println("Fecha de la Publicación: " + String.valueOf(ch, 5, 19));            
            date = false;
        } else if (autor) {
            System.out.println("Autor: " + String.valueOf(ch, start, length));
            autor = false;
        } else if (descripcion) {
            System.out.println("Descripcion: " + String.valueOf(ch, start, length));
            descripcion = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String name) throws SAXException {
        if (localName.equalsIgnoreCase("item")) {
            System.out.println();
        }
    }

}
