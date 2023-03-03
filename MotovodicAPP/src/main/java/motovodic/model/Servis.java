/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motovodic.model;

import jakarta.persistence.Entity;

@Entity
public class Servis extends Entitet{
    
    private String naziv;
    private String mjesto;
    private String radnovrijeme;

    public Servis(String naziv, String mjesto, String radnovrijeme, int sifra) {
        super(sifra);
        this.naziv = naziv;
        this.mjesto = mjesto;
        this.radnovrijeme = radnovrijeme;
    }
    
       

    public Servis(int sifra) {
        super(sifra);
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
    
    
    
    
    
}
