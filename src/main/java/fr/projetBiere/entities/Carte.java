package fr.projetBiere.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;


@Entity
@IdClass(CarteKey.class)
public class Carte {
	@Id
	@ManyToOne
	private Bar bar;
	@Id
	@ManyToOne
	private Biere biere;
	private double prix;
	public Carte(Bar bar, Biere biere, double prix) {
		super();
		this.bar = bar;
		this.biere = biere;
		this.prix = prix;
	}
	public Carte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bar getBar() {
		return bar;
	}
	public void setBar(Bar bar) {
		this.bar = bar;
	}
	public Biere getBiere() {
		return biere;
	}
	public void setBiere(Biere biere) {
		this.biere = biere;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}

}
