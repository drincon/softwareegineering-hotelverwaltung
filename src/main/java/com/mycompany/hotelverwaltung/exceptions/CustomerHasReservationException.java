/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.hotelverwaltung.exceptions;

/**
 *
 * @author weiky
 */
public class CustomerHasReservationException extends Exception {

    /**
     * Creates a new instance of <code>CustomerHasReservation</code> without
     * detail message.
     */
    public CustomerHasReservationException() {
    }

    /**
     * Constructs an instance of <code>CustomerHasReservation</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CustomerHasReservationException(String msg) {
        super(msg);
    }
}
