/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package U1A3;

/**
 *
 * @author usuario
 */
public class MissSecuenceException extends Exception {

    /**
     * Creates a new instance of <code>MissSecuenceExceptioon</code> without
     * detail message.
     */
    public MissSecuenceException() {
        super("No sigue la secuencia ascendente");
    }

    /**
     * Constructs an instance of <code>MissSecuenceExceptioon</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public MissSecuenceException(String msg) {
        super(msg);
    }
}
