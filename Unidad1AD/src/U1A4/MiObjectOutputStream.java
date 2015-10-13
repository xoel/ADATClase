/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package U1A4;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import java.io.ObjectOutputStream;

/**
 *
 * @author usuario
 */
public class MiObjectOutputStream extends ObjectOutputStream {

    /**
     * Constructor que recibe OutputStream
     */
    public MiObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    /**
     * Constructor sin parámetros
     */
    protected MiObjectOutputStream() throws IOException, SecurityException {
        super();
    }

    /**
     * Redefinición del método de escribir la cabecera para que no haga nada.
     */
    @Override
    protected void writeStreamHeader() throws IOException {
    }

}
