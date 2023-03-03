/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motovodic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Smjestaj extends Entitet{
    

    private String naziv;
    private String vrsta;
    private BigDecimal cijena;
    private MotoDogadaj motoDogadaj;
    private Servis servis;
    
    @OneToMany
    private List<MotoDogadaj> motoDogadaji;
    
    
    public Smjestaj(){
        super();
        motoDogadaji = new ArrayList<>();
    }

    public Smjestaj(String naziv, String vrsta, BigDecimal cijena, MotoDogadaj motoDogadaj, Servis servis, List<MotoDogadaj> motoDogadaji, int sifra) {
        super(sifra);
        this.naziv = naziv;
        this.vrsta = vrsta;
        this.cijena = cijena;
        this.motoDogadaj = motoDogadaj;
        this.servis = servis;
        this.motoDogadaji = motoDogadaji;
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

    public List<MotoDogadaj> getMotoDogadaji() {
        return motoDogadaji;
    }

    public void setMotoDogadaji(List<MotoDogadaj> motoDogadaji) {
        this.motoDogadaji = motoDogadaji;
    }
    
    
}
