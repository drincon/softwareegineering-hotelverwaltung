/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.hotelverwaltung.exceptions;

/**
 * Exception used to determine if Roomnumber already exists 
 * @author said
 */
public class RoomNumberExistsException extends Exception {

    /**
     * Creates a new instance of <code>RoomNumberExists</code> without detail
     * message.
     */
    public RoomNumberExistsException() {
    }

    /**
     * Constructs an instance of <code>RoomNumberExists</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public RoomNumberExistsException(String msg) {
        super(msg);
    }
}
