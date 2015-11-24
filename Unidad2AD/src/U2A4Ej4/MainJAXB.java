/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package U2A4Ej4;

import static U2A4Ej3.MainJAXB.contexto;
import static U2A4Ej3.MainJAXB.m;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Xvazqdios
 */
public class MainJAXB {

    private static JAXBContext contexto = null;
    private static Unmarshaller m = null;
    private static Marshaller m2 = null;
    private static ListaBloques lista;

    public static void main(String[] args) {
//        lista = new ListaBloques("Redes e area local");
//        lista.add(new Bloque(60, 2,"Sistemas comunicacions","aspectos fdisiasdsa"));
        try {
            //Creamos el contexto que es la clase bloque
            contexto = JAXBContext.newInstance(ListaBloques.class);
            //Creamos el marsshaller para comprobar que lo creamos igual
//            m2 = contexto.createMarshaller();
//            m2.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//            m2.marshal(lista, System.out);
            //Unmarsehamos el contexto
            m = contexto.createUnmarshaller();
            //cremos el fichero donde se va a guardar
            File f = new File("C:\\Users\\usuario\\Documents\\"
                    + "NetBeansProjects\\ADATClase\\ADATClase\\"
                    + "Unidad2AD\\src\\U2A4Ej4\\Modulo.xml");
            //hacemos la desserializacion
            lista = (ListaBloques) m.unmarshal(f);
        } catch (JAXBException ex) {
            System.err.println("Error al crear el unMarshaeller: " + ex);
        }        
        //recorremos el array de puntos
        for (Bloque i : lista.getLista()) {
            System.out.println(i.toString());
        }
    }

}
