/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotelverwaltung;

import com.mycompany.hotelverwaltung.persistence.Service;
import com.mycompany.hotelverwaltung.persistence.Room;
import com.mycompany.hotelverwaltung.persistence.Customer;
import com.mycompany.hotelverwaltung.persistence.Reservation;
import com.mycompany.hotelverwaltung.persistence.RoomType;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
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

        this.r = new Room("TestRoom", 1, RoomType.DOUBLEROOM);
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
        Calendar departure = Calendar.getInstance();
        departure.set(2009, Calendar.DECEMBER, 15);
        Calendar arrival = Calendar.getInstance();
        arrival.set(2009, Calendar.DECEMBER, 12);
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

        Customer c3 = new Customer();
        c3.setAdress("TestStreet");
        Collection<Reservation> reservations = new ArrayList<Reservation>();
        c3.setReservations(reservations);
        em.persist(c3);
        em.getTransaction().commit();

        em.getTransaction().begin();
        Customer c2 = em.find(Customer.class, c3.getId());
        if (!c2.equals(c3)) {
            throw new Exception();
        }
        em.remove(c3);
        em.getTransaction().commit();

    }

    public void testAddAndRemoveRoom() throws Exception {
        em.getTransaction().begin();

        Room r3 = new Room();
        r3.setName("Test");
        r3.setRoomNumber(1);
        em.persist(r3);

        em.getTransaction().commit();

        em.getTransaction().begin();
        Room r2 = em.find(Room.class, r3.getId());
        if (!r2.equals(r3)) {
            throw new Exception();
        }
        em.remove(r3);
        em.getTransaction().commit();
    }

    public void testAddAndRemoveService() throws Exception {
        em.getTransaction().begin();

        Service s3 = new Service();
        s3.setName("Test");
        s3.setPrice(10);
        em.persist(s3);

        em.getTransaction().commit();

        em.getTransaction().begin();
        Service s2 = em.find(Service.class, s3.getId());
        if (!s2.equals(s3)) {
            throw new Exception();
        }
        em.remove(s3);
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
            Room r2 = it.next();
            System.out.println("-Room-------------------------------------" + r2.getName() + "----------------------------");
        }
        q = em.createQuery("Select c from Customer c");
        List<Customer> list2 = q.getResultList();
        Iterator<Customer> it2 = list2.iterator();
        while (it2.hasNext()) {
            Customer c2 = it2.next();
            System.out.println("-Customer-------------------------------------" + c2.getName() + " " + c2.getSurname() + "----------------------------");
        }
        q = em.createQuery("Select s from Service s");
        List<Service> list3 = q.getResultList();
        Iterator<Service> it3 = list3.iterator();
        while (it3.hasNext()) {
            Service s2 = it3.next();
            System.out.println("-Service-------------------------------------" + s2.getName() + "----------------------------");
        }
        q = em.createQuery("Select r from Reservation r");
        List<Reservation> list4 = q.getResultList();
        Iterator<Reservation> it4 = list4.iterator();
        while (it4.hasNext()) {
            Reservation re2 = it4.next();
            System.out.println("-Reservation---------------------------------" + re2.getReservationNumber() + " " + re2.getCustomer() + " " + re2.getRoom() + "--------------------------");
        }

    }

}
