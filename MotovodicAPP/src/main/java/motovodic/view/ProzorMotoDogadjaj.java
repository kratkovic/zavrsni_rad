/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package motovodic.view;

import com.github.lgooddatepicker.components.DatePickerSettings;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import motovodic.controller.ObradaMotoDogadjaj;
import motovodic.controller.ObradaMotoKlub;
import motovodic.model.MotoDogadjaj;
import motovodic.model.MotoKlub;
import motovodic.util.Aplikacija;
import motovodic.util.MotoVodicException;

/**
 *
 * @author Kiki
 */
public class ProzorMotoDogadjaj extends javax.swing.JFrame {
    
    private ObradaMotoDogadjaj obrada;

    /**
     * Creates new form ProzorMotoDogadjaj
     */
    public ProzorMotoDogadjaj() {
        initComponents();
        obrada = new ObradaMotoDogadjaj();
        setTitle(Aplikacija.NAZIV_APP + ": "
                + Aplikacija.OPERATER.getImePrezime()
                + ": Moto događaji");
        definirajDatumPocetka();
        definirajVrijemePocetka();
        ucitajFilterMotoKlubovi();
        ucitajMotoKlubove();
        ucitaj();
        
    }
    
    private void definirajVrijemePocetka(){
        
    }
    
    private void definirajDatumPocetka(){
        DatePickerSettings dps = 
                new DatePickerSettings(new Locale("hr", "HR"));
        dps.setFormatForDatesCommonEra("dd. MM. YYYY.");
        dps.setTranslationClear("Očisti");
        dps.setTranslationToday("Danas");
        dpDatumPocetka.setSettings(dps);
    }
    
    private void ucitajMotoKlubove() {
        DefaultComboBoxModel<MotoKlub> m
                = new DefaultComboBoxModel<>();
        MotoKlub mk = new MotoKlub();
        mk.setSifra(0);
        mk.setNaziv("Odaberite");
        mk.setMjesto("moto klub");
        m.addElement(mk);
        m.addAll(new ObradaMotoKlub().read());
        cmbMotoKlubovi.setModel(m);
        cmbMotoKlubovi.repaint();
        
    }
    
    private void ucitajFilterMotoKlubovi() {
        DefaultComboBoxModel<MotoKlub> m
                = new DefaultComboBoxModel<>();
        m.addAll(new ObradaMotoKlub().read());
        cmbFilterMotoKlubovi.setModel(m);
        cmbFilterMotoKlubovi.repaint();
        cmbFilterMotoKlubovi.setSelectedIndex(0);
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
        cmbFilterMotoKlubovi = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbMotoKlubovi = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtOdgovorniClan = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        dpDatumPocetka = new com.github.lgooddatepicker.components.DatePicker();
        jLabel7 = new javax.swing.JLabel();
        txtMjestoOdrzavanja = new javax.swing.JTextField();
        btnDodaj = new javax.swing.JButton();
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

        cmbFilterMotoKlubovi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbFilterMotoKluboviItemStateChanged(evt);
            }
        });

        jLabel4.setText("Moto Klub");

        txtNaziv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNazivActionPerformed(evt);
            }
        });

        jLabel5.setText("Naziv");

        jLabel6.setText("Odgovorni član");

        txtOdgovorniClan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOdgovorniClanActionPerformed(evt);
            }
        });

        jLabel1.setText("Datum početka");

        jLabel7.setText("Mjesto održavanja");

        txtMjestoOdrzavanja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMjestoOdrzavanjaActionPerformed(evt);
            }
        });

        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

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
                .addGap(235, 235, 235)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(cmbMotoKlubovi, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(102, 102, 102))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(cmbFilterMotoKlubovi, 0, 205, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(dpDatumPocetka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(txtOdgovorniClan, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMjestoOdrzavanja, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86)
                                .addComponent(btnPromjeni))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(337, 337, 337)
                        .addComponent(btnObrisi)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbFilterMotoKlubovi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbMotoKlubovi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMjestoOdrzavanja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtOdgovorniClan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dpDatumPocetka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDodaj)
                            .addComponent(btnPromjeni))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnObrisi)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void cmbFilterMotoKluboviItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbFilterMotoKluboviItemStateChanged
        ucitaj();
    }//GEN-LAST:event_cmbFilterMotoKluboviItemStateChanged

    private void txtNazivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNazivActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNazivActionPerformed

    private void txtOdgovorniClanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOdgovorniClanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOdgovorniClanActionPerformed

    private void txtMjestoOdrzavanjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMjestoOdrzavanjaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMjestoOdrzavanjaActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
       obrada.setEntitet(new MotoDogadjaj());
        napuniModel();
        try {
            obrada.create();
            ucitaj();
        } catch (MotoVodicException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
        }
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnPromjeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniActionPerformed
      if (lstPodaci.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(getRootPane(),
                    "Prvo odaberite moto događaj");
            return;
        }
        napuniModel();
        try {
            obrada.update();
            ucitaj();
        } catch (MotoVodicException ex) {
            JOptionPane.showMessageDialog(getRootPane(),
                     ex.getPoruka());
        }
    }//GEN-LAST:event_btnPromjeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
       if (lstPodaci.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(getRootPane(),
                    "Prvo odaberite moto događaj");
            return;
        }
        if (JOptionPane.showConfirmDialog(
                getRootPane(),
                "Sigurno obrisati " + obrada.getEntitet().getNaziv() + "?",
                "Brisanje",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION) {
            return;
        }
        try {

            obrada.delete();
            ucitaj();
        } catch (MotoVodicException ex) {
            JOptionPane.showMessageDialog(getRootPane(),
                     ex.getPoruka());
        }
    }//GEN-LAST:event_btnObrisiActionPerformed
    

    private void ucitaj() {
        DefaultListModel<MotoDogadjaj> m = new DefaultListModel<>();
        m.addAll(obrada.read((MotoKlub) cmbFilterMotoKlubovi.getSelectedItem()));
        lstPodaci.setModel(m);
        lstPodaci.repaint();
    }
    
    
    private void napuniView() {
       var e = obrada.getEntitet();
       txtNaziv.setText(e.getNaziv());
       txtMjestoOdrzavanja.setText(e.getMjestoodrzavanja());
       txtOdgovorniClan.setText(e.getOdgovorniclan());
       if(e.getDatumpocetka()!=null){
             LocalDate ld = e.getDatumpocetka()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        dpDatumPocetka.setDate(ld);
        }else{
            dpDatumPocetka.setDate(null);
        }
       
       cmbMotoKlubovi.setSelectedItem(e.getMotoklub());
    }
    

    
   private void napuniModel() {
        var e = obrada.getEntitet();
        e.setNaziv(txtNaziv.getText());
        e.setMjestoodrzavanja(txtMjestoOdrzavanja.getText());
        e.setOdgovorniclan(txtOdgovorniClan.getText());
        e.setDatumpocetka(dpDatumPocetka.getDate()!=null
                            ? 
                            Date.from(dpDatumPocetka.getDate()
                            .atStartOfDay()
                            .atZone(ZoneId.systemDefault())
                            .toInstant())
                            : null);
    
        
    }

    
  
        
  
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromjeni;
    private javax.swing.JComboBox<MotoKlub> cmbFilterMotoKlubovi;
    private javax.swing.JComboBox<MotoKlub> cmbMotoKlubovi;
    private com.github.lgooddatepicker.components.DatePicker dpDatumPocetka;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<MotoDogadjaj> lstPodaci;
    private javax.swing.JTextField txtMjestoOdrzavanja;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtOdgovorniClan;
    // End of variables declaration//GEN-END:variables
}
