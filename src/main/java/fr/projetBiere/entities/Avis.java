package fr.projetBiere.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import  javax.persistence.ManyToOne;
@Entity
@IdClass(AvisKey.class)
public class Avis {
	@Id
	@ManyToOne
	private User user;
	@Id
	@ManyToOne
	private Bar bar;
	private String description;
	private Double note;
	private String date;


	public Avis() {
		super();
	}


	public Avis(User user, Bar bar, String description, Double note, String date) {
		super();
		this.user = user;
		this.bar = bar;
		this.description = description;
		this.note = note;
		this.date = date;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Bar getBar() {
		return bar;
	}


	public void setBar(Bar bar) {
		this.bar = bar;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Double getNote() {
		return note;
	}


	public void setNote(Double note) {
		this.note = note;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Avis [user=" + user + ", bar=" + bar + ", description=" + description + ", note=" + note + ", date="
				+ date + "]";
	}

}
