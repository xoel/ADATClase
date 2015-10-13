/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package U1A2Ej7;


/**
 *
 * @author Xoel Vazquez Dios
 */
public class ParamNoExisteException extends Exception {

    /**
     * Creates a new instance of <code>paraNoExisteException</code> without
     * detail message.
     */
    public ParamNoExisteException() {
       
    }

    /**
     * Constructs an instance of <code>paraNoExisteException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ParamNoExisteException(String msg) {
        super(msg);
    }
}
