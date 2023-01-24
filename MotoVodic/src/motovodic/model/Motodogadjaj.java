package motovodic.model;

import java.util.Date;

public class Motodogadjaj extends Entitet {
	
	private String naziv;
	private String mjestoOdrzavanja;
	private Date datumPocetka;
	private String odgovorniClan;
	
	
	
	public Motodogadjaj() {
		super();
	}
	public Motodogadjaj(int sifra, String naziv, String mjestoOdrzavanja, Date datumPocetka, String odgovorniClan) {
		super(sifra);
		this.naziv = naziv;
		this.mjestoOdrzavanja = mjestoOdrzavanja;
		this.datumPocetka = datumPocetka;
		this.odgovorniClan = odgovorniClan;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getMjestoOdrzavanja() {
		return mjestoOdrzavanja;
	}
	public void setMjestoOdrzavanja(String mjestoOdrzavanja) {
		this.mjestoOdrzavanja = mjestoOdrzavanja;
	}
	public Date getDatumPocetka() {
		return datumPocetka;
	}
	public void setDatumPocetka(Date datumPocetka) {
		this.datumPocetka = datumPocetka;
	}
	public String getOdgovorniClan() {
		return odgovorniClan;
	}
	public void setOdgovorniClan(String odgovorniClan) {
		this.odgovorniClan = odgovorniClan;
	}
	
	

}
