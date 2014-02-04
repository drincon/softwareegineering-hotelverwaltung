package com.mycompany.hotelverwaltung;

import com.mycompany.hotelverwaltung.exceptions.RoomNumberExistsException;
import com.mycompany.hotelverwaltung.exceptions.ServiceAlreadyExistsException;
import com.mycompany.hotelverwaltung.gui.StartWindow;
import com.mycompany.hotelverwaltung.persistence.PersistenceInterface;
import com.mycompany.hotelverwaltung.persistence.RoomManager;
import static com.mycompany.hotelverwaltung.persistence.RoomType.DOUBLEROOM;
import static com.mycompany.hotelverwaltung.persistence.RoomType.SINGLEROOM;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws RoomNumberExistsException, ServiceAlreadyExistsException {
       
        PersistenceInterface pi = new RoomManager();
        /*Calendar cal = Calendar.getInstance();
        cal.set(2009, Calendar.DECEMBER, 12);

        pi.addCustomer("Mustermann", "Max", "musterstraße", "7", "181648", "Herr", "Musterland", cal);
        pi.addRoom("test", 1, SINGLEROOM);

        pi.addService("Dampfbad", 34);
        pi.addService("Sauna", 59);
        */
        

        StartWindow s = new StartWindow(pi);

        s.setVisible(true);

    }

}
