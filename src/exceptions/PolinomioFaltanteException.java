/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Usuario
 */
public class PolinomioFaltanteException extends Exception {

    /**
     * Creates a new instance of <code>PolinomioFaltanteException</code> without
     * detail message.
     */
    public PolinomioFaltanteException() {
    }

    /**
     * Constructs an instance of <code>PolinomioFaltanteException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public PolinomioFaltanteException(String msg) {
        super(msg);
    }
}
