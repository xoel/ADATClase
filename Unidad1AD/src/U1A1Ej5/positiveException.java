/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package U1A1Ej5;


/**
 *
 * @author Xoel Vazquez Dios
 */
public class positiveException extends Exception {

    /**
     * Creates a new instance of <code>positiveException</code> without detail
     * message.
     */
    public positiveException() {
        super();
    }

    /**
     * Constructs an instance of <code>positiveException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public positiveException(String msg) {
        super(msg);
    }
}
