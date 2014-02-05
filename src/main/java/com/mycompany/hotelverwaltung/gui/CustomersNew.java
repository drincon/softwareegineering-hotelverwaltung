/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotelverwaltung.gui;

import com.mycompany.hotelverwaltung.persistence.*;
import java.util.Calendar;

/**
 * JFrame used to add a customer.
 * @author Eddybrando, Felix Brass
 */
public class CustomersNew extends javax.swing.JFrame {

    private final PersistenceInterface pi;
    

    /**
     * Creates new form CustomersNew
     * @param pi
     */
    public CustomersNew(PersistenceInterface pi) {
        initComponents();
        this.pi = pi;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameAddressLabel = new javax.swing.JLabel();
        surnameTextField = new javax.swing.JTextField();
        nameAddressComboBox = new javax.swing.JComboBox();
        surnameLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        birthdayLabel = new javax.swing.JLabel();
        streetLabel = new javax.swing.JLabel();
        doneButton = new javax.swing.JButton();
        birthdayDatePicker = new org.jdesktop.swingx.JXDatePicker();
        streetTextField = new javax.swing.JTextField();
        zipLabel = new javax.swing.JLabel();
        zipTextField = new javax.swing.JTextField();
        cityLabel = new javax.swing.JLabel();
        cityTextField = new javax.swing.JTextField();
        countryLabel = new javax.swing.JLabel();
        countryTextField = new javax.swing.JTextField();
        exitButton = new javax.swing.JButton();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Neue Kunde - B&V Hotels");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(33, 100, 155));

        jPanel3.setBackground(new java.awt.Color(22, 76, 136));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NEUE KUNDE");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(15, 15, 15))
        );

        nameAddressLabel.setForeground(new java.awt.Color(255, 255, 255));
        nameAddressLabel.setText("ANREDE:");

        surnameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surnameTextFieldActionPerformed(evt);
            }
        });

        nameAddressComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Frau", "Herr", "Dr.", "Prof. Dr." }));
        nameAddressComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameAddressComboBoxActionPerformed(evt);
            }
        });

        surnameLabel.setForeground(new java.awt.Color(255, 255, 255));
        surnameLabel.setText("VORNAME:");

        nameLabel.setForeground(new java.awt.Color(255, 255, 255));
        nameLabel.setText("NACHNAME:");

        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });

        birthdayLabel.setForeground(new java.awt.Color(255, 255, 255));
        birthdayLabel.setText("GEBURTSTAG:");

        streetLabel.setForeground(new java.awt.Color(255, 255, 255));
        streetLabel.setText("STRAßE & NR.:");

        doneButton.setBackground(new java.awt.Color(255, 255, 255));
        doneButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        doneButton.setForeground(new java.awt.Color(22, 76, 136));
        doneButton.setText("Fertig");
        doneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButtonActionPerformed(evt);
            }
        });

        birthdayDatePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                birthdayDatePickerActionPerformed(evt);
            }
        });

        streetTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                streetTextFieldActionPerformed(evt);
            }
        });

        zipLabel.setForeground(new java.awt.Color(255, 255, 255));
        zipLabel.setText("PLZ:");

        cityLabel.setForeground(new java.awt.Color(255, 255, 255));
        cityLabel.setText("STADT:");

        countryLabel.setForeground(new java.awt.Color(255, 255, 255));
        countryLabel.setText("LAND:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameAddressLabel)
                            .addComponent(surnameLabel)
                            .addComponent(nameLabel)
                            .addComponent(birthdayLabel)
                            .addComponent(streetLabel)
                            .addComponent(zipLabel)
                            .addComponent(cityLabel)
                            .addComponent(countryLabel))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(surnameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                    .addComponent(nameTextField)
                                    .addComponent(nameAddressComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(birthdayDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(141, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(streetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(zipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(doneButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cityTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(countryTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(43, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameAddressLabel)
                    .addComponent(nameAddressComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(surnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(surnameLabel))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(birthdayLabel)
                    .addComponent(birthdayDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(streetLabel)
                    .addComponent(streetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zipLabel)
                    .addComponent(zipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cityLabel)
                    .addComponent(cityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(countryLabel)
                    .addComponent(countryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(doneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        exitButton.setBackground(new java.awt.Color(187, 187, 187));
        exitButton.setText("Beenden");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        back.setBackground(new java.awt.Color(187, 187, 187));
        back.setText("« Abbrechen");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitButton)
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back)
                    .addComponent(exitButton))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(423, 606));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        dispose();
        CustomersManagement s = new CustomersManagement(pi);
        s.setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneButtonActionPerformed
        if ("".equals(surnameTextField.getText())) {
            String errorMessage = BITTE__VORNAME_EINGEBEN;
            ErrorWindow s = new ErrorWindow(errorMessage);
            s.setVisible(true);
        } else if ("".equals(nameTextField.getText())) {
            String errorMessage = BITTE__NACHNAME_EINGEBEN;
            ErrorWindow s = new ErrorWindow(errorMessage);
            s.setVisible(true);
        } else if (birthdayDatePicker.getDate() == null) {
            String errorMessage = BITTE__GEBURTSTAG_EINGEBEN;
            ErrorWindow s = new ErrorWindow(errorMessage);
            s.setVisible(true);
        } else if ("".equals(streetTextField.getText())) {
            String errorMessage = BITTE__STRAßE_UND__NUMMER_EINGEBEN;
            ErrorWindow s = new ErrorWindow(errorMessage);
            s.setVisible(true);
        } else if ("".equals(zipTextField.getText())) {
            String errorMessage = BITTE__POSTLEITZAHL_EINGEBEN;
            ErrorWindow s = new ErrorWindow(errorMessage);
            s.setVisible(true);
        } else if ("".equals(cityTextField.getText())) {
            String errorMessage = BITTE__STADT_EINGEBEN;
            ErrorWindow s = new ErrorWindow(errorMessage);
            s.setVisible(true);
        } else if ("".equals(countryTextField.getText())) {
            String errorMessage = BITTE__LAND_EINGEBEN;
            ErrorWindow s = new ErrorWindow(errorMessage);
            s.setVisible(true);
        } else {

            String name = nameTextField.getText();
            String surname = surnameTextField.getText();
            String nameAddress = nameAddressComboBox.getSelectedItem().toString();
            String street = streetTextField.getText();
            String zip = zipTextField.getText();
            String city = cityTextField.getText();
            String country = countryTextField.getText();
            Calendar birthday = Calendar.getInstance();
            birthday.setTime(birthdayDatePicker.getDate());

            pi.addCustomer(name, surname, nameAddress, street, zip, city, country, birthday);

            dispose();
            CustomersManagement s = new CustomersManagement(pi);
            s.setVisible(true);

        }
    }//GEN-LAST:event_doneButtonActionPerformed
    private static final String BITTE__STRAßE_UND__NUMMER_EINGEBEN = "Bitte Straße und Nummer eingeben.";
    private static final String BITTE__POSTLEITZAHL_EINGEBEN = "Bitte Postleitzahl eingeben.";
    private static final String BITTE__STADT_EINGEBEN = "Bitte Stadt eingeben.";
    private static final String BITTE__LAND_EINGEBEN = "Bitte Land eingeben.";
    private static final String BITTE__GEBURTSTAG_EINGEBEN = "Bitte Geburtstag eingeben.";
    private static final String BITTE__NACHNAME_EINGEBEN = "Bitte Nachname eingeben.";
    private static final String BITTE__VORNAME_EINGEBEN = "Bitte Vorname eingeben.";

    private void surnameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surnameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_surnameTextFieldActionPerformed

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void nameAddressComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameAddressComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameAddressComboBoxActionPerformed

    private void birthdayDatePickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_birthdayDatePickerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_birthdayDatePickerActionPerformed

    private void streetTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_streetTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_streetTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(CustomersNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomersNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomersNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomersNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private org.jdesktop.swingx.JXDatePicker birthdayDatePicker;
    private javax.swing.JLabel birthdayLabel;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JTextField cityTextField;
    private javax.swing.JLabel countryLabel;
    private javax.swing.JTextField countryTextField;
    private javax.swing.JButton doneButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JComboBox nameAddressComboBox;
    private javax.swing.JLabel nameAddressLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel streetLabel;
    private javax.swing.JTextField streetTextField;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JTextField surnameTextField;
    private javax.swing.JLabel zipLabel;
    private javax.swing.JTextField zipTextField;
    // End of variables declaration//GEN-END:variables
}
