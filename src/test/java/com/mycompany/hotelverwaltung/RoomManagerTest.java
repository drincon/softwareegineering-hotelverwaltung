/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotelverwaltung;

import com.mycompany.hotelverwaltung.exceptions.RoomNumberExistsException;
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
public class RoomManagerTest extends TestCase {

    private RoomManager rm;
    private EntityManager em;
    private static final String PERSISTENCE_UNIT_NAME = "com.mycompany_Hotelverwaltung_jar_1.0-SNAPSHOTPU";
    private Customer c;
    private Room r;
    private Service s;

    public RoomManagerTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        EntityManagerFactory factory
                = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();
        rm = new RoomManager();
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

        rm.close();

        em.close();

    }

    public void testAddAndRemoveService() throws Exception {
        rm.addService("TestService", 50);
        Service tmp = null;
        Iterator<Service> it = rm.getServiceList().iterator();
        boolean check = false;
        while (it.hasNext()) {
            Service s = it.next();
            if (s.getName().equals("TestService") && s.getPrice() == 50) {
                check=true;
                tmp=s;
            }
        }
        if(!check){
            throw new Exception();
        }
        rm.removeService(tmp);
        
        it=rm.getServiceList().iterator();
        while (it.hasNext()) {
            Service s = it.next();
            if (s.getName().equals("TestService") && s.getPrice() == 50) {
                check=false;
            }
        }
        if(!check){
            throw new Exception();
        }

    }

    public void testAddAndRemoveRoom() throws RoomNumberExistsException, Exception {
        rm.addRoom("TestRoom2", 50, 2);
        Room tmp = null;
        Iterator<Room> it = rm.getRoomList().iterator();
        boolean check = false;
        while (it.hasNext()) {
            Room r = it.next();
            if (r.getPrice() == 50 && r.getName().equals("TestRoom2") && r.getRoomNumber() == 2) {
                check = true;
                tmp = r;
            }
        }
        if (!check) {
            throw new Exception();
        }
        rm.removeRoom(tmp);

        it = rm.getRoomList().iterator();
        while (it.hasNext()) {
            Room r = it.next();
            if (r.getPrice() == 50 && r.getRoomNumber() == 2 && r.getName().equals("TestRoom2")) {
                check = false;
            }
        }
        if (!check) {
            throw new Exception();
        }

    }

    public void testAddAndRemoveCustomer() throws Exception {
        rm.addCustomer("Mustermann", "Max", "musterstraße", "7", "181648", "musterstadt", "Musterland", "1.1.1900");
        Customer tmp = null;
        Iterator<Customer> it = rm.getCustomerList().iterator();
        boolean check = false;
        while (it.hasNext()) {
            Customer c = it.next();
            if (c.getName().equals("Mustermann") && c.getSurname().equals("Max") && c.getAdress().equals("musterstraße") && c.getStreetnumber().equals("7") && c.getZipcode().equals("181648") && c.getCity().equals("musterstadt") && c.getCountry().equals("Musterland") && c.getBirthday().equals("1.1.1900")) {
                check = true;
                tmp = c;
            }
        }
        if (!check) {
            throw new Exception();
        }
        rm.removeCustomer(tmp);

        it = rm.getCustomerList().iterator();
        while (it.hasNext()) {
            Customer c = it.next();
            if (c.getName().equals("Mustermann") && c.getSurname().equals("Max") && c.getAdress().equals("musterstraße") && c.getStreetnumber().equals("7") && c.getZipcode().equals("181648") && c.getCity().equals("musterstadt") && c.getCountry().equals("Musterland") && c.getBirthday().equals("1.1.1900")) {
                check = false;
            }
        }
        if (!check) {
            throw new Exception();
        }

    }

    public void testgetCustomerList() throws Exception {
        List<Customer> list = rm.getCustomerList();
        List<Customer> list2 = em.createQuery("Select c from Customer c").getResultList();
        if (!list.equals(list2)) {
            throw new Exception();
        }
    }

    public void testgetRoomList() throws Exception {
        List<Room> list = rm.getRoomList();
        List<Room> list2 = em.createQuery("Select r from Room r").getResultList();
        if (!list.equals(list2)) {
            throw new Exception();
        }
    }

    public void testRoomManager() {
        RoomManager rm = new RoomManager();
        rm.close();
    }

    public void testgetServuceList() throws Exception{
        List<Service> list= rm.getServiceList();
        List<Service> list2 = em.createQuery("Select s from Service s").getResultList();
        if(!list.equals(list2)){
            throw new Exception();
        }
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
