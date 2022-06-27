package fr.projetBiere.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categorie {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCat;
	private String nomCat;
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Categorie(Long idCat) {
		super();
		this.idCat = idCat;
	}

	public Categorie(String nomCat) {
		super();
		this.nomCat = nomCat;
	}
	public Long getIdCat() {
		return idCat;
	}
	public void setIdCat(Long idCat) {
		this.idCat = idCat;
	}
	public String getNomCat() {
		return nomCat;
	}
	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
	}
	
	
}
