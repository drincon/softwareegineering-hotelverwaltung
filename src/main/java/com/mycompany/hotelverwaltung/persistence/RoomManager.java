/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotelverwaltung.persistence;

import com.mycompany.hotelverwaltung.exceptions.DepartureIsBeforeArrivalException;
import com.mycompany.hotelverwaltung.exceptions.RoomNumberExistsException;
import com.mycompany.hotelverwaltung.exceptions.ServiceAlreadyExistsException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author said
 */
public class RoomManager implements PersistenceInterface {

    private static final String PERSISTENCE_UNIT_NAME = "com.mycompany_Hotelverwaltung_jar_1.0-SNAPSHOTPU";
    private final EntityManager em;


    public RoomManager() {
        EntityManagerFactory factory
                = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();
    }

    /**
     * adds Service to the persistence
     *
     * @param name name of the service
     * @param price prive of the service
     * @throws ServiceAlreadyExistsException
     */
    @Override
    public void addService(String name, int price) throws ServiceAlreadyExistsException {
        em.getTransaction().begin();
        Service s = new Service(name, price);
        em.persist(s);
        em.getTransaction().commit();
    }

    /**
     * removes Service from the persistence
     *
     * @param s
     */
    @Override
    public void removeService(Service s) {
        em.getTransaction().begin();
        em.remove(em.find(Service.class, s.getId()));
        em.getTransaction().commit();
    }

    /**
     * reomves Room from the peristence
     *
     * @param r
     * @throws Exception
     */
    @Override
    public void removeRoom(Room r) throws Exception {
        em.getTransaction().begin();
        em.remove(em.find(Room.class, r.getId()));
        em.getTransaction().commit();

    }

    /**
     * adds Room to the persistence
     *
     * @param name name of the room
     * @param price prive of the room
     * @param roomNumber number of the room
     * @param roomType type of the room
     * @throws RoomNumberExistsException
     */
    @Override
    public void addRoom(String name, int price, int roomNumber, RoomType roomType) throws RoomNumberExistsException {
        em.getTransaction().begin();
        Room r = new Room(name, roomNumber, roomType);
        em.persist(r);
        em.getTransaction().commit();
    }

    /**
     * methode used to check if a hotelroom is available in the timeframe
     *
     * @param checkInDate checkindate
     * @param checkOutDate checkoutdate
     * @param roomtype roomtype
     * @return list of all available rooms
     */
    @Override
    public List<Room> checkAvailability(Calendar checkInDate, Calendar checkOutDate, RoomType roomtype) {
        List<Reservation> reservations = getReservationList();
        Iterator<Reservation> it = reservations.iterator();
        List<Room> rooms = new ArrayList<Room>();
        while (it.hasNext()) {
            Reservation r = it.next();
            if (r.getRoom().getRoomType() == roomtype) {
                if (r.getDeparture().equals(checkInDate)) {
                    Iterator it2 = reservations.iterator();
                    while (it2.hasNext()) {
                        Reservation r2 = it.next();
                        if (r.getRoom().equals(r2.getRoom()) && !dateIsInTimeframe(checkInDate, checkOutDate, r2.getArrival())) {
                            if (!r.getRoom().equals(r2.getRoom())) {
                                addRoomToList(rooms, r.getRoom());
                            }
                        }
                    }
                }
                if (dateIsInTimeframe(checkInDate, checkOutDate, r.getDeparture()) && dateIsInTimeframe(checkInDate, checkOutDate, r.getArrival())) {
                    addRoomToList(rooms, r.getRoom());
                }
            }
        }
        List<Room> allRooms = getRoomList();
        Iterator<Room> itroom = allRooms.iterator();
        System.out.println(rooms);
        while (itroom.hasNext()) {
            Room r = itroom.next();
            it = reservations.iterator();
            while (it.hasNext()) {
                Reservation re = it.next();
                if (re.getRoom().equals(r)) {
                    if (!dateIsInTimeframe(checkInDate, checkOutDate, re.getArrival()) || !dateIsInTimeframe(checkInDate, checkOutDate, re.getDeparture())) {
                        rooms.remove(r);
                    }
                }
            }
        }
        return rooms;
    }

    /**
     * adds reservation to the persistence
     *
     * @param reservationNumber number of reservation
     * @param c customer
     * @param r room
     * @param arrival date of arrival
     * @param departure date of departure
     * @param services booked services
     * @throws DepartureIsBeforeArrivalException
     */
    @Override
    public void addReservation(int reservationNumber, Customer c, Room r, Calendar arrival, Calendar departure, List<Service> services, Calendar[] servicesDates) throws DepartureIsBeforeArrivalException {
        em.getTransaction().begin();
        em.persist(new Reservation(reservationNumber, c, r, arrival, departure, services, servicesDates));
        em.getTransaction().commit();
    }

    /**
     * removes Reservation
     *
     * @param r
     */
    @Override
    public void removeReservation(Reservation r) {
        em.getTransaction().begin();
        em.remove(em.find(Reservation.class, r.getId()));
        em.getTransaction().commit();
    }

    // TO DO: TEST!!
    @Override
    public void removeReservation(int id) {
        em.getTransaction().begin();
        em.remove(em.find(Reservation.class, id));
        em.getTransaction().commit();
    }

    /**
     * gets list with all reservations
     *
     * @return
     */
    @Override
    public List<Reservation> getReservationList() {
        return em.createQuery("Select re from Reservation re").getResultList();
    }

    /**
     * gets list with all customers
     *
     * @return
     */
    @Override
    public List<Customer> getCustomerList() {
        return em.createQuery("Select c from Customer c").getResultList();
    }

    /**
     * gets list with all Rooms
     *
     * @return
     */
    @Override
    public List<Room> getRoomList() {
        return em.createQuery("Select r from Room r").getResultList();
    }

    /**
     * gets list with all services
     *
     * @return
     */
    @Override
    public List<Service> getServiceList() {
        return em.createQuery("Select s from Service s").getResultList();
    }

    /**
     * adds customer to the persistence
     *
     * @param name name of the customer
     * @param surname surname of the customer
     * @param adress adress of the customer
     * @param streetnumber streetnumber of the customer
     * @param zipcode zipcode of the customer
     * @param city city of the customer
     * @param country country of the customer
     * @param birthday Calendar-Object birthday of the customer
     */
    @Override
    public void addCustomer(String name, String surname, String adress, String streetnumber, String zipcode, String city, String country, Calendar birthday) {
        em.getTransaction().begin();
        em.persist(new Customer(name, surname, adress, streetnumber, zipcode, city, country, birthday));
        em.getTransaction().commit();
    }

    //untested
    public void removeCustomer(int id) {
        em.getTransaction().begin();
        em.remove(em.find(Customer.class, id));
        em.getTransaction().commit();
    }

    /**
     * removes Customer from persistence
     *
     * @param c
     */
    @Override
    public void removeCustomer(Customer c) {
        em.getTransaction().begin();
        em.remove(em.find(Customer.class, c.getId()));
        em.getTransaction().commit();
    }


    /**
     * used to close the entitymanager
     */
    public void close() {
        em.close();
    }

    /**
     * updates customer information
     *
     * @param id
     * @param name name of the customer
     * @param surname surname of the customer
     * @param adress adress of the customer
     * @param streetnumber streetnumber of the customer
     * @param zipcode zipcode of the customer
     * @param city city of the customer
     * @param country country of the customer
     * @param birthday Calendar-Object birthday of the customer
     */
    @Override
    public void updateCustomer(Long id, String name, String surname, String adress, String streetnumber, String zipcode, String city, String country, Calendar birthday) {
        em.getTransaction().begin();
        Customer c = em.find(Customer.class, id);
        c.setName(name);
        c.setSurname(surname);
        c.setAdress(adress);
        c.setStreetnumber(streetnumber);
        c.setZipcode(zipcode);
        c.setCity(city);
        c.setCountry(country);
        c.setBirthday(birthday);
        em.getTransaction().commit();

    }

    /**
     * calculates Price of possible stay
     *
     * @param checkInDate checkin date
     * @param checkOutDate checkout date
     * @param roomtype type of room
     * @param services booked services
     * @return
     * @throws com.mycompany.hotelverwaltung.exceptions.DepartureIsBeforeArrivalException
     */
    @Override
    public Double calculatePrice(Calendar checkInDate, Calendar checkOutDate, RoomType roomtype, List<Service> services) throws DepartureIsBeforeArrivalException {
        if(checkOutDate.before(checkInDate)){
            throw new DepartureIsBeforeArrivalException();
        }
        Long price = (checkOutDate.getTimeInMillis() - checkInDate.getTimeInMillis()) / (1000 * 60 * 60 * 24) * roomtype.getValue();
        Iterator<Service> it = services.iterator();
        while (it.hasNext()) {
            Service s = it.next();
            price = price + s.getPrice();
        }
        return price.doubleValue();
    }

    /**
     * helping method used to check if date i in a timeframe used to be private
     * but for testing purposes its public!!!
     *
     * @param begin of timeframe
     * @param end of timeframe
     * @param date date to check
     * @return
     */
    public boolean dateIsInTimeframe(Calendar begin, Calendar end, Calendar date) {
        if (begin.before(date) && end.after(date)) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * used to check if room is already in list and if not room is added to the
     * list
     *
     * @param rooms list object
     * @param r room
     */
    private void addRoomToList(List<Room> rooms, Room r) {
        if (!rooms.contains(r)) {
            rooms.add(r);
        }
    }

}
