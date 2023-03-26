/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motovodic.controller;

import java.util.List;
import motovodic.model.Servis;
import motovodic.util.MotoVodicException;


public class ObradaServis extends Obrada<Servis>{

    @Override
    public List<Servis> read() {
     return session.createQuery("from Servis order by naziv", Servis.class).list();
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
        kontrolaNazivDupliUBazi();
    }

    @Override
    protected void kontrolaBrisanje() throws MotoVodicException {
        
    }
     private void kontrolaNaziv()throws MotoVodicException{
        kontrolaNazivNull();
        kontrolaNazivNijeBroj();
        kontrolaNazivMinimalnaDuzina();
        kontrolaNazivMaksimalnaDuzina();
        kontrolaNazivDupliUBazi();
    }

    private void kontrolaNazivNull() throws MotoVodicException{
        if(entitet.getNaziv()==null){
            throw new MotoVodicException("Naziv mora biti postavljen");
        }
      
    }

    private void kontrolaNazivNijeBroj()throws MotoVodicException{
       boolean broj = false;
       try{
           Double.parseDouble(entitet.getNaziv());
           broj = true;
       }catch(Exception e){
           if(broj){
               throw new MotoVodicException("Naziv servisa ne smije biti broj");
           }
       }
    }

    private void kontrolaNazivMinimalnaDuzina() throws MotoVodicException{
        if (entitet.getNaziv().trim().length() < 3) {
            throw new MotoVodicException("Naziv servisa mora imati minimalno 3 znaka");
        }
    }

    private void kontrolaNazivMaksimalnaDuzina() throws MotoVodicException{
        if (entitet.getNaziv().trim().length() > 50) {
            throw new MotoVodicException("Naziv servisa može imati minimalno 50 znakova");
        }
       
    }

    private void kontrolaNazivDupliUBazi() throws MotoVodicException{
        List<Servis> servisi = null;
        try {
            servisi = session.createQuery("from Servis s "
                    + " where s.naziv=:naziv",
                    Servis.class)
                    .setParameter("naziv", entitet.getNaziv())
                    .list();
        } catch (Exception e) {
        }
        if (servisi != null && !servisi.isEmpty()) {
            throw new MotoVodicException("Servis s istim nazivom postoji u bazi");
        }
       
    }

   
    
}
