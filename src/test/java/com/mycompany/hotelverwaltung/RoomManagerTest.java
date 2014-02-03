/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotelverwaltung;

import com.mycompany.hotelverwaltung.persistence.RoomManager;
import com.mycompany.hotelverwaltung.persistence.Service;
import com.mycompany.hotelverwaltung.persistence.Room;
import com.mycompany.hotelverwaltung.persistence.Customer;
import com.mycompany.hotelverwaltung.persistence.Reservation;
import com.mycompany.hotelverwaltung.exceptions.RoomNumberExistsException;
import com.mycompany.hotelverwaltung.persistence.RoomType;
import static com.mycompany.hotelverwaltung.persistence.RoomType.DOUBLEROOM;
import java.util.ArrayList;
import java.util.Calendar;
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
    private Reservation re;

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

        this.r = new Room("TestRoom", 1, RoomType.DOUBLEROOM);
        persistObject(r);

        this.s = new Service("Testdienstleistung", 50);
        persistObject(s);

        Calendar arrival = Calendar.getInstance();
        arrival.set(2000, Calendar.JANUARY, 16);
        Calendar departure = Calendar.getInstance();
        departure.set(2000, Calendar.JANUARY, 18);
        List<Service> list = new ArrayList<Service>();
        list.add(s);
        List<Calendar> callist= new ArrayList<Calendar>();
        callist.add(arrival);
        
        this.re = new Reservation(1, c, r, arrival, departure, list, callist);
        persistObject(re);

    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        em.getTransaction().begin();
        re.setCustomer(null);
        em.remove(re);
        em.remove(c);
        em.remove(r);
        em.remove(s);
        em.getTransaction().commit();

        rm.close();

        printAll();

        em.close();

    }

    public void testCalculatePrice() throws Exception {
        List<Service> list = new ArrayList();
        list.add(s);
        Double d = rm.calculatePrice(re.getArrival(), re.getDeparture(), DOUBLEROOM, list);
        if (d != 250) {
            throw new Exception();
        }
        /*
         TODO: kein schöner test^^
         */
    }

    public void testUpdateCustomer() throws Exception {
        rm.updateCustomer(c.getId(), c.getName(), "Christian", c.getAdress(), c.getStreetnumber(), c.getZipcode(), c.getCity(), c.getCountry(), c.getBirthday());
        Iterator<Customer> it = rm.getCustomerList().iterator();
        boolean check = true;
        while (it.hasNext()) {
            Customer c2 = it.next();
            if (c2.getSurname().equals("Christian")) {
                check = false;
            }
        }
        if (check) {
            throw new Exception();
        }
    }

    public void testDateIsInTimeframe() throws Exception {
        Calendar checkInDate = Calendar.getInstance();
        checkInDate.set(2000, Calendar.JULY, 10);
        Calendar checkOutDate = Calendar.getInstance();
        checkOutDate.set(2000, Calendar.JULY, 20);
        Calendar checkDay = Calendar.getInstance();
        checkDay.set(2000, Calendar.JULY, 22);
        if (!rm.dateIsInTimeframe(checkInDate, checkOutDate, checkDay)) {
            throw new Exception();
        }
        checkDay.set(2000, Calendar.JULY, 9);
        if (!rm.dateIsInTimeframe(checkInDate, checkOutDate, checkDay)) {
            throw new Exception();
        }
        checkDay.set(2000, Calendar.JULY, 15);
        if (rm.dateIsInTimeframe(checkInDate, checkOutDate, checkDay)) {
            throw new Exception();
        }
    }

    public void testCheckAvailability() throws Exception {
        Calendar checkInDate = Calendar.getInstance();
        checkInDate.set(2000, Calendar.JULY, 10);
        Calendar checkOutDate = Calendar.getInstance();
        checkOutDate.set(2000, Calendar.JULY, 20);
        List<Room> list = rm.checkAvailability(checkInDate, checkOutDate, DOUBLEROOM);
        if (!list.contains(r)) {
            throw new Exception();
        }

        try {
            // TODO : checken ob alle cases funktionieren
            checkInDate.set(2000, Calendar.JANUARY, 17);

        } catch (Exception e) {

        }

    }

    public void testAddAndRemoveReservation() throws Exception {
        Calendar arrival = Calendar.getInstance();
        arrival.set(2000, Calendar.JANUARY, 10);
        Calendar departure = Calendar.getInstance();
        departure.set(2000, Calendar.JANUARY, 12);

        Customer c2 = new Customer("christian", "mustermann");
        persistObject(c2);

        Room r2 = new Room("TestRoom 2", 1, RoomType.DOUBLEROOM);
        persistObject(r2);

        Service s2 = new Service("Testdienstleistung 2", 50);
        persistObject(s2);

        List<Service> list = new ArrayList();
        list.add(s2);
        
        List<Calendar> servicesDate = new ArrayList<Calendar>();
        Calendar dateForService= Calendar.getInstance();
        dateForService.set(2000,Calendar.JANUARY,11);
        servicesDate.add(dateForService);
        

        rm.addReservation(1, c2, r2, arrival, departure, list, servicesDate);
        Reservation tmp = null;
        Iterator<Reservation> it = rm.getReservationList().iterator();
        boolean check = false;
        while (it.hasNext()) {
            Reservation re2 = it.next();
            if (re2.getReservationNumber() == 1 && re2.getCustomer().equals(c2) && re2.getArrival().equals(arrival) && re2.getDeparture().equals(departure) && re2.getRoom().equals(r2)) {
                for (int x = 0; x < re2.getServices().size(); x++) {
                    for (int y = 0; y < list.size(); y++) {
                        if (re2.getServices().get(x).equals(list.get(y))) {
                            check = true;
                            tmp = re2;
                        }
                    }
                }
            }
        }
        if (!check) {
            throw new Exception();
        }

        rm.removeReservation(tmp);

        it = rm.getReservationList().iterator();
        while (it.hasNext()) {
            Reservation re2 = it.next();
            if (re2.getReservationNumber() == 1 && re2.getCustomer().equals(c2) && re2.getArrival().equals(arrival) && re2.getDeparture().equals(departure) && re2.getRoom().equals(r2)) {
                for (int x = 0; x < re2.getServices().size(); x++) {
                    for (int y = 0; y < list.size(); y++) {
                        if (re2.getServices().get(x).equals(list.get(y))) {
                            check = true;
                        }
                    }
                }
            }
        }
        if (!check) {
            throw new Exception();
        }
        rm.removeCustomer(c2);
        rm.removeService(s2);

        rm.removeRoom(r2);

    }

    public void testAddAndRemoveService() throws Exception {
        rm.addService("TestService", 50);
        Service tmp = null;
        Iterator<Service> it = rm.getServiceList().iterator();
        boolean check = false;
        while (it.hasNext()) {
            Service s2 = it.next();
            if (s2.getName().equals("TestService") && s2.getPrice() == 50) {
                check = true;
                tmp = s2;
            }
        }
        if (!check) {
            throw new Exception();
        }
        rm.removeService(tmp);

        it = rm.getServiceList().iterator();
        while (it.hasNext()) {
            Service s2 = it.next();
            if (s2.getName().equals("TestService") && s2.getPrice() == 50) {
                check = false;
            }
        }
        if (!check) {
            throw new Exception();
        }

    }

    public void testAddAndRemoveRoom() throws RoomNumberExistsException, Exception {
        rm.addRoom("TestRoom2", 50, 2, RoomType.DOUBLEROOM);
        Room tmp = null;
        Iterator<Room> it = rm.getRoomList().iterator();
        boolean check = false;
        while (it.hasNext()) {
            Room r2 = it.next();
            if (r2.getName().equals("TestRoom2") && r2.getRoomNumber() == 2) {
                check = true;
                tmp = r2;
            }
        }
        if (!check) {
            throw new Exception();
        }
        rm.removeRoom(tmp);

        it = rm.getRoomList().iterator();
        while (it.hasNext()) {
            Room r2 = it.next();
            if (r2.getRoomNumber() == 2 && r2.getName().equals("TestRoom2")) {
                check = false;
            }
        }
        if (!check) {
            throw new Exception();
        }

    }

    public void testAddAndRemoveCustomer() throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.set(2009, Calendar.DECEMBER, 12);

        rm.addCustomer("Mustermann", "Max", "musterstraße", "7", "181648", "musterstadt", "Musterland", cal);
        Customer tmp = null;
        Iterator<Customer> it = rm.getCustomerList().iterator();
        boolean check = false;
        while (it.hasNext()) {
            Customer c2 = it.next();
            if (c2.getName().equals("Mustermann") && c2.getSurname().equals("Max") && c2.getAdress().equals("musterstraße") && c2.getStreetnumber().equals("7") && c2.getZipcode().equals("181648") && c2.getCity().equals("musterstadt") && c2.getCountry().equals("Musterland") && c2.getBirthday().equals(cal)) {
                check = true;
                tmp = c2;
            }
        }
        if (!check) {
            throw new Exception();
        }
        rm.removeCustomer(tmp);

        it = rm.getCustomerList().iterator();
        while (it.hasNext()) {
            Customer c2 = it.next();
            if (c2.getName().equals("Mustermann") && c2.getSurname().equals("Max") && c2.getAdress().equals("musterstraße") && c2.getStreetnumber().equals("7") && c2.getZipcode().equals("181648") && c2.getCity().equals("musterstadt") && c2.getCountry().equals("Musterland") && c2.getBirthday().equals(cal)) {
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
        RoomManager rm2 = new RoomManager();
        rm2.close();
    }

    public void testgetServuceList() throws Exception {
        List<Service> list = rm.getServiceList();
        List<Service> list2 = em.createQuery("Select s from Service s").getResultList();
        if (!list.equals(list2)) {
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
            Room r2 = it.next();
            System.out.println("-Room-------------------------------------" + r2.getName() + " | " + r2.getId() + "----------------------------");
        }
        q = em.createQuery("Select c from Customer c");
        List<Customer> list2 = q.getResultList();
        Iterator<Customer> it2 = list2.iterator();
        while (it2.hasNext()) {
            Customer c2 = it2.next();
            System.out.println("-Customer-------------------------------------" + c2.getName() + " " + c2.getSurname() + " " + r.getId() + "----------------------------");
        }
        q = em.createQuery("Select s from Service s");
        List<Service> list3 = q.getResultList();
        Iterator<Service> it3 = list3.iterator();
        while (it3.hasNext()) {
            Service s2 = it3.next();
            System.out.println("-Service-------------------------------------" + s2.getName() + " " + r.getId() + "----------------------------");
        }
        q = em.createQuery("Select r from Reservation r");
        List<Reservation> list4 = q.getResultList();
        Iterator<Reservation> it4 = list4.iterator();
        while (it4.hasNext()) {
            Reservation re2 = it4.next();
            System.out.println("-Reservation---------------------------------" + re2.getReservationNumber() + " " + re2.getCustomer() + " " + re2.getRoom() + " " + re2.getId() + "--------------------------");
        }

    }
}
