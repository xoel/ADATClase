/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package U2A4Ej1;

import com.thoughtworks.xstream.XStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Xvazqdios
 */
public class MainXstream {
    private static Corredores listaCorredores = new Corredores();
    private static XStream xstream;
    public static void main(String[] args) {   
        listaCorredores.add(new Corredor("xoel",1,10));
        listaCorredores.add(new Corredor("Pablo",2,11));
        listaCorredores.add(new Corredor("Bolt",3,9));
        listaCorredores.add(new Corredor("Ala Akbhar",4,12));
        listaCorredores.add(new Corredor("Permesga",5,8));
//        for (Corredor i:listaCorredores.getListaCorredores()) {
//            System.out.println("Nombre: "+i.getNombre()+", Dorsal: "+i.getDorsal()+", Tiempo: "+i.getTiempo());
//        }
        FileOutputStream fichero=null;
        try {
            fichero=new FileOutputStream("Corredores.xml");
            xstream = new XStream ();
            xstream.alias("ListaCorredores", Corredores.class);
            xstream.alias("Corredor", Corredor.class);
            //ignoramos el nombre de la lista de la clase corredores para que no aparezca en el xml
            xstream.addImplicitCollection(Corredores.class,"lista");
            //convertimos el dorsal en atributo
            xstream.useAttributeFor(Corredor.class,"dorsal");
            //mapeamos el objeto listapuntos a un fichero xml
            xstream.toXML(listaCorredores, fichero);
            //Mapeamos el objeto listapuntos a un string que contiene el xml
            String xml=xstream.toXML(listaCorredores);
            System.out.println(xml);
        } catch (FileNotFoundException ex) {
            System.err.println("File not found: "+ex);
        }
        if (fichero!=null){
            try {
                fichero.close();
            } catch (IOException ex) {
                System.err.println("IO exception: "+ex);
            }
        }
    }
    
}
