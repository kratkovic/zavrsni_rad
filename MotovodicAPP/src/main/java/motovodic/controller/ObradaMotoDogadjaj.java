/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motovodic.controller;

import java.util.List;
import motovodic.model.MotoDogadjaj;
import motovodic.model.MotoKlub;
import motovodic.util.MotoVodicException;

/**
 *
 * @author Kiki
 */
public class ObradaMotoDogadjaj extends Obrada<MotoDogadjaj> {

    @Override
    public List<MotoDogadjaj> read() {
        return session.createQuery("from MotoDogadjaj", MotoDogadjaj.class).list();
    }


    public List<MotoDogadjaj> read(MotoKlub mk) {
        return session.createQuery("from MotoDogadjaj " 
                + " where motoklub=:motoklub" , MotoDogadjaj.class)
                .setParameter("motoklub", mk)
                .list();
    }
    
    @Override
    protected void kontrolaUnos() throws MotoVodicException {
        kontrolaNaziv();
    }

    @Override
    protected void kontrolaPromjena() throws MotoVodicException {
        kontrolaNazivNull();
        kontrolaNazivNijeBroj();
        kontrolaNazivMinimalnaDuzina();
        kontrolaNazivMaksimalnaDuzina();
        
    }

    @Override
    protected void kontrolaBrisanje() throws MotoVodicException {

    }

    private void kontrolaNaziv() throws MotoVodicException{
        kontrolaNazivNull();
        kontrolaNazivNijeBroj();
        kontrolaNazivMinimalnaDuzina();
        kontrolaNazivMaksimalnaDuzina();
        kontrolaNazivDupliUBazi();
    }

    private void kontrolaNazivNull() throws MotoVodicException{
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
            throw new MotoVodicException("Naziv motodogađaja ne smije biti broj");
        }
    }

    private void kontrolaNazivMinimalnaDuzina() throws MotoVodicException{
           if (entitet.getNaziv().trim().length() < 3) {
            throw new MotoVodicException("Naziv motodogađaja mora imati minimalno 3 znaka");
        }
    }

    private void kontrolaNazivMaksimalnaDuzina() throws MotoVodicException{
if (entitet.getNaziv().trim().length() > 50) {
            throw new MotoVodicException("Naziv motodogađaja može imati minimalno 50 znakova");
        }
    }

    private void kontrolaNazivDupliUBazi() throws MotoVodicException{
 List<MotoDogadjaj> motodogadjaji = null;
        try {
            motodogadjaji = session.createQuery("from MotoDogadjaj md "
                    + " where md.naziv=:naziv",
                    MotoDogadjaj.class)
                    .setParameter("naziv", entitet.getNaziv())
                    .list();
        } catch (Exception e) {
        }
        if (motodogadjaji != null && !motodogadjaji.isEmpty()) {
            throw new MotoVodicException("Motodogađaj s istim nazivom postoji u bazi");
        }
    }

}
