/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.hotelverwaltung.exceptions;

/**
 *  Exception used to determine if departure is before arrival
 * @author said
 */
public class DepartureIsBeforeArrivalException extends Exception {

    /**
     * Creates a new instance of <code>DepartureIsBeforeArrivalException</code>
     * without detail message.
     */
    public DepartureIsBeforeArrivalException() {
    }

    /**
     * Constructs an instance of <code>DepartureIsBeforeArrivalException</code>
     * with the specified detail message.
     *
     * @param msg the detail message.
     */
    public DepartureIsBeforeArrivalException(String msg) {
        super(msg);
    }
}
