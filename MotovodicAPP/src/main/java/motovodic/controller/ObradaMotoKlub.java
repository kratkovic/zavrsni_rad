/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motovodic.controller;

import java.math.BigDecimal;
import java.util.List;
import motovodic.model.MotoKlub;
import motovodic.util.MotoVodicException;

public class ObradaMotoKlub extends Obrada<MotoKlub> {

    @Override
    public List<MotoKlub> read() {
        return session.createQuery("from MotoKlub order by naziv", MotoKlub.class).list();
    }

    @Override
    protected void kontrolaUnos() throws MotoVodicException {
        kontrolaNaziv();
        kontrolaBrojClanova();
    }

    @Override
    protected void kontrolaPromjena() throws MotoVodicException {
        kontrolaNazivNull();
        kontrolaNazivNijeBroj();
        kontrolaNazivMinimalnaDuzina();
        kontrolaNazivMaksimalnaDuzina();
        kontrolaNazivDupliUBazi();
        kontrolaBrojClanova();
    }

    @Override
    protected void kontrolaBrisanje() throws MotoVodicException {

    }

    private void kontrolaNaziv() throws MotoVodicException {
        kontrolaNazivNull();
        kontrolaNazivNijeBroj();
        kontrolaNazivMinimalnaDuzina();
        kontrolaNazivMaksimalnaDuzina();
        kontrolaNazivDupliUBazi();

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
        if (entitet.getNaziv().trim().length() < 3) {
            throw new MotoVodicException("Naziv motokluba mora imati minimalno 3 znaka");
        }

    }

    private void kontrolaNazivMaksimalnaDuzina() throws MotoVodicException {
        if (entitet.getNaziv().trim().length() > 50) {
            throw new MotoVodicException("Naziv motokluba može imati minimalno 50 znakova");
        }

    }

    private void kontrolaNazivDupliUBazi() throws MotoVodicException {
        List<MotoKlub> motoklubovi = null;
        try {
            motoklubovi = session.createQuery("from MotoKlub mk "
                    + " where mk.naziv=:naziv",
                    MotoKlub.class)
                    .setParameter("naziv", entitet.getNaziv())
                    .list();
        } catch (Exception e) {
        }
        if (motoklubovi != null && !motoklubovi.isEmpty()) {
            throw new MotoVodicException("Motoklub s istim nazivom postoji u bazi");
        }
    }

    private void kontrolaBrojClanova() throws MotoVodicException {
        if (entitet.getBrojclanova() == null
                || entitet.getBrojclanova() <= 0
                || entitet.getBrojclanova() > 200) {
            throw new MotoVodicException("Broj članova mora biti postavljen, "
                    + "veći od 0 i manji od 200");
        }
    }
}
