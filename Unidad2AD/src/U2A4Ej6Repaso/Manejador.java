/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package U2A4Ej6Repaso;

import java.util.TreeMap;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Xvazqdios
 */
public class Manejador extends DefaultHandler{
    //TODO, debemos recorrer todo, guardar las etiquetas de los valores junto a su valor en un treemap
    //por ultimo escribir la carta sustituyendo 
    private String separador,nombre,cargo,direccion,aumento;
    private boolean isSeparador=false, isNombre=false, isCargo=false, isDireccion=false,isAumento=false,finDoc=false;
    int contador=0;
    TreeMap mapaEtiquetas = new TreeMap(); 
    
    @Override
    public void startDocument() throws SAXException {

    }

    @Override
    public void endDocument() throws SAXException {
        
    }

    @Override
    public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
        
        if (localName.equalsIgnoreCase("Separador")) {
            isSeparador=true;
        }
        if(localName.equalsIgnoreCase("Nombre")){
            isNombre=true;
            contador++;
        }
        if(localName.equalsIgnoreCase("Cargo")){
            isCargo=true;
        }
        if(localName.equalsIgnoreCase("Direccion")){
            isDireccion=true;
        }
        if(localName.equalsIgnoreCase("Aumento")){
            isAumento=true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(isSeparador){
            separador=String.valueOf(ch, start, length);
            System.out.println(separador);
            isSeparador=false;
        }
        if(isNombre){
            nombre=String.valueOf(ch, start, length);
            System.out.println(nombre);
            isNombre=false;
        }
        if(isCargo){
            cargo=String.valueOf(ch, start, length);
            System.out.println(cargo);
            isCargo=false;
        }
        if(isDireccion){
            direccion=String.valueOf(ch, start, length);
            System.out.println(direccion);
            isDireccion=false;
        }
        if(isAumento){
            aumento=String.valueOf(ch, start, length);
            System.out.println(aumento);
            isAumento=false;
            
            finDoc=true;
        }
        
    }

    @Override
    public void endElement(String uri, String localName, String name) throws SAXException {
        if(finDoc){
            System.out.println("contador: "+contador);
            System.out.println("");
            finDoc=false;
            //TODO ahora aqui se hace la carta
            
            
            
        }
       
    }
    
}
