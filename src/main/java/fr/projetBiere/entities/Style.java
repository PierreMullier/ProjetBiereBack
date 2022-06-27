package fr.projetBiere.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Style {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idStyle;
	@ManyToOne
	private Categorie cat;
	private String nom;
	public Style(Categorie cat, String nom) {
		super();
		this.cat = cat;
		this.nom = nom;
	}
	public Style() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Style(Long idStyle) {
		super();
		this.idStyle = idStyle;
	}
	public Long getIdStyle() {
		return idStyle;
	}
	public void setIdStyle(Long idStyle) {
		this.idStyle = idStyle;
	}
	public Categorie getCat() {
		return cat;
	}
	public void setCat(Categorie cat) {
		this.cat = cat;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
