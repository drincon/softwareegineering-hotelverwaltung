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
public class ServiceDateIsNotDuringStayException extends Exception {

    /**
     * Creates a new instance of
     * <code>ServicesDateIsNotDuringStayException</code> without detail message.
     */
    public ServiceDateIsNotDuringStayException() {
    }

    /**
     * Constructs an instance of
     * <code>ServicesDateIsNotDuringStayException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public ServiceDateIsNotDuringStayException(String msg) {
        super(msg);
    }
}
