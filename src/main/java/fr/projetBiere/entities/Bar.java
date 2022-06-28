package fr.projetBiere.entities;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bar {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idBar;
	private String nom;
	private String localisation;
	private String adresse;
	private String deb_happ;
	private String fin_happ;
	private String siteWeb;
	

	public Bar(String nom, String localisation, String adresse, String deb_happ, String fin_happ,
			String siteWeb) {
		super();
		this.nom = nom;
		this.localisation = localisation;
		this.adresse = adresse;
		this.deb_happ = deb_happ;
		this.fin_happ = fin_happ;
		this.siteWeb = siteWeb;
	}

	public String getSiteWeb() {
		return siteWeb;
	}

	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}

	public Bar(String nom, String localisation, String adresse, String deb_happ, String fin_happ) {
		super();
		this.nom = nom;
		this.localisation = localisation;
		this.adresse = adresse;
		this.deb_happ = deb_happ;
		this.fin_happ = fin_happ;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Bar() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getIdBar() {
		return idBar;
	}
	public void setIdBar(Long idBar) {
		this.idBar = idBar;
	}
	public String getLocalisation() {
		return localisation;
	}
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getDeb_happ() {
		return deb_happ;
	}
	public void setDeb_happ(String deb_happ) {
		this.deb_happ = deb_happ;
	}
	public String getFin_happ() {
		return fin_happ;
	}
	public void setFin_happ(String fin_happ) {
		this.fin_happ = fin_happ;
	}
	

}
