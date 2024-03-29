/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motovodic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
public class Smjestaj extends Entitet{
    
    private String naziv;
    private String vrsta;
    private BigDecimal cijena;
    @ManyToOne
    @JoinColumn(name = "motodogadjaj")
    private MotoDogadjaj motoDogadjaj;
    
     @ManyToOne
    @JoinColumn(name = "servis")
    private Servis servis;

    public Smjestaj() {
        super();
    }

    public Smjestaj(String naziv, String vrsta, BigDecimal cijena, MotoDogadjaj motoDogadjaj, Servis servis, int sifra) {
        super(sifra);
        this.naziv = naziv;
        this.vrsta = vrsta;
        this.cijena = cijena;
        this.motoDogadjaj = motoDogadjaj;
        this.servis = servis;
    }

    public Servis getServis() {
        return servis;
    }

    public void setServis(Servis servis) {
        this.servis = servis;
    }

  
    
   
    
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    public BigDecimal getCijena() {
        return cijena;
    }

    public void setCijena(BigDecimal cijena) {
        this.cijena = cijena;
    }

    public MotoDogadjaj getMotoDogadjaj() {
        return motoDogadjaj;
    }

    public void setMotoDogadjaj(MotoDogadjaj motoDogadjaj) {
        this.motoDogadjaj = motoDogadjaj;
    }
    
    @Override
    public String toString() {
        return naziv + " " + cijena;
    }
    
}
