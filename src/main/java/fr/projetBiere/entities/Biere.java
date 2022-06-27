package fr.projetBiere.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Biere {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idBiere;
	private String nom;
	@ManyToOne
	private Categorie cat;
	@ManyToOne
	private Style style;
	
	private double degre;
	private String description;
	public Long getIdBiere() {
		return idBiere;
	}
	public void setIdBiere(Long idBiere) {
		this.idBiere = idBiere;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Categorie getCat() {
		return cat;
	}
	public void setCat(Categorie cat) {
		this.cat = cat;
	}
	public Style getStyle() {
		return style;
	}
	public void setStyle(Style style) {
		this.style = style;
	}
	public double getDegre() {
		return degre;
	}
	public void setDegre(double degre) {
		this.degre = degre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Biere() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Biere(String nom, Categorie cat, Style style, double degre, String description) {
		super();
		this.nom = nom;
		this.cat = cat;
		this.style = style;
		this.degre = degre;
		this.description = description;
	}
	
	
	
	
}
