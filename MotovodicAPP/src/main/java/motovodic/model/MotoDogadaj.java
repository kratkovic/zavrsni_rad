/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motovodic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class MotoDogadaj extends Entitet {

    
    private String naziv;
    private String mjestoodrzavanja;
    private String odgovorniclan;
    private Date datumpocetka;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "motoklub")
    private MotoKlub motoklub;

    @OneToMany(mappedBy = "motoDogadaj", fetch = FetchType.LAZY)
    private List<Smjestaj> smjestaji = new ArrayList<>();

    @OneToMany(mappedBy = "motoDogadaj", fetch = FetchType.LAZY)
    private List<Servis> servisi = new ArrayList<>();

    public MotoDogadaj() {
        super();
        smjestaji = new ArrayList<>();
        servisi = new ArrayList<>();
    }

    public MotoDogadaj(String naziv, String mjestoodrzavanja, String odgovorniclan, Date datumpocetka, MotoKlub motoklub, int sifra) {
        super(sifra);
        this.naziv = naziv;
        this.mjestoodrzavanja = mjestoodrzavanja;
        this.odgovorniclan = odgovorniclan;
        this.datumpocetka = datumpocetka;
        this.motoklub = motoklub;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getMjestoodrzavanja() {
        return mjestoodrzavanja;
    }

    public void setMjestoodrzavanja(String mjestoodrzavanja) {
        this.mjestoodrzavanja = mjestoodrzavanja;
    }

    public String getOdgovorniclan() {
        return odgovorniclan;
    }

    public void setOdgovorniclan(String odgovorniclan) {
        this.odgovorniclan = odgovorniclan;
    }

    public Date getDatumpocetka() {
        return datumpocetka;
    }

    public void setDatumpocetka(Date datumpocetka) {
        this.datumpocetka = datumpocetka;
    }

    public MotoKlub getMotoklub() {
        return motoklub;
    }

    public void setMotoklub(MotoKlub motoklub) {
        this.motoklub = motoklub;
    }

    public List<Smjestaj> getSmjestaji() {
        return smjestaji;
    }

    public void setSmjestaji(List<Smjestaj> smjestaji) {
        this.smjestaji = smjestaji;
    }

    public List<Servis> getServisi() {
        return servisi;
    }

    public void setServisi(List<Servis> servisi) {
        this.servisi = servisi;
    }
}
