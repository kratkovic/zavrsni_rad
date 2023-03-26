/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package motovodic.view;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import motovodic.controller.ObradaMotoKlub;
import motovodic.model.MotoKlub;
import motovodic.util.Aplikacija;
import motovodic.util.MotoVodicException;

/**
 *
 * @author Kiki
 */
public class ProzorMotoKlub extends javax.swing.JFrame {
    
    private ObradaMotoKlub obrada;

    /**
     * Creates new form ProzorMotoKlub
     */
    public ProzorMotoKlub() {
        initComponents();
        obrada = new ObradaMotoKlub();
        setTitle(Aplikacija.NAZIV_APP + ": "
                + Aplikacija.OPERATER.getImePrezime()
                + ": MotoKlubovi");
        ucitaj();
    }
    
    private void ucitaj() {
        DefaultListModel<MotoKlub> m = new DefaultListModel<>();
        m.addAll(obrada.read());
        lstPodaci.setModel(m);
        lstPodaci.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstPodaci = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMjesto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        chbRegistracija = new javax.swing.JCheckBox();
        btnDodaj = new javax.swing.JButton();
        txtBrojClanova = new javax.swing.JTextField();
        btnPromjeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstPodaci.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstPodaci.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstPodaciValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstPodaci);

        jLabel1.setText("Naziv");

        txtNaziv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNazivActionPerformed(evt);
            }
        });

        jLabel2.setText("Mjesto");

        jLabel3.setText("Broj članova");

        chbRegistracija.setText("Registriran");

        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        txtBrojClanova.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        btnPromjeni.setText("Promjeni");
        btnPromjeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obriši");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(txtNaziv)
                            .addComponent(jLabel2)
                            .addComponent(txtMjesto)
                            .addComponent(jLabel3)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPromjeni)
                                .addGap(13, 13, 13))
                            .addComponent(txtBrojClanova, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                            .addComponent(chbRegistracija, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMjesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBrojClanova, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(chbRegistracija)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDodaj)
                            .addComponent(btnPromjeni))
                        .addGap(18, 18, 18)
                        .addComponent(btnObrisi))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNazivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNazivActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNazivActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        obrada.setEntitet(new MotoKlub());
        napuniModel();
        try {
            obrada.create();
            ucitaj();
        } catch (MotoVodicException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
        }
        
    }//GEN-LAST:event_btnDodajActionPerformed

    private void lstPodaciValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstPodaciValueChanged
        if (evt.getValueIsAdjusting()) {
            return;
        }
        if (lstPodaci.getSelectedValue() == null) {
            return;
        }
        
        obrada.setEntitet(lstPodaci.getSelectedValue());
        
        napuniView();
    }//GEN-LAST:event_lstPodaciValueChanged

    private void btnPromjeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniActionPerformed
        if(lstPodaci.getSelectedValue()==null){
            JOptionPane.showMessageDialog(getRootPane(),
                    "Prvo odaberite moto klub");
            return;
        }
        napuniModel();
        try {
            obrada.update();
            ucitaj();
        } catch (MotoVodicException ex) {
          JOptionPane.showMessageDialog(getRootPane()
                  , ex.getPoruka());
        }
    }//GEN-LAST:event_btnPromjeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
       if(lstPodaci.getSelectedValue()==null){
            JOptionPane.showMessageDialog(getRootPane(),
                    "Prvo odaberite moto klub");
            return;
       }
        if(JOptionPane.showConfirmDialog(
                getRootPane(),
                "Sigurno obrisati " + obrada.getEntitet().getNaziv() + "?",
                "Brisanje",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE)==JOptionPane.NO_OPTION){
            return;
        }
       try {
           
            obrada.delete();
            ucitaj();
        } catch (MotoVodicException ex) {
          JOptionPane.showMessageDialog(getRootPane()
                  , ex.getPoruka());
        }
          
        
    }//GEN-LAST:event_btnObrisiActionPerformed
    
    private void napuniView() {
        var s = obrada.getEntitet();
        txtNaziv.setText(s.getNaziv());
        txtMjesto.setText(s.getMjesto());
        try {
            txtBrojClanova.setText(String.valueOf(s.getBrojclanova()));            
        } catch (Exception e) {
            txtBrojClanova.setText("");
        }
        
        chbRegistracija.setSelected(s.isRegistracija());
    }

    private void napuniModel() {
        var s = obrada.getEntitet();
        s.setNaziv(txtNaziv.getText());
        try {
            s.setBrojclanova(Integer.parseInt(txtBrojClanova.getText()));
        } catch (Exception e) {
            s.setBrojclanova(0);
        }
    }
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromjeni;
    private javax.swing.JCheckBox chbRegistracija;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<MotoKlub> lstPodaci;
    private javax.swing.JTextField txtBrojClanova;
    private javax.swing.JTextField txtMjesto;
    private javax.swing.JTextField txtNaziv;
    // End of variables declaration//GEN-END:variables
}
