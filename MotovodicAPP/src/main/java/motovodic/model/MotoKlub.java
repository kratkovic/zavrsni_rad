/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motovodic.model;

import jakarta.persistence.Entity;


@Entity
public class MotoKlub extends Entitet{

  
    private String naziv;
    private String mjesto;
    private Integer brojclanova;
    private boolean registracija;
    
    
    
    public MotoKlub(){
        super();
    }

    public MotoKlub(String naziv, String mjesto, Integer brojclanova, boolean registracija) {
        this.naziv = naziv;
        this.mjesto = mjesto;
        this.brojclanova = brojclanova;
        this.registracija = registracija;
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

    public Integer getBrojclanova() {
        return brojclanova;
    }

    public void setBrojclanova(Integer brojclanova) {
        this.brojclanova = brojclanova;
    }

    public boolean isRegistracija() {
        return registracija;
    }

    public void setRegistracija(boolean registracija) {
        this.registracija = registracija;
    }
    
    @Override
	public String toString() {
		
		return naziv + " " + mjesto;

}
}