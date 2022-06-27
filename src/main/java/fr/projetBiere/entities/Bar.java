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
	private String localisation;
	private String adresse;
	private LocalTime deb_happ;
	private LocalTime fin_happ;
	public Bar() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bar(String localisation, String adresse, LocalTime deb_happ, LocalTime fin_happ) {
		super();
		this.localisation = localisation;
		this.adresse = adresse;
		this.deb_happ = deb_happ;
		this.fin_happ = fin_happ;
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
	public LocalTime getDeb_happ() {
		return deb_happ;
	}
	public void setDeb_happ(LocalTime deb_happ) {
		this.deb_happ = deb_happ;
	}
	public LocalTime getFin_happ() {
		return fin_happ;
	}
	public void setFin_happ(LocalTime fin_happ) {
		this.fin_happ = fin_happ;
	}
	

}
