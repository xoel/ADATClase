/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package U2A4Ej2;

import com.thoughtworks.xstream.XStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Xvazqdios
 */
public class MainXstream {

    private static ListaAlumnos lista = new ListaAlumnos();
    private static XStream xstream;

    public static void main(String[] args) {
        FileInputStream fichero = null;
        try {
            fichero = new FileInputStream("C:\\Users\\usuario\\Documents\\NetBeansProjects\\ADATClase\\ADATClase\\Unidad2AD\\src\\U2A4Ej2\\Alumnos.xml");
            xstream = new XStream();

            xstream.alias("Alumnos", ListaAlumnos.class);
            xstream.alias("Alumno", Alumno.class);
            xstream.aliasField("nome", Alumno.class, "nombre");
            xstream.aliasField("nota", Alumno.class, "nota");
            //quitamos la lista para que no aparezca ya que no hay ningun campo asi en el xml
            xstream.addImplicitCollection(ListaAlumnos.class, "lista");
            lista = (ListaAlumnos) xstream.fromXML(fichero);
        } catch (FileNotFoundException ex) {
            System.err.println("File not found: " + ex);
        }
        if (fichero != null) {
            try {
                fichero.close();
            } catch (IOException ex) {
                System.err.println("IO exception: "+ex);
            }
        }
        for (Alumno i : lista.getLista()) {
            System.out.println(i.getNombre() + "," + i.getNota());
        }

    }

}
