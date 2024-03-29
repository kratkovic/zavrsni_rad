/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package motovodic.util;

import com.github.javafaker.Faker;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
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
    private List<Servis> servisi;
    private List<Smjestaj> smjestaji;
    private Session session;

    public PocetniInsert() {
        faker = new Faker();
        motoklubovi = new ArrayList<>();
        motodogadaji = new ArrayList<>();
        smjestaji = new ArrayList<>();
        servisi = new ArrayList<>();
        session = HibernateUtil.getSession();
        session.beginTransaction();
        kreirajMotoKlubove();
        kreirajMotoDogadjaje();
        kreirajServise();
        kreirajSmjestaje();

        session.getTransaction().commit();
        HibernateUtil.CloseSession();
    }

    public static int brojIzmedju(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String radnoVrijeme() {
        return brojIzmedju(5, 9) + "-" + brojIzmedju(14, 17);
    }

    private void kreirajMotoKlubove() {
        MotoKlub mk;
        for (int i = 0; i < BROJ_MOTOKLUBOVA; i++) {
            mk = new MotoKlub();
            mk.setNaziv(faker.app().name());
            mk.setMjesto(faker.app().name());
            mk.setBrojclanova(faker.number().numberBetween(3, 150));
            mk.setRegistracija(faker.bool().bool());
            session.persist(mk);
            motoklubovi.add(mk);
        }
    }

    private void kreirajMotoDogadjaje() {
        MotoDogadjaj md;
        for (int i = 0; i < BROJ_MOTODOGADJAJA; i++) {
            md = new MotoDogadjaj();
            md.setMotoklub(motoklubovi.get(sb(0, motoklubovi.size() - 1)));
            md.setNaziv(faker.app().name());
            md.setDatumpocetka(faker.date().birthday(1, 12));
            md.setMjestoodrzavanja(faker.app().name());
            md.setOdgovorniclan(faker.name().firstName() + " " + faker.name().lastName());
            session.persist(md);
            motodogadaji.add(md);

        }
    }

    private void kreirajSmjestaje() {
        Smjestaj s;
        for (int i = 0; i < BROJ_SMJESTAJA; i++) {
            s = new Smjestaj();
            s.setNaziv(faker.app().name());
            s.setVrsta(faker.app().name());
            s.setMotoDogadjaj(motodogadaji.get(sb(0, motodogadaji.size() - 1)));
            s.setServis(servisi.get(sb(0, servisi.size() - 1)));
            s.setCijena(new BigDecimal(faker.number().numberBetween(5, 200)));
            session.persist(s);
            smjestaji.add(s);
        }
    }

    private void kreirajServise() {
        Servis sr;
        for (int i = 0; i < BROJ_SERVISA; i++) {
            sr = new Servis();
            sr.setNaziv(faker.app().name());
            sr.setMjesto(faker.address().fullAddress());
            sr.setRadnovrijeme(radnoVrijeme());
            session.persist(sr);
            servisi.add(sr);
        }
    }

    private int sb(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
