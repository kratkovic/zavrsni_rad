/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motovodic.controller;

import java.util.List;
import motovodic.model.Operater;
import motovodic.util.MotoVodicException;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Kiki
 */
public class ObradaOperater extends Obrada<Operater> {

    @Override
    public List<Operater> read() {
        return session.createQuery("from Operater", Operater.class).list();
    }

    public void UnosAdminOperatera() {
        Operater o = new Operater();
        o.setUsername("Admin");
        o.setLozinka(BCrypt.hashpw("Motovodic23", BCrypt.gensalt()).toCharArray());

        entitet = o;
        try {
            create();
        } catch (MotoVodicException ex) {
            System.out.println(ex.getPoruka());
        }

    }

    public Operater Autoriziraj(String username, char[] lozinka) {
        Operater o = null;
        try {
            o = session.createQuery("from Operater o where username=:username ", Operater.class)
                    .setParameter("username", username)
                    .getSingleResult();

        } catch (Exception e) {
            return null;
        }

        if (BCrypt.checkpw(new String(lozinka), new String(o.getLozinka()))) {
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
