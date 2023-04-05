/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motovodic.controller;

import java.math.BigDecimal;
import java.util.List;
import motovodic.model.Smjestaj;
import motovodic.model.Servis;
import motovodic.util.MotoVodicException;


public class ObradaSmjestaj extends Obrada<Smjestaj>{

    @Override
    public List<Smjestaj> read() {
        return session.createQuery("from Smjestaj order by naziv", Smjestaj.class).list();
    }
    
    public List<Smjestaj> read(String uvjet) {
        uvjet=uvjet.trim();
        uvjet = "%" + uvjet + "%";
       return session.createQuery("from Smjestaj "
               + " where concat(naziv,' ',vrsta,' ', cijena) "
               + " like :uvjet "
               + " order by naziv, vrsta ", 
               Smjestaj.class)
               .setParameter("uvjet", uvjet)
               .setMaxResults(12)
               .list();
    }
    public List<Smjestaj> read(String uvjet, 
            boolean traziOdPocetkaNaziva) {
        uvjet=uvjet.trim();
        if(traziOdPocetkaNaziva){
            uvjet = uvjet + "%";
        }else{
            uvjet = "%" + uvjet + "%";
        }
        
       return session.createQuery("from Smjestaj "
               + " where concat(naziv,' ',vrsta,' ',cijena) "
               + " like :uvjet "
               + " order by naziv, vrsta ", 
               Smjestaj.class)
               .setParameter("uvjet", uvjet)
               .setMaxResults(12)
               .list();
    }

    @Override
    protected void kontrolaUnos() throws MotoVodicException {
        kontrolaNaziv();
        kontrolaCijena();
    }

    @Override
    protected void kontrolaPromjena() throws MotoVodicException {
        kontrolaNazivNull();
        kontrolaNazivNijeBroj();
        kontrolaNazivMinimalnaDuzina();
        kontrolaNazivMaksimalnaDuzina();
        kontrolaCijena();
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

    private void kontrolaNazivNijeBroj()throws MotoVodicException{
        boolean broj = false;
        try {
            Double.parseDouble(entitet.getNaziv());
            broj = true;
        } catch (Exception e) {
        }

        if (broj) {
            throw new MotoVodicException("Naziv smještaja ne smije biti broj");
    }
}

    private void kontrolaNazivMinimalnaDuzina() throws MotoVodicException{
        if (entitet.getNaziv().trim().length() < 3) {
            throw new MotoVodicException("Naziv smještaja mora imati minimalno 3 znaka");
        }
    }

    private void kontrolaNazivMaksimalnaDuzina() throws MotoVodicException{
       if (entitet.getNaziv().trim().length() > 50) {
            throw new MotoVodicException("Naziv smještaja može imati minimalno 50 znakova");
        }
    }

    private void kontrolaNazivDupliUBazi() throws MotoVodicException{
        List<Smjestaj> smjestaji = null;
         try {
            smjestaji = session.createQuery("from Smjestaj sm "
                    + " where sm.naziv=:naziv",
                    Smjestaj.class)
                    .setParameter("naziv", entitet.getNaziv())
                    .list();
        } catch (Exception e) {
        }
        if (smjestaji != null && !smjestaji.isEmpty()) {
            throw new MotoVodicException("Smještaj s istim nazivom postoji u bazi");
        }
    }

    private void kontrolaCijena() throws MotoVodicException{
         if(entitet.getCijena()==null ||
                entitet.getCijena().compareTo(BigDecimal.ZERO)<=0 ||
                entitet.getCijena().compareTo(new BigDecimal(10000))==1){
            throw new MotoVodicException("Cijena mora biti postavljena, "
                    + "veća od 0 i manja od 10000");
        }
        
    }
      
    }
