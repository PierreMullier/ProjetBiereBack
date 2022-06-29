package fr.projetBiere.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Preference {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPref;
	
	private String nomStyle;
	private double prix;
	private double tauxAlcool;
	private String nomBiere;
	
	
	public Preference() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Preference(String nomStyle, double prix, double tauxAlcool, String nomBiere) {
		super();
		this.nomStyle = nomStyle;
		this.prix = prix;
		this.tauxAlcool = tauxAlcool;
		this.nomBiere = nomBiere;
	}


	public Long getIdPref() {
		return idPref;
	}


	public void setIdPref(Long idPref) {
		this.idPref = idPref;
	}


	public String getNomStype() {
		return nomStyle;
	}


	public void setNomStype(String nomStype) {
		this.nomStyle = nomStype;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public double getTauxAlcool() {
		return tauxAlcool;
	}


	public void setTauxAlcool(double tauxAlcool) {
		this.tauxAlcool = tauxAlcool;
	}


	public String getNomBiere() {
		return nomBiere;
	}
	
	public void setNomBiere(String nomBiere) {
		this.nomBiere = nomBiere;
	}
}
