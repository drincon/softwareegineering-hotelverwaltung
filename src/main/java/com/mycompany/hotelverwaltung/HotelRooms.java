/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotelverwaltung;

import com.mycompany.hotelverwaltung.exceptions.RoomNumberExistsException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author said
 */

public class HotelRooms {



    private Collection<Integer> roomNumbers;


    private Map<Integer, Room> rooms;

    public HotelRooms(List<Integer> roomNumbers, Map<Integer,Room> rooms) {
        this.roomNumbers = roomNumbers;
        this.rooms = rooms;
    }

    public void addRoom(int roomNumber, Room r) throws RoomNumberExistsException {
        if (roomNumbers.contains(roomNumber)) {
            throw new RoomNumberExistsException();
        }
        roomNumbers.add(roomNumber);
        rooms.put(roomNumber, r);

    }

    public void removeRoomNumber(int roomNumber, Room r) {
        roomNumbers.contains(roomNumber);
        roomNumbers.remove(roomNumber);
        rooms.remove(roomNumber);
    }

    public Collection<Integer> getRoomNumbers() {
        return roomNumbers;
    }

    public Room getRoom(int i) {
        return rooms.get(i);
    }

    public void setRoomNumbers(ArrayList<Integer> roomNumbers) {
        this.roomNumbers = roomNumbers;
    }

    public Map<Integer, Room> getRooms() {
        return rooms;
    }

    public void setRooms(HashMap<Integer, Room> rooms) {
        this.rooms = rooms;
    }

}
