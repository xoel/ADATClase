/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package U2A3Ej3;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
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
        String hojaEstilos = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\ADATClase\\ADATClase\\Unidad2AD\\src\\U2A3Ej3\\EstiloHardware.xsl";
        //fichero que contiene el documento XML
        String datosAlumnos = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\ADATClase\\ADATClase\\Unidad2AD\\\\src\\U2A3Ej3\\Alumnos.xml";
        
        TransformerFactory transFact;        
        transFact = TransformerFactory.newInstance();
        SAXTransformerFactory saxTransFact = (SAXTransformerFactory) transFact;
        
        SAXSource datos = new SAXSource(new InputSource(datosAlumnos));
        Source estilos = new StreamSource(hojaEstilos);
        try {
            TransformerHandler transHand =saxTransFact.newTransformerHandler(estilos);
            //Especificamos que el resultado de transformación lo va a procesar
            // un objeto SAXResult
            ContentHandler manejador = new Manejador();
            Result resultado = new SAXResult(manejador);            
            transHand.getTransformer().transform(datos, resultado);
            
        } catch (TransformerConfigurationException ex) {
            System.err.println("Error al transformar: "+ex);
        } catch (TransformerException ex) {
            System.err.println("Error al transformar con el manjeador: "+ex);;
        }
        
    }
}
