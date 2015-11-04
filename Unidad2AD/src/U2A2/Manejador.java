/*
 * Gestiona los eventos cuando se procesa un documento xml.
 * Se le indica al analizador lo que tiene que hacer.
 */
package U2A2;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Xvazqdios
 */
public class Manejador extends DefaultHandler {

    private DataOutputStream f;
    private static int count = 0;

    public Manejador() {
        try {
            f = new DataOutputStream(new FileOutputStream("Actores.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Manejador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void startDocument() throws SAXException {
        try {
            f.writeBytes("*********** Información de Actores ***********\r\n");
            f.writeBytes("----------------------------------------------\r\n");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println("*********** Información de Actores ***********");
        System.out.println("----------------------------------------------");
    }

    @Override
    public void endDocument() throws SAXException {
        try {
            f.writeBytes("Total actores " + count+"\r\n");
            f.writeBytes("*********** Fin del Documento ***********\r\n");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println("Total actores " + count);
        System.out.println("*********** Fin del Documento ***********");
    }

    @Override
    public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
        try {
            if (localName.equalsIgnoreCase("Actor")) {
                count++;

                f.writeBytes("Actor " + count+"\r\n");
                f.writeBytes("*************\r\n");
                if (attributes != null) {
                    for (int i = 0; i < attributes.getLength(); i++) {
                        f.writeBytes(attributes.getQName(i) + ": " + attributes.getValue(i)+"\r\n");
                    }
                }
                System.out.println("Actor " + count);
                System.out.println("*************");
                //Recorremos los atributos
                if (attributes != null) {
                    for (int i = 0; i < attributes.getLength(); i++) {
                        System.out.println(attributes.getQName(i) + ": " + attributes.getValue(i));
                    }
                }
            }
            if (!localName.equalsIgnoreCase("Actores") && !localName.equalsIgnoreCase("Actor")) {
                System.out.print(localName + ":");
                f.writeBytes(localName + ":");
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

        // También podemos obtener los atributos por nombre
        //Opcion para buscar atributos por nombre
//        String valorId = attributes.getValue("id");
//        if (valorId != null) {
//            System.out.println("\tId: " + valorId);
//        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println(String.valueOf(ch, start, length));
        try {
            f.writeBytes(String.valueOf(ch, start, length)+"\r\n");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void endElement(String uri, String localName, String name) throws SAXException {
        if (localName.equalsIgnoreCase("Actor")) {
            System.out.println("----------------------------------------------");
            try {
                f.writeBytes("----------------------------------------------\r\n");
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }

    }

}
