/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotelverwaltung;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import junit.framework.TestCase;

/**
 *
 * @author said
 */
public class DBTest extends TestCase {

    private EntityManager em;
    private static final String PERSISTENCE_UNIT_NAME = "com.mycompany_Hotelverwaltung_jar_1.0-SNAPSHOTPU";
    private Customer c;
    private Room r;
    private Service s;

    public DBTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        EntityManagerFactory factory
                = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();

        this.c = new Customer("max", "mustermann");
        persistObject(c);

        this.r = new Room("TestRoom", 50, 1);
        persistObject(r);

        this.s = new Service("Testdienstleistung", 50);
        persistObject(s);

    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        em.getTransaction().begin();
        em.remove(c);
        em.remove(r);
        em.remove(s);
        em.getTransaction().commit();

        printAll();

        em.close();

    }

    public void testReservation() throws Exception {
        em.getTransaction().begin();
        Date departure = new Date();
        Date arrival = new Date();
        List<Service> services = new ArrayList<Service>();
        services.add(s);
        Reservation res = new Reservation(123, c, r, arrival, departure, services);
        em.persist(res);
        em.getTransaction().commit();

        em.getTransaction().begin();
        Reservation res2 = em.find(Reservation.class, res.getId());
        if (!res2.equals(res)) {
            throw new Exception();
        }

        //check if i can get to Customer
        if (!c.equals(res2.getCustomer())) {
            throw new Exception();
        }
        em.remove(res);
        em.getTransaction().commit();

    }

    public void testAddAndRemoveCustomer() throws Exception {
        em.getTransaction().begin();

        Customer c = new Customer();
        c.setAdress("TestStreet");
        c.setBirthday("01.01.01");
        Collection<Reservation> reservations = new ArrayList<Reservation>();
        c.setReservations(reservations);
        em.persist(c);
        em.getTransaction().commit();

        em.getTransaction().begin();
        Customer c2 = em.find(Customer.class, c.getId());
        if (!c2.equals(c)) {
            throw new Exception();
        }
        em.remove(c);
        em.getTransaction().commit();

    }

    public void testAddAndRemoveRoom() throws Exception {
        em.getTransaction().begin();

        Room r = new Room();
        r.setName("Test");
        r.setPrice(50);
        r.setRoomNumber(1);
        em.persist(r);

        em.getTransaction().commit();

        em.getTransaction().begin();
        Room r2 = em.find(Room.class, r.getId());
        if (!r2.equals(r)) {
            throw new Exception();
        }
        em.remove(r);
        em.getTransaction().commit();
    }

    public void testAddAndRemoveService() throws Exception {
        em.getTransaction().begin();

        Service s = new Service();
        s.setName("Test");
        s.setPrice(10);
        em.persist(s);

        em.getTransaction().commit();

        em.getTransaction().begin();
        Service s2 = em.find(Service.class, s.getId());
        if (!s2.equals(s)) {
            throw new Exception();
        }
        em.remove(s);
        em.getTransaction().commit();

    }

    public void testServices() {
        em.getTransaction().begin();

        Query q = em.createQuery("SELECT t FROM Service t");
        List<Service> list = q.getResultList();
        Iterator<Service> it = list.iterator();
        Map<String, Service> map = new HashMap<String, Service>();
        List<String> namesOfServices = new ArrayList<String>();
        while (it.hasNext()) {
            Service s = it.next();
            namesOfServices.add(s.getName());
            map.put(s.getName(), s);
        }
        new Services(namesOfServices, map);

        em.getTransaction().commit();
    }

    public void testHotelRooms() {
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
        new HotelRooms(roomNumbers, rooms);

        em.getTransaction().commit();

    }

  
    public void testTransaction() {
        em.getTransaction().begin();
        em.getTransaction().commit();
    }

    private void persistObject(Object o) {
        em.getTransaction().begin();
        em.persist(o);
        em.getTransaction().commit();
    }

    private void printAll() throws Exception {
        System.out.println("print all  ---------------------------------------------------------------------------------------------------");
        Query q = em.createQuery("Select r from Room r");
        List<Room> list = q.getResultList();
        Iterator<Room> it = list.iterator();
        while (it.hasNext()) {
            Room r = it.next();
            System.out.println("-Room-------------------------------------" + r.getName() + "----------------------------");
        }
        q = em.createQuery("Select c from Customer c");
        List<Customer> list2 = q.getResultList();
        Iterator<Customer> it2 = list2.iterator();
        while (it2.hasNext()) {
            Customer c = it2.next();
            System.out.println("-Customer-------------------------------------" + c.getName() + " " + c.getSurname() + "----------------------------");
        }
        q = em.createQuery("Select s from Service s");
        List<Service> list3 = q.getResultList();
        Iterator<Service> it3 = list3.iterator();
        while (it3.hasNext()) {
            Service s = it3.next();
            System.out.println("-Service-------------------------------------" + s.getName() + "----------------------------");
        }
        q = em.createQuery("Select r from Reservation r");
        List<Reservation> list4 = q.getResultList();
        Iterator<Reservation> it4 = list4.iterator();
        while (it4.hasNext()) {
            Reservation r = it4.next();
            System.out.println("-Reservation---------------------------------" + r.getReservationNumber() + " " + r.getCustomer() + " " + r.getRoom() + "--------------------------");
        }

    }

}
