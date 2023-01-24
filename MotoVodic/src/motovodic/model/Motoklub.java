package motovodic.model;

public class Motoklub extends Entitet{
	
	private String naziv;
	private String mjesto;
	private int brojClanova;
	private boolean registracija;
	
	
	
	public Motoklub() {
		super();
	}
	public Motoklub(int sifra, String naziv, String mjesto, int brojClanova, boolean registracija) {
		super(sifra);
		this.naziv = naziv;
		this.mjesto = mjesto;
		this.brojClanova = brojClanova;
		this.registracija = registracija;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getMjesto() {
		return mjesto;
	}
	public void setMjesto(String mjesto) {
		this.mjesto = mjesto;
	}
	public int getBrojClanova() {
		return brojClanova;
	}
	public void setBrojClanova(int brojClanova) {
		this.brojClanova = brojClanova;
	}
	public boolean isRegistracija() {
		return registracija;
	}
	public void setRegistracija(boolean registracija) {
		this.registracija = registracija;
	}
	
	

}
