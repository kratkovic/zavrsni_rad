/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package motovodic.view;

import java.awt.event.KeyEvent;
import motovodic.controller.ObradaOperater;
import motovodic.model.Operater;
import motovodic.util.Aplikacija;


public class ProzorLogin extends javax.swing.JFrame {

    
    private ObradaOperater obrada;
    /**
     * Creates new form ProzorScreen
     */
 public ProzorLogin() {
        initComponents();
        obrada = new ObradaOperater();
        setTitle(Aplikacija.NAZIV_APP + " Login");
    }

    private void autoriziraj() {
        lblPoruka.setText("");
        if (txtEmail.getText().isEmpty()) {
            lblPoruka.setText("Obavezno email");
            return;
        }

        if (pswLozinka.getPassword().length == 0) {
            lblPoruka.setText("Obavezno lozinka");
            return;
        }

        Operater o = obrada.autoriziraj(txtEmail.getText(),
                pswLozinka.getPassword());

        if (o == null) {
            lblPoruka.setText("Neispravna kombinacija email i lozinka");
            return;
        }
        Aplikacija.OPERATER=o;

        new ProzorIzbornik().setVisible(true);
        dispose();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pswLozinka = new javax.swing.JPasswordField();
        btnAutoriziraj = new javax.swing.JButton();
        lblPoruka = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Email");

        txtEmail.setText("ratkovic.kristijan@gmail.com");
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailKeyPressed(evt);
            }
        });

        jLabel2.setText("Lozinka");

        pswLozinka.setText("Motovodic23");
        pswLozinka.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pswLozinkaKeyPressed(evt);
            }
        });

        btnAutoriziraj.setText("Autoriziraj");
        btnAutoriziraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutorizirajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAutoriziraj, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                            .addComponent(pswLozinka, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail)
                            .addComponent(lblPoruka, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pswLozinka, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(btnAutoriziraj, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(lblPoruka, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAutorizirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutorizirajActionPerformed
       autoriziraj();
    }//GEN-LAST:event_btnAutorizirajActionPerformed

    private void txtEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyPressed
        lblPoruka.setText("");
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtEmail.getText().isEmpty()) {
                lblPoruka.setText("Obavezno email");
                return;
            }

            if (pswLozinka.getPassword().length == 0) {
                pswLozinka.requestFocus();
                lblPoruka.setText("Obavezno lozinka");
                return;
            }
            autoriziraj();
        }
    }//GEN-LAST:event_txtEmailKeyPressed

    private void pswLozinkaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pswLozinkaKeyPressed
      lblPoruka.setText("");
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (pswLozinka.getPassword().length == 0) {
                lblPoruka.setText("Obavezno lozinka");
                return;
            }

            if (txtEmail.getText().isEmpty()) {
                lblPoruka.setText("Obavezno email");
                txtEmail.requestFocus();
                return;
            }
            autoriziraj();
        }
    }//GEN-LAST:event_pswLozinkaKeyPressed

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAutoriziraj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblPoruka;
    private javax.swing.JPasswordField pswLozinka;
    private javax.swing.JTextField txtEmail;
    // End of variables declaration//GEN-END:variables
}
