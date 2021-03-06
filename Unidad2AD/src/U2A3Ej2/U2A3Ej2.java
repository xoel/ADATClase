/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package U2A3Ej2;

import java.io.FileWriter;
import java.io.IOException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author Xvazqdios
 */
public class U2A3Ej2 {
    public static void main(String[] args) {
        //fichero que contiene las hojas de estilos
        String hojaEstilos = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\ADATClase\\ADATClase\\Unidad2AD\\src\\U2A3Ej2\\EstiloHardware.xsl";
        //fichero que contiene el documento XML
        String datosActores = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\ADATClase\\ADATClase\\Unidad2AD\\\\src\\U2A3Ej2\\Hardware.xml";
        //fichero XML
        String paginaXML= "C:\\Users\\usuario\\Documents\\NetBeansProjects\\ADATClase\\ADATClase\\Unidad2AD\\\\src\\U2A3Ej2\\Hardware2.xml";
        TransformerFactory transFact;

        //Instanciamos la factoria
        transFact = TransformerFactory.newInstance();
        Transformer trans;
        //La interfaz Source se utiliza tanto para leer el docuemnto XML
        //como el fichero que contiene las hojas de estilo. Se utiliza
        //un StreamSource , que tiene la capacidad de leer de un
        // Objeto File, un InputStream, un reader o un ID de sistema.
        StreamSource estilos = new StreamSource(hojaEstilos);
        StreamSource datos = new StreamSource(datosActores);
        try {
            /*El TransformerFactory es responsable de crear el transformador
             * aplicado la plantilla objetos. */
            trans = transFact.newTransformer(estilos);
            // creamos fichero para escribir en modo texto
            FileWriter sw = new FileWriter(paginaXML);
            // escribimos todo el arbol en el fichero
            StreamResult sr = new StreamResult(sw);
            
            trans.transform(datos, sr);
        } catch (TransformerConfigurationException | IOException ex) {
            System.err.println("ERROR a la hora de implementar la transformación:  "+ex);
        } catch (TransformerException ex) {
            System.err.println("Error: "+ex);
        }
    }
    
}
