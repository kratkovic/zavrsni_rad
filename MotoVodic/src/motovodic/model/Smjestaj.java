package motovodic.model;

public class Smjestaj extends Entitet{
	
	private String naziv;
	private String vrsta;
	private double cijena;
	private Motodogadjaj motodogadjaj;
	
	public Smjestaj() {
		super();
	}
	public Smjestaj(int sifra, String naziv, String vrsta, double cijena, Motodogadjaj motodogadjaj) {
		super(sifra);
		this.naziv = naziv;
		this.vrsta = vrsta;
		this.cijena = cijena;
		this.motodogadjaj = motodogadjaj;
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
	public Motodogadjaj getMotodogadjaj() {
		return motodogadjaj;
	}
	public void setMotodogadjaj(Motodogadjaj motodogadjaj) {
		this.motodogadjaj = motodogadjaj;
	}
	
	
	
	
	
	

}
