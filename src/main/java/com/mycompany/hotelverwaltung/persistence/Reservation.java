/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotelverwaltung.persistence;

import com.mycompany.hotelverwaltung.exceptions.DepartureIsBeforeArrivalException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 * Reservation is an entity that represents a reservation of a hotelroom in the
 * persistence.
 *
 * @author said
 */
@Entity
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RES_ID")
    private Long id;

    int reservationNumber;

    @ManyToOne
    @JoinColumn(name = "customer_fk")
    private Customer customer;

    @ManyToOne
    private Room room;

    @ManyToMany
    private List<Service> services;

    private String[] servicesDates;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar arrival;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar departure;

    public Reservation() {

    }

    /**
     * constructs one entity of reservation
     *
     * @param reservationNumber
     * @param c
     * @param r
     * @param arrival
     * @param departure
     * @param services
     * @param servicesDates
     * @throws DepartureIsBeforeArrivalException
     */
    public Reservation(int reservationNumber, Customer c, Room r, Calendar arrival, Calendar departure, List<Service> services, List<Calendar> servicesDates) throws DepartureIsBeforeArrivalException {
        this.reservationNumber = reservationNumber;
        this.customer = c;
        this.room = r;
        if (departure.before(arrival)) {
            throw new DepartureIsBeforeArrivalException();
        }
        this.departure = departure;
        this.arrival = arrival;
        this.services = services;
        if (servicesDates == null) {
            this.servicesDates = null;
        } else {
            this.servicesDates = new String[servicesDates.size()];
            for (int i = 0; i < servicesDates.size(); i++) {
                this.servicesDates[i] = servicesDates.get(i).getTime().toString();
            }
        }

    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<Calendar> getServicesDates() {
        List<Calendar> list = new ArrayList<Calendar>();
        for (String servicesDate : servicesDates) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date(servicesDate));
            list.add(cal);
        }
        return list;
    }

    public void setServicesDates(List<Calendar> servicesDates) {
        this.servicesDates = new String[servicesDates.size()];
        for (int i = 0; i < servicesDates.size(); i++) {
            this.servicesDates[i] = servicesDates.get(i).getTime().toString();
        }
    }

    public Calendar getArrival() {
        return arrival;
    }

    public void setArrival(Calendar arrival) {
        this.arrival = arrival;
    }

    public Calendar getDeparture() {
        return departure;
    }

    public void setDeparture(Calendar departure) {
        this.departure = departure;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.hotelverwaltung.Reservation[ id=" + id + " ]";
    }

}
