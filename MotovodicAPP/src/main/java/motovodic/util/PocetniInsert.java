/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motovodic.util;

import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.List;
import motovodic.model.MotoDogadjaj;
import motovodic.model.MotoKlub;
import motovodic.model.Servis;
import motovodic.model.Smjestaj;
import org.hibernate.Session;


public class PocetniInsert {
    
    private static final int BROJ_MOTOKLUBOVA = 30;
    private static final int BROJ_MOTODOGADJAJA = 80;
    private static final int BROJ_SMJESTAJA = 100;
    private static final int BROJ_SERVISA = 20;
    
    private Faker faker;
    private List<MotoKlub> motoklubovi;
    private List<MotoDogadjaj> motodogadaji;
    private List<Smjestaj> smjestaji;
    private List<Servis> servisi;
    private Session session;
    
    public PocetniInsert(){
        faker = new Faker();
        motoklubovi = new ArrayList<>();
        motodogadaji = new ArrayList<>();
        smjestaji = new ArrayList<>();
        servisi = new ArrayList<>();
        session = HibernateUtil.getSession();
        session.beginTransaction();
        kreirajMotoKlubove();
        session.getTransaction().commit();
    }
    
    private void kreirajMotoKlubove(){
        MotoKlub mk;
        for(int i = 0; i<BROJ_MOTOKLUBOVA; i++){
            mk = new MotoKlub();
            mk.setNaziv(faker.app().name());
            mk.setMjesto(faker.app().name());
            mk.setBrojclanova(faker.number().numberBetween(3, 150));
            mk.setRegistracija(faker.bool().bool());
            session.persist(mk);
            motoklubovi.add(mk)
        }
    }
}
