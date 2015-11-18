/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package U2A4Ej1;

import java.util.ArrayList;

/**
 *
 * @author Xvazqdios
 */
public class Corredores {
    private ArrayList<Corredor> lista;

    public Corredores() {
        lista = new ArrayList<>();
    }    
    
    public Corredores(ArrayList<Corredor> listaCorredores) {
        this.lista = listaCorredores;
    }
    public void add(Corredor corredor){
        lista.add(corredor);
    }

    public ArrayList<Corredor> getListaCorredores() {
        return lista;
    }

    public void setListaCorredores(ArrayList<Corredor> listaCorredores) {
        this.lista = listaCorredores;
    }
    
    
}
