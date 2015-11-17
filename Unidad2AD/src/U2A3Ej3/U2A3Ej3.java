/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package U2A3Ej3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;

/**
 *
 * @author Xvazqdios
 */
public class U2A3Ej3 {

    public static void main(String[] args) {
        //fichero que contiene las hojas de estilos
        String hojaEstilos = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\ADATClase\\ADATClase\\Unidad2AD\\src\\U2A3Ej3\\HojaEstilosV2.xsl";
        //fichero que contiene el documento XML
        String datosAlumnos = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\ADATClase\\ADATClase\\Unidad2AD\\src\\U2A3Ej3\\Alumnos.xml";
        //fichero de salida
        String paginaXML = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\ADATClase\\ADATClase\\Unidad2AD\\src\\U2A3Ej3\\Alumnos_output.xml";
        TransformerFactory transFact;
        transFact = TransformerFactory.newInstance();
        SAXTransformerFactory saxTransFact = (SAXTransformerFactory) transFact;

        SAXSource datos = new SAXSource(new InputSource(datosAlumnos));
        Source estilos = new StreamSource(hojaEstilos);
        try {
            TransformerHandler transHand = saxTransFact.newTransformerHandler(estilos);
            //Especificamos que el resultado de transformación lo va a procesar
            // un objeto SAXResult
            ContentHandler manejador = new Manejador();
            Result resultado = new SAXResult(manejador);
            transHand.getTransformer().transform(datos, resultado);

            //Imprimimos para ver como queda el XML para manejarlo
            //Instanciamos la factoria
            Transformer trans;
            //La interfaz Source se utiliza tanto para leer el docuemnto XML
            //como el fichero que contiene las hojas de estilo. Se utiliza
            //un StreamSource , que tiene la capacidad de leer de un
            // Objeto File, un InputStream, un reader o un ID de sistema.
            StreamSource datos2 = new StreamSource(datosAlumnos);
            /*El TransformerFactory es responsable de crear el transformador
             * aplicado la plantilla objetos. */
            trans = transFact.newTransformer(estilos);
            // creamos fichero para escribir en modo texto
            FileWriter sw = new FileWriter(paginaXML);
            // escribimos todo el arbol en el fichero
            StreamResult sr = new StreamResult(sw);
            trans.transform(datos2, sr);

        } catch (TransformerConfigurationException ex) {
            System.err.println("Error al transformar: " + ex);
        } catch (TransformerException ex) {
            System.err.println("Error al transformar con el manjeador: " + ex);
        } catch (IOException ex) {
            Logger.getLogger(U2A3Ej3.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
