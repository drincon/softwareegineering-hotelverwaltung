/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotelverwaltung.persistence;

/**
 * Roomtype is an enum to determine if a room has two or one bed.
 *
 * @author said
 */
public enum RoomType {

    SINGLEROOM(50),
    DOUBLEROOM(100);

    private final int value;

    private RoomType(int value) {
        this.value = value;
    }


    public int getValue() {
        return value;
    }
}
