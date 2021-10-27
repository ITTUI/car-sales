package ch.ivantujkic.autoverkauf.model;

import java.util.*;

public class Auto {
	
	private int id;
	private String automarke;
	private String automodell;
	private int jahrgang;
	private boolean occassion;
	private int distanz;
	private int anzahlSitzplaetze;
	private String farbe;
    private int preis;
    private int rabatt;
	
	
	private List<Auto> autos = new ArrayList<Auto>();
	
	public Auto() {
	}
	
	/**
	 * Konstruktor ohne ID and "nullable"
	 */
	public Auto(String automarke, String automodell, int jahrgang, boolean occassion,
			int distanz, int anzahlSitzplaetze, String farbe, int preis, int rabatt) {
		this.automarke = automarke;
		this.automodell = automodell;
		this.jahrgang = jahrgang;
		this.occassion = occassion;
		this.distanz = distanz;
		this.anzahlSitzplaetze = anzahlSitzplaetze;
		this.farbe = farbe;
		this.preis = preis;
		this.rabatt = rabatt;
	}

	

	public List<Auto> getAutos() {
		return autos;
	}
	public void setAutos(List<Auto> autos) {
		this.autos = autos;
	}

	public void addAuto(Auto auto) {
		autos.add(auto);
	}

	public void removeAuto(Auto auto) {
		autos.remove(auto);
	}

	public int getId() {
		return id;
	}

	public void setId(int autoid) {
		this.id = autoid;
	}

	public String getAutomarke() {
		return automarke;
	}

	public void setAutomarke(String automarke) {
		this.automarke = automarke;
	}

	public String getAutomodell() {
		return automodell;
	}

	public void setAutomodell(String automodell) {
		this.automodell = automodell;
	}

	public int getJahrgang() {
		return jahrgang;
	}

	public void setJahrgang(int jahrgang) {
		this.jahrgang = jahrgang;
	}

	public boolean isOccassion() {
		return occassion;
	}

	public void setOccassion(boolean occassion) {
		this.occassion = occassion;
	}

	public int getDistanz() {
		return distanz;
	}

	public void setDistanz(int distanz) {
		this.distanz = distanz;
	}

	public int getAnzahlSitzplaetze() {
		return anzahlSitzplaetze;
	}

	public void setAnzahlSitzplaetze(int anzahlSitzplaetze) {
		this.anzahlSitzplaetze = anzahlSitzplaetze;
	}

	public String getFarbe() {
		return farbe;
	}

	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}

	public int getPreis() {
		return preis;
	}

	public void setPreis(int preis) {
		this.preis = preis;
	}

	public int getRabatt() {
		return rabatt;
	}

	public void setRabatt(int rabatt) {
		this.rabatt = rabatt;
	}

	
	public String toString() {
		String a = "Auto_ID: "  + this.getId() + "\n";
		a +=       "--------------\n";
		
		a += "Automarke: " + this.getAutomarke() + "\n";
		a += "Automodell: " + this.getAutomodell() + "\n";
		a += "Jahrgang: " + this.getJahrgang() + "\n";

		if (this.isOccassion() != true) {
			a += "Occassion";
		} else {
			a += "Neuwagen\n";
		}
		
		return a;
	}

   
}
