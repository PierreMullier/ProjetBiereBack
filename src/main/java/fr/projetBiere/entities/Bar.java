package fr.projetBiere.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Bar {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idBar;
	private String nom;
	private String localisation;
	private String adresse;
	private String debHapp;
	private String finHapp;
	private String siteWeb;
	
	public Bar() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bar(String nom, String localisation, String adresse, String debHapp, String finHapp, String siteWeb) {
		super();
		this.nom = nom;
		this.localisation = localisation;
		this.adresse = adresse;
		this.debHapp = debHapp;
		this.finHapp = finHapp;
		this.siteWeb = siteWeb;
	}
	public Bar(Long idBar) {
		super();
		this.idBar = idBar;
	}
	public String getDebHapp() {
		return debHapp;
	}
	public void setDebHapp(String debHapp) {
		this.debHapp = debHapp;
	}
	public String getFinHapp() {
		return finHapp;
	}
	public void setFinHapp(String finHapp) {
		this.finHapp = finHapp;
	}
	public Long getIdBar() {
		return idBar;
	}
	public void setIdBar(Long idBar) {
		this.idBar = idBar;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
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
	
	public String getSiteWeb() {
		return siteWeb;
	}
	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}
	
	

}
