/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motovodic.controller;

import java.util.List;
import motovodic.model.MotoKlub;
import motovodic.util.MotoVodicException;

public class ObradaMotoKlub extends Obrada<MotoKlub> {

    @Override
    public List<MotoKlub> read() {
        return session.createQuery("from MotoKlub", MotoKlub.class).list();
    }

    @Override
    protected void kontrolaUnos() throws MotoVodicException {
        kontrolaNaziv();
    }

    @Override
    protected void kontrolaPromjena() throws MotoVodicException {

    }

    @Override
    protected void kontrolaBrisanje() throws MotoVodicException {

    }

    private void kontrolaNaziv() throws MotoVodicException {
        kontrolaNazivNull();
        kontrolaNazivNijeBroj();
        kontrolaNazivMinimalnaDuzina();
        kontrolaNazivMaksimalnaDuzina();

    }

    private void kontrolaNazivNull() throws MotoVodicException {
        if (entitet.getNaziv() == null) {
            throw new MotoVodicException("Naziv mora biti postavljen");
        }

    }

    private void kontrolaNazivNijeBroj() throws MotoVodicException {
        boolean broj = false;
        try {
            Double.parseDouble(entitet.getNaziv());
            broj = true;
        } catch (Exception e) {
        }

        if (broj) {
            throw new MotoVodicException("Naziv motokluba ne smije biti broj");
        }

    }

    private void kontrolaNazivMinimalnaDuzina() throws MotoVodicException {
    if(entitet.getNaziv().trim().length()<3){
        throw new MotoVodicException("Naziv motokluba mora imati minimalno 3 znaka");
    }
    
    }

    private void kontrolaNazivMaksimalnaDuzina() throws MotoVodicException{
       if(entitet.getNaziv().trim().length()>50){
        throw new MotoVodicException("Naziv motokluba može imati minimalno 50 znakova");
    }

}
}