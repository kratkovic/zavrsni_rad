/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motovodic.controller;

import jakarta.persistence.NoResultException;
import java.util.List;
import motovodic.model.Operater;
import motovodic.util.MotoVodicException;
import org.mindrot.jbcrypt.BCrypt;

public class ObradaOperater extends Obrada<Operater> {

    @Override
    public List<Operater> read() {

        return session.createQuery("from Operater", Operater.class).list();
    }

    public void unosAdminOperatera() {
        Operater o = new Operater();
        o.setKorisnickoime("Admin");
        o.setLozinka(BCrypt.hashpw("Motovodic23",
                BCrypt.gensalt()).toCharArray());

        entitet = o;
        try {
            create();
        } catch (MotoVodicException ex) {

            
        }
    }
        public Operater Autoriziraj(String korisnickoime, char[] lozinka) {
        Operater o;
        try {
            o = session.createQuery("from Operater o where o.korisnickoime=:korisnickoime",
                    Operater.class)
                    .setParameter("korisnickoime", korisnickoime)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

        if (BCrypt.checkpw(new String(lozinka),
                new String(o.getLozinka()))) {
            return o;
        }

        return null;
    }

    @Override
    protected void kontrolaUnos() throws MotoVodicException {

    }

    @Override
    protected void kontrolaPromjena() throws MotoVodicException {

    }

    @Override
    protected void kontrolaBrisanje() throws MotoVodicException {

    }

}
