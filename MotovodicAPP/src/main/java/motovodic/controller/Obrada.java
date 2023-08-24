/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motovodic.controller;

import java.util.List;
import motovodic.model.Entitet;
import motovodic.util.HibernateUtil;
import motovodic.util.MotoVodicException;
import org.hibernate.Session;

public abstract class Obrada<T extends Entitet> {

    protected T entitet;
    protected Session session;

    public abstract List<T> read();

    protected abstract void kontrolaUnos () throws MotoVodicException;

    protected abstract void kontrolaPromjena() throws MotoVodicException;

    protected abstract void kontrolaBrisanje() throws MotoVodicException;

    public Obrada() {
        this.session = HibernateUtil.getSession();
    }

    public void create() throws MotoVodicException {
        if(entitet==null){
            throw new MotoVodicException("Entitet je null");
        }
        kontrolaUnos();
        persist();
    }

    public void update() throws MotoVodicException {
        kontrolaPromjena();
        persist();
    }

    public void delete() throws MotoVodicException {
        kontrolaBrisanje();
        session.beginTransaction();
        session.remove(entitet);
        session.getTransaction().commit();
    }

    private void persist() {
        session.beginTransaction();
        session.persist(entitet);
        session.getTransaction().commit();
    }

    public T getEntitet() {
        return entitet;
    }

    public void setEntitet(T entitet) {
        this.entitet = entitet;
    }

}
