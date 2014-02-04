/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotelverwaltung.gui;

import com.mycompany.hotelverwaltung.exceptions.DepartureIsBeforeArrivalException;
import com.mycompany.hotelverwaltung.exceptions.ServiceDateIsNotDuringStayException;
import com.mycompany.hotelverwaltung.persistence.Customer;
import com.mycompany.hotelverwaltung.persistence.PersistenceInterface;
import com.mycompany.hotelverwaltung.persistence.Room;
import com.mycompany.hotelverwaltung.persistence.Service;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Eddybrando
 */
public class NewBookingSuccess extends javax.swing.JFrame {

    private final PersistenceInterface pi;
    private final Calendar checkIn;
    private final Calendar checkOut;
    private final Room room;
    private final Customer customer;
    private final List<Service> services;
    private final List<Calendar> servicesDates;

    /**
     * Creates new form NewBookingSuccess
     * @param pi
     * @param checkIn
     * @param checkOut
     * @param servicesDates
     * @param room
     * @param customer
     * @param services
     *
     */

    public NewBookingSuccess(PersistenceInterface pi, Calendar checkIn, Calendar checkOut, Room room, Customer customer, List<Service> services, List<Calendar> servicesDates)  {
        this.pi = pi;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.room = room;
        this.customer = customer;
        this.services = services;
        this.servicesDates = servicesDates;

        initComponents();
        AnredeNameNachname.setText(customer.getAdress() + " " + customer.getName() + " " + customer.getSurname());
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
        CheckOutDate.setText(format1.format(checkOut.getTime()));
        Land.setText(customer.getCountry());
        RoomNumber.setText(Integer.toString(room.getRoomNumber()));
        Iterator<Service> it = services.iterator();
        String s = "";

        while (it.hasNext()) {
            Service ser = it.next();
            s = s + ser.getName() + " " + format1.format(servicesDates.get(services.indexOf(ser)).getTime()) + "\n";
        }
        Services.setText(s);
        Street.setText(customer.getStreetnumber());
        ZipcodeCity.setText(customer.getZipcode());
        checkInDate.setText(format1.format(checkIn.getTime()));
        Double d = null;
        try {
            d = pi.calculatePrice(checkIn, checkOut, room.getRoomType(), services);
        } catch (DepartureIsBeforeArrivalException ex) {
           // Exception was thrown by this method to because i was wrong about the application flow.
        }
        price.setText(String.valueOf(d));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        AnredeNameNachname = new javax.swing.JLabel();
        Street = new javax.swing.JLabel();
        ZipcodeCity = new javax.swing.JLabel();
        Land = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        checkInDate = new javax.swing.JLabel();
        CheckOutDate = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        RoomNumber = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Services = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        price = new javax.swing.JLabel();
        bookNow = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Buchun bestätigen - B&V Hotels");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(33, 100, 155));
        jPanel1.setForeground(new java.awt.Color(255, 204, 51));

        jPanel2.setBackground(new java.awt.Color(22, 76, 136));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BUCHUNG BESTÄTIGEN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("KUNDE:");

        AnredeNameNachname.setForeground(new java.awt.Color(255, 204, 51));
        AnredeNameNachname.setText("Anrede + Vorname + Nachname");

        Street.setForeground(new java.awt.Color(255, 204, 51));
        Street.setText("Straße");

        ZipcodeCity.setForeground(new java.awt.Color(255, 204, 51));
        ZipcodeCity.setText("PLZ + Stadt");

        Land.setForeground(new java.awt.Color(255, 204, 51));
        Land.setText("Land");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("DATUM:");

        checkInDate.setForeground(new java.awt.Color(255, 204, 51));
        checkInDate.setText("CheckInDate");

        CheckOutDate.setForeground(new java.awt.Color(255, 204, 51));
        CheckOutDate.setText("CheckOutDate");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("ZIMMER:");

        RoomNumber.setForeground(new java.awt.Color(255, 204, 51));
        RoomNumber.setText("Zimmernummer");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("DIENSTLEISTUNGEN:");

        Services.setForeground(new java.awt.Color(255, 204, 51));
        Services.setText("DL[]");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("PREIS:");

        price.setForeground(new java.awt.Color(255, 204, 51));
        price.setText("PREIS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RoomNumber)
                            .addComponent(CheckOutDate)
                            .addComponent(checkInDate)
                            .addComponent(Land)
                            .addComponent(ZipcodeCity)
                            .addComponent(Street)
                            .addComponent(AnredeNameNachname)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(34, 34, 34)
                                .addComponent(price))
                            .addComponent(jLabel12))
                        .addGap(51, 51, 51)
                        .addComponent(Services)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(AnredeNameNachname))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Street)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ZipcodeCity)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Land)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(checkInDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CheckOutDate)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(RoomNumber))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(Services))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(price))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        bookNow.setText("Buchen");
        bookNow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookNowActionPerformed(evt);
            }
        });

        jButton2.setText("Abbrechen");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(bookNow)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookNow)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(404, 552));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
        StartWindow s = new StartWindow(pi);
        s.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void bookNowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookNowActionPerformed
        dispose();
        Random random = new Random(customer.getId() + room.getId() + checkIn.getTimeInMillis() + checkOut.getTimeInMillis());
        int i = random.nextInt();
        if (i <= 0) {
            i = i * -1;
        }
        try {
            pi.addReservation(i, customer, room, checkIn, checkOut, services, servicesDates);
        } catch (DepartureIsBeforeArrivalException ex) {
            // doesnt happen because was already checked.
        } catch (ServiceDateIsNotDuringStayException ex) {
            // doesnt happen because was already checked.
        }
        StartWindow s = new StartWindow(pi);
        s.setVisible(true);
    }//GEN-LAST:event_bookNowActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewBookingSuccess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewBookingSuccess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewBookingSuccess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewBookingSuccess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AnredeNameNachname;
    private javax.swing.JLabel CheckOutDate;
    private javax.swing.JLabel Land;
    private javax.swing.JLabel RoomNumber;
    private javax.swing.JLabel Services;
    private javax.swing.JLabel Street;
    private javax.swing.JLabel ZipcodeCity;
    private javax.swing.JButton bookNow;
    private javax.swing.JLabel checkInDate;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel price;
    // End of variables declaration//GEN-END:variables
}
