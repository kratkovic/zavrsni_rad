package motovodic.model;

public class Smjestaj extends Entitet{
	
	private String naziv;
	private String vrsta;
	private double cijena;
	
	
	
	public Smjestaj() {
		super();
	}
	public Smjestaj(int sifra, String naziv, String vrsta, double cijena) {
		super(sifra);
		this.naziv = naziv;
		this.vrsta = vrsta;
		this.cijena = cijena;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getVrsta() {
		return vrsta;
	}
	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
	}
	public double getCijena() {
		return cijena;
	}
	public void setCijena(double cijena) {
		this.cijena = cijena;
	}
	

}
