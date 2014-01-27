/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotelverwaltung;

import com.mycompany.hotelverwaltung.exceptions.RoomNumberExistsException;
import com.mycompany.hotelverwaltung.exceptions.ServiceAlreadyExistsException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author said
 */
public class RoomManager {

    private static final String PERSISTENCE_UNIT_NAME = "com.mycompany_Hotelverwaltung_jar_1.0-SNAPSHOTPU";
    private EntityManager em;
    private HotelRooms hotelRooms;
    private Services services;

    public RoomManager() {
        EntityManagerFactory factory
                = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();
        configurateAndStart();
    }

    
    public void addService(String name, int price) throws ServiceAlreadyExistsException{
        em.getTransaction().begin();
        Service s= new Service(name,price);
        services.addService(s);
        em.persist(s);
        em.getTransaction().commit();
    }
    public void removeService(Service s){
        em.getTransaction().begin();
        services.removeService(s);
        em.remove(s);
        em.getTransaction().commit();
    }
    
    public void removeRoom(Room r) throws Exception{
        em.getTransaction().begin();
        hotelRooms.removeRoomNumber(r.getRoomNumber(), r);
        em.remove(r);
        em.getTransaction().commit();
        
    }
    
    public void addRoom(String name, int price, int roomNumber) throws RoomNumberExistsException{
        em.getTransaction().begin();
        Room r=new Room(name,price,roomNumber);
        hotelRooms.addRoom(roomNumber, r);
        em.persist(r);
        em.getTransaction().commit();
    }
    
    
    public List<Customer> getCustomerList() {
        return em.createQuery("Select c from Customer c").getResultList();
    }
    
    public List<Room> getRoomList(){
        return em.createQuery("Select r from Room r").getResultList();
    }
    
    public List<Service> getServiceList(){
        return em.createQuery("Select s from Service s").getResultList();
    }

    public void addCustomer(String name, String surname, String adress, String streetnumber, String zipcode, String city, String country, String birthday) {
        em.getTransaction().begin();
        em.persist(new Customer(name, surname, adress, streetnumber, zipcode, city, country, birthday));
        em.getTransaction().commit();
    }
    
    //untested
    public void removeCustomer(int id){
        em.getTransaction().begin();
        em.remove(em.find(Customer.class, id));
        em.getTransaction().commit();
    }
    public void removeCustomer(Customer c){
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
    }

    private void configurateAndStart() {
        em.getTransaction().begin();

        // configure Rooms
        Query q = em.createQuery("SELECT t FROM Room t");
        List<Room> list = q.getResultList();
        Iterator<Room> it = list.iterator();
        Map<Integer, Room> rooms = new HashMap<Integer, Room>();
        List<Integer> roomNumbers = new ArrayList<Integer>();
        while (it.hasNext()) {
            Room r = it.next();
            roomNumbers.add(r.getRoomNumber());
            rooms.put(r.getRoomNumber(), r);
        }
        hotelRooms = new HotelRooms(roomNumbers, rooms);

        // configure servies
        q = em.createQuery("SELECT t FROM Service t");
        List<Service> list2 = q.getResultList();
        Iterator<Service> it2 = list2.iterator();
        Map<String, Service> servicesMap = new HashMap<String, Service>();
        List<String> namesOfServices = new ArrayList<String>();
        while (it2.hasNext()) {
            Service s = it2.next();
            namesOfServices.add(s.getName());
            servicesMap.put(s.getName(), s);
        }
        services = new Services(namesOfServices, servicesMap);
        
        em.getTransaction().commit();

    }

    public void close() {
        em.close();
    }
}
