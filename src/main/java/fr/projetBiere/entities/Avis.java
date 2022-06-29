package fr.projetBiere.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Avis {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long idAvis;
	private String description;
	private String note;
	private String date;
	
	@ManyToOne
	private User userAvis;

	public Avis() {
		super();
	}

	public Avis(Long idAvis, String description, String note, String date, User userAvis) {
		super();
		this.idAvis = idAvis;
		this.description = description;
		this.note = note;
		this.date = date;
		this.userAvis = userAvis;
	}

	public Avis(String description, String note, String date, User userAvis) {
		super();
		this.description = description;
		this.note = note;
		this.date = date;
		this.userAvis = userAvis;
	}

	public Long getIdAvis() {
		return idAvis;
	}

	public void setIdAvis(Long idAvis) {
		this.idAvis = idAvis;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public User getUserAvis() {
		return userAvis;
	}

	public void setUserAvis(User userAvis) {
		this.userAvis = userAvis;
	}

	@Override
	public String toString() {
		return "Avis [idAvis=" + idAvis + ", description=" + description + ", note=" + note + ", date=" + date
				+ ", userAvis=" + userAvis + "]";
	}
	
	

}
