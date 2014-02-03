/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.hotelverwaltung.persistence;

import com.mycompany.hotelverwaltung.exceptions.DepartureIsBeforeArrivalException;
import com.mycompany.hotelverwaltung.exceptions.RoomNumberExistsException;
import com.mycompany.hotelverwaltung.exceptions.ServiceAlreadyExistsException;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author said
 */
public interface PersistenceInterface {
    public List<Customer> getCustomerList();
    public List<Reservation> getReservationList();
    public List<Room> getRoomList();
    public List<Service> getServiceList();
    public void updateCustomer(Long id,String name, String surname, String adress, String streetnumber, String zipcode, String city, String country, Calendar birthday) ;
    public void addCustomer(String name, String surname, String adress, String streetnumber, String zipcode, String city, String country, Calendar birthday) ;
    public void removeCustomer(Customer c);
    public void addRoom(String name, int price, int roomNumber, RoomType roomType) throws RoomNumberExistsException;
    public void removeRoom(Room r) throws Exception;
    public void addService(String name, int price) throws ServiceAlreadyExistsException;
    public void removeService(Service s);
    public void addReservation( int reservationNumber, Customer c, Room r, Calendar arrival, Calendar departure, List<Service> services, Calendar[] servicesDates) throws DepartureIsBeforeArrivalException;
    public void removeReservation(int id);
    public void removeReservation(Reservation r);
    public List<Room> checkAvailability(Calendar checkInDate, Calendar CheckOutDate, RoomType roomtype);
    public Double calculatePrice(Calendar checkInDate, Calendar CheckOutDate, RoomType roomtype, List<Service> services)throws DepartureIsBeforeArrivalException ;

}
