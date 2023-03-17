/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motovodic.controller;

import jakarta.persistence.NoResultException;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;
import motovodic.model.Operater;
import motovodic.util.MotoVodicException;


public class ObradaOperater extends Obrada<Operater> {

    @Override
    public List<Operater> read() {

        return session.createQuery("from Operater", Operater.class).list();
    }

    public void unosAdminOperatera() {

        Operater o = new Operater();
        o.setIme("Kristijan");
        o.setPrezime("Ratković");
        o.setEmail("ratkovic.kristijan@gmail.com");
        o.setLozinka(BCrypt.hashpw("Motovodic23",
                BCrypt.gensalt()).toCharArray());

        entitet = o;
        try {
            create();
        } catch (MotoVodicException ex) {

        }
    }
         public Operater Autoriziraj(String email, char[] lozinka) {
        Operater o;
        try {
            o = session.createQuery("from Operater o where o.email=:email",
                    Operater.class)
                    .setParameter("email", email)
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
