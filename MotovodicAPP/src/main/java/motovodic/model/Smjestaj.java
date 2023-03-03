/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motovodic.model;

import jakarta.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Smjestaj extends Entitet{
    
    private String naziv;
    private String vrsta;
    private BigDecimal cijena;
    private MotoDogadaj motoDogadaj;
    private Servis servis;

    public Smjestaj(String naziv, String vrsta, BigDecimal cijena, MotoDogadaj motoDogadaj, Servis servis, int sifra) {
        super(sifra);
        this.naziv = naziv;
        this.vrsta = vrsta;
        this.cijena = cijena;
        this.motoDogadaj = motoDogadaj;
        this.servis = servis;
    }
    
    
    

    public Smjestaj(int sifra) {
        super(sifra);
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

    public MotoDogadaj getMotoDogadaj() {
        return motoDogadaj;
    }

    public void setMotoDogadaj(MotoDogadaj motoDogadaj) {
        this.motoDogadaj = motoDogadaj;
    }

    public Servis getServis() {
        return servis;
    }

    public void setServis(Servis servis) {
        this.servis = servis;
    }
    
    
    
}
