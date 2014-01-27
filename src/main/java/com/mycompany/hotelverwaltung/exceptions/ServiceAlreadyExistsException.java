/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.hotelverwaltung.exceptions;

/**
 *
 * @author said
 */
public class ServiceAlreadyExistsException extends Exception {

    /**
     * Creates a new instance of <code>ServiceAlreadyExistsException</code>
     * without detail message.
     */
    public ServiceAlreadyExistsException() {
    }

    /**
     * Constructs an instance of <code>ServiceAlreadyExistsException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public ServiceAlreadyExistsException(String msg) {
        super(msg);
    }
}
