/*
 * Gestiona los eventos cuando se procesa un documento xml.
 * Se le indica al analizador lo que tiene que hacer.
 */
package U2A3Ej3;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Xvazqdios
 */
public class Manejador extends DefaultHandler {

    private boolean nota = false;
    private boolean alumno = false;
    private int countNot = 0;
    private int countTot =0;

    @Override
    public void startDocument() throws SAXException {

        System.out.println("*********** NOTAS ***********");
        System.out.println("----------------------------------------------");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("*********** Total Alumnos "+countTot+"***********");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (localName.equalsIgnoreCase("Nota")) {
            switch (attributes.getValue(0).toString()) {
                case "9":
                case "10":
                    System.out.println("Sobresaliente");
                    break;
                case "8":
                case "7":
                    System.out.println("Notable");
                    break;
                case "6":
                    System.out.println("Bien");
                    break;
                case "5":
                    System.out.println("Suficiente");
                    break;
                default:
                    System.out.println("Insuficiente");
                    break;
            }
            nota = true;                        
        }
        if (localName.equalsIgnoreCase("Alumno")) {
            alumno = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(alumno){
            System.out.println("Alumno: " + String.valueOf(ch, start, length));
            alumno=false;            
            countNot++;
            countTot++;
        }
    }

    @Override
    public void endElement(String uri, String localName, String name) throws SAXException {
        if(nota){
            System.out.println("Num alumnos: "+countNot);
            countNot=0;
            nota=false;
            System.out.println("--------------------------------------------------");
             
        }
       
    }

}
