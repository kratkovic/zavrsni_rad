/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motovodic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Servis extends Entitet {

    private String naziv;
    private String mjesto;
    private String radnovrijeme;

    @OneToMany(mappedBy = "servis")
    private List<Smjestaj> smjestaji;

    public Servis() {
        super();
        smjestaji = new ArrayList<>(); // inicijalizacija prazne liste
    }

    public Servis(String naziv, String mjesto, String radnovrijeme, List<Smjestaj> smjestaji, int sifra) {
        super(sifra);
        this.naziv = naziv;
        this.mjesto = mjesto;
        this.radnovrijeme = radnovrijeme;
        this.smjestaji = smjestaji;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getMjesto() {
        return mjesto;
    }

    public void setMjesto(String mjesto) {
        this.mjesto = mjesto;
    }

    public String getRadnovrijeme() {
        return radnovrijeme;
    }

    public void setRadnovrijeme(String radnovrijeme) {
        this.radnovrijeme = radnovrijeme;
    }
    
    public List<Smjestaj> getSmjestaji() {
        return smjestaji;
    }

    public void setSmjestaji(List<Smjestaj> smjestaji) {
        this.smjestaji = smjestaji;
    }
    
    @Override
    public String toString() {
        return naziv + " " + mjesto;
    }
}

