/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotelverwaltung.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 * Customer entity. represents one customer in the persitence
 * @author said
 */
@Entity
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // TODO: Zahlen zu Zahlen machen und nicht Integer
    private String surname;
    private String name;
    private String adress;
    private String streetnumber;
    private String zipcode;
    private String city;
    private String country;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar birthday;

    @OneToMany(mappedBy = "customer")
    private Collection<Reservation> reservations;

    public Customer() {
        this.reservations = new ArrayList<Reservation>();
    }

    //constructor for test purposes only
    public Customer(String name, String surname) {
        this.reservations = new ArrayList<Reservation>();
        this.name = name;
        this.surname = surname;
    }

    /**
     * Constructor of a Customer entity
     * @param name
     * @param surname
     * @param adress
     * @param streetnumber
     * @param zipcode
     * @param city
     * @param country
     * @param birthday 
     */
    public Customer(String name, String surname, String adress, String streetnumber, String zipcode, String city, String country, Calendar birthday) {
        this.reservations = new ArrayList<Reservation>();
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.streetnumber = streetnumber;
        this.zipcode = zipcode;
        this.city = city;
        this.country = country;
        this.birthday = birthday;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getStreetnumber() {
        return streetnumber;
    }

    public void setStreetnumber(String streetnumber) {
        this.streetnumber = streetnumber;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public Collection<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Collection<Reservation> reservations) {
        this.reservations = reservations;
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
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.hotelverwaltung.Customer[ id=" + id + " ]";
    }

}
