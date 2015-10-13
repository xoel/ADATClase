/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package U1A2Ej4;

import U1A2Ej3.*;

/**
 *
 * @author Xoel Vazquez Dios
 */
public class NoDirectoryException extends Exception {

    /**
     * Creates a new instance of <code>NoDirectoryException</code> without
     * detail message.
     */
    public NoDirectoryException() {
    }

    /**
     * Constructs an instance of <code>NoDirectoryException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NoDirectoryException(String msg) {
        super(msg);
    }
}
