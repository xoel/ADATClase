/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package U2A4Ej2;


import java.util.ArrayList;

/**
 *
 * @author Xvazqdios
 */
public class ListaAlumnos {
    private ArrayList<Alumno> lista;

    public ListaAlumnos() {
        lista = new ArrayList<>();
    }
    public void add(Alumno alumno){
        lista.add(alumno);
    }

    public ArrayList<Alumno> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Alumno> lista) {
        this.lista = lista;
    }
    
    
    
    
}
