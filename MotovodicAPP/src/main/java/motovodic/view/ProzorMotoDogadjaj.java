/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package motovodic.view;

import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.TimePickerSettings;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import motovodic.controller.ObradaMotoDogadjaj;
import motovodic.controller.ObradaMotoKlub;
import motovodic.controller.ObradaSmjestaj;
import motovodic.model.MotoDogadjaj;
import motovodic.model.MotoKlub;
import motovodic.model.Smjestaj;
import motovodic.util.Aplikacija;
import motovodic.util.MotoVodicException;


public class ProzorMotoDogadjaj extends javax.swing.JFrame implements MotoVodicViewSucelje{
    
    private ObradaMotoDogadjaj obrada;
    private ObradaSmjestaj obradaSmjestaj;

    /**
     * Creates new form ProzorMotoDogadjaj
     */
    public ProzorMotoDogadjaj() {
        initComponents();
        obrada = new ObradaMotoDogadjaj();
        obradaSmjestaj = new ObradaSmjestaj();
        setTitle(Aplikacija.NAZIV_APP + ": "
                + Aplikacija.OPERATER.getImePrezime()
                + ": Moto događaji");
        definirajDatumPocetka();
        ucitajFilterMotoKlubovi();
        ucitajMotoKlubove();
        ucitaj();
        
    }
    
   
    
    private void definirajDatumPocetka(){
        DatePickerSettings dps = 
                new DatePickerSettings(new Locale("hr", "HR"));
        dps.setFormatForDatesCommonEra("dd. MM. YYYY.");
        dps.setTranslationClear("Očisti");
        dps.setTranslationToday("Danas");
        dtpDatumIVrijemePocetka.datePicker.setSettings(dps);
        
        TimePickerSettings tps = new TimePickerSettings(new Locale("hr", "HR"));
        tps.setFormatForDisplayTime("HH:mm");
       dtpDatumIVrijemePocetka.timePicker
                .getSettings()
         
               .use24HourClockFormat();
        
        ArrayList<LocalTime> lista = new ArrayList<>();
        
        for(int j=0;j<24;j++){
        for(int i=0;i<60;i+=30){
            lista.add(LocalTime.of(j, i));
        }
        }
        
        
        dtpDatumIVrijemePocetka.timePicker.getSettings()
                .generatePotentialMenuTimes(lista); 
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
        txtNaziv = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtOdgovorniClan = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMjestoOdrzavanja = new javax.swing.JTextField();
        btnDodaj = new javax.swing.JButton();
        btnPromjeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstSmjestajiNaMotoDogadjaju = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstSmjestajiUBazi = new javax.swing.JList<>();
        txtUvjet = new javax.swing.JTextField();
        btnTrazi = new javax.swing.JButton();
        btnDodajSmjestaj = new javax.swing.JButton();
        btnObrisiSmjestaj = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        dtpDatumIVrijemePocetka = new com.github.lgooddatepicker.components.DateTimePicker();

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

        lstSmjestajiNaMotoDogadjaju.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(lstSmjestajiNaMotoDogadjaju);

        jLabel2.setText("Smještaji na moto događaju");

        lstSmjestajiUBazi.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(lstSmjestajiUBazi);

        txtUvjet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUvjetActionPerformed(evt);
            }
        });
        txtUvjet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUvjetKeyPressed(evt);
            }
        });

        btnTrazi.setText("🔍");
        btnTrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraziActionPerformed(evt);
            }
        });

        btnDodajSmjestaj.setText("<<");
        btnDodajSmjestaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajSmjestajActionPerformed(evt);
            }
        });

        btnObrisiSmjestaj.setText(">>");
        btnObrisiSmjestaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiSmjestajActionPerformed(evt);
            }
        });

        jLabel3.setText("Smještaji u bazi");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(129, 129, 129)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnDodajSmjestaj)
                                    .addComponent(btnObrisiSmjestaj)))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(cmbFilterMotoKlubovi, 0, 205, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(txtOdgovorniClan, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMjestoOdrzavanja, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86)
                                .addComponent(btnPromjeni))
                            .addComponent(dtpDatumIVrijemePocetka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(337, 337, 337)
                        .addComponent(btnObrisi)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtUvjet, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(80, 80, 80))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cmbFilterMotoKlubovi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtMjestoOdrzavanja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtOdgovorniClan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(24, 24, 24)
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(dtpDatumIVrijemePocetka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(btnDodaj)
                                                    .addComponent(btnPromjeni))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnObrisi))
                                    .addComponent(jScrollPane2)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(btnDodajSmjestaj)
                                .addGap(40, 40, 40)
                                .addComponent(btnObrisiSmjestaj))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUvjet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTrazi))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    private void txtUvjetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUvjetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUvjetActionPerformed

    private void txtUvjetKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUvjetKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ucitajSmjestaje();
        }
    }//GEN-LAST:event_txtUvjetKeyPressed

    private void btnTraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraziActionPerformed
       ucitajSmjestaje();
    }//GEN-LAST:event_btnTraziActionPerformed

    private void btnDodajSmjestajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajSmjestajActionPerformed
     if(lstSmjestajiUBazi.getSelectedValuesList()==null
             || lstSmjestajiUBazi.getSelectedValuesList().isEmpty()){
         JOptionPane.showMessageDialog(getRootPane(), "Prvo pronađite smještaje");
         return;
     }
     if(lstSmjestajiNaMotoDogadjaju.getModel()==null || 
                  !(lstSmjestajiNaMotoDogadjaju.getModel() instanceof DefaultListModel<Smjestaj>)){
            lstSmjestajiNaMotoDogadjaju.setModel(new DefaultListModel<Smjestaj>());
        }
     
         DefaultListModel<Smjestaj> m = 
                (DefaultListModel<Smjestaj>) lstSmjestajiNaMotoDogadjaju.getModel();
        
        DefaultListModel<Smjestaj> smjestaji = 
                (DefaultListModel<Smjestaj>) lstSmjestajiNaMotoDogadjaju.getModel();
        boolean postoji;
        for(Smjestaj sub : lstSmjestajiUBazi.getSelectedValuesList()){
            postoji=false;
            for(int i=0;i<smjestaji.getSize();i++){
                if(sub.getSifra()==smjestaji.get(i).getSifra()){
                    postoji=true;
                    break;
                }
            }
            if(!postoji){
                 smjestaji.addElement(sub);
            }
        }
        lstSmjestajiNaMotoDogadjaju.repaint();
         
    }//GEN-LAST:event_btnDodajSmjestajActionPerformed

    private void btnObrisiSmjestajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiSmjestajActionPerformed
       if(lstSmjestajiNaMotoDogadjaju.getSelectedValuesList()==null
                || lstSmjestajiNaMotoDogadjaju.getSelectedValuesList().isEmpty()){
            JOptionPane.showMessageDialog(getRootPane(),
                    "Prvo odaberite smještaje na motodogađaju");
            return;
        }
        
        DefaultListModel<Smjestaj> m = 
                (DefaultListModel<Smjestaj>) lstSmjestajiNaMotoDogadjaju.getModel();
        
        for(Smjestaj s : lstSmjestajiNaMotoDogadjaju.getSelectedValuesList()){
            m.removeElement(s);
        }
        lstSmjestajiNaMotoDogadjaju.repaint();
    }//GEN-LAST:event_btnObrisiSmjestajActionPerformed
    
    
    private void ucitajSmjestaje(){
        DefaultListModel<Smjestaj> m = new DefaultListModel<>();
        m.addAll(obradaSmjestaj.read(txtUvjet.getText().trim()));
        lstSmjestajiUBazi.setModel(m);
        lstSmjestajiUBazi.repaint();
    }
    @Override
    public void ucitaj() {
        DefaultListModel<MotoDogadjaj> m = new DefaultListModel<>();
        m.addAll(obrada.read((MotoKlub) cmbFilterMotoKlubovi.getSelectedItem()));
        lstPodaci.setModel(m);
        lstPodaci.repaint();
    }
    
    @Override
    public void napuniView() {
       var s = obrada.getEntitet();
       txtNaziv.setText(s.getNaziv());
       txtMjestoOdrzavanja.setText(s.getMjestoodrzavanja());
       txtOdgovorniClan.setText(s.getOdgovorniclan());
       if(s.getDatumpocetka()!=null){
             LocalDateTime ld = s.getDatumpocetka()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        dtpDatumIVrijemePocetka.datePicker.setDate(ld.toLocalDate());
        dtpDatumIVrijemePocetka.timePicker.setTime(ld.toLocalTime());
        }
        else
        {
            dtpDatumIVrijemePocetka.datePicker.setDate(null);
            dtpDatumIVrijemePocetka.timePicker.setTime(null);
        }
       
       DefaultListModel<Smjestaj> m = new DefaultListModel<>();
       if(s.getSmjestaji()!=null){
           m.addAll(s.getSmjestaji());
       }
        
        lstSmjestajiNaMotoDogadjaju.setModel(m);
        lstSmjestajiNaMotoDogadjaju.repaint();
       
       
       
       btnObrisi.setVisible(false);
       if(s.getSmjestaji()==null || s.getSmjestaji().isEmpty()){
           btnObrisi.setVisible(true);
           
       }
       
       
    }
    
   @Override
   public void napuniModel() {
        var e = obrada.getEntitet();
        e.setNaziv(txtNaziv.getText());
        e.setMjestoodrzavanja(txtMjestoOdrzavanja.getText());
        e.setOdgovorniclan(txtOdgovorniClan.getText());
        LocalDate ld = dtpDatumIVrijemePocetka.datePicker.getDate();
 
        LocalTime lt = dtpDatumIVrijemePocetka.timePicker.getTime();
   // dpDatumPocetka.timePicker.setTime(lt);
         LocalDateTime fromDateAndTime = LocalDateTime.of(ld,
                                                           lt);
        
        Date datum = Date.from(fromDateAndTime.atZone(ZoneId.systemDefault()).toInstant());
        
        
        e.setDatumpocetka(datum);
        
        e.setMotoklub((MotoKlub) cmbFilterMotoKlubovi.getSelectedItem());
        
        
    
        List<Smjestaj> smjestaji = new ArrayList<>();
        try {
            DefaultListModel<Smjestaj> m = (DefaultListModel<Smjestaj>) lstSmjestajiNaMotoDogadjaju.getModel();
            for(int i=0;i<m.getSize();i++){
                smjestaji.add(m.getElementAt(i));
            }
        } catch (Exception ex) {
            
        }
        e.setSmjestaji(smjestaji);
        
        
    }

    
  
        
  
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnDodajSmjestaj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnObrisiSmjestaj;
    private javax.swing.JButton btnPromjeni;
    private javax.swing.JButton btnTrazi;
    private javax.swing.JComboBox<MotoKlub> cmbFilterMotoKlubovi;
    private com.github.lgooddatepicker.components.DateTimePicker dtpDatumIVrijemePocetka;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<MotoDogadjaj> lstPodaci;
    private javax.swing.JList<Smjestaj> lstSmjestajiNaMotoDogadjaju;
    private javax.swing.JList<Smjestaj> lstSmjestajiUBazi;
    private javax.swing.JTextField txtMjestoOdrzavanja;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtOdgovorniClan;
    private javax.swing.JTextField txtUvjet;
    // End of variables declaration//GEN-END:variables
}
