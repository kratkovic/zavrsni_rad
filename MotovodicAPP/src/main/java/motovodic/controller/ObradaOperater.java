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


public class ObradaOperater extends Obrada<Operater>{
    

    @Override
    public List<Operater> read() {
        return session.createQuery("from Operater",Operater.class).list();
    }
    
    
    public void unosAdminOperatera() {
        Operater o = new Operater();
        o.setIme("Kristijan");
        o.setPrezime("Ratkovic");
        o.setEmail("ratkovic.kristijan@gmail.com");
        o.setLozinka(BCrypt.hashpw("Yamaha", 
                BCrypt.gensalt()).toCharArray());
        
       // setEntitet(o);
        entitet=o;
        try {
            create();
        } catch (MotoVodicException ex) {
            System.out.println(ex.getPoruka());
        }
        
        
    }
    
    public Operater autoriziraj(String email, char[] lozinka){
        Operater o;
        try {
            o = session.createQuery(
                    "from Operater o where o.email=:email", 
                    Operater.class)
                    .setParameter("email",email)
                    .getSingleResult();
            
        } catch (NoResultException e) {
            return null;
        }
        
        if(BCrypt.checkpw(
                new String(lozinka), 
                new String(o.getLozinka())
                            )
                ){
            return o;
        }
        
        return null;
    }

   
    
}
