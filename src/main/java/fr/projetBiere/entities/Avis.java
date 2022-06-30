package fr.projetBiere.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
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
    @ManyToOne
    private Bar barAvis;

    public Avis() {
        super();
    }

    public Avis(String description, String note, String date, User userAvis, Bar barAvis) {
        super();
        this.description = description;
        this.note = note;
        this.date = date;
        this.userAvis = userAvis;
        this.barAvis = barAvis;
    }

    public Avis(Long idAvis, String description, String note, String date, User userAvis, Bar barAvis) {
        super();
        this.idAvis = idAvis;
        this.description = description;
        this.note = note;
        this.date = date;
        this.userAvis = userAvis;
        this.barAvis = barAvis;
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

    public Bar getBarAvis() {
        return barAvis;
    }

    public void setBarAvis(Bar barAvis) {
        this.barAvis = barAvis;
    }

    @Override
    public String toString() {
        return "Avis [description=" + description + ", note=" + note + ", date=" + date + ", barAvis=" + barAvis + "]";
    }

    

}
=======
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import fr.projetBiere.entities.AvisKey;


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
>>>>>>> branch 'master' of https://github.com/PierreMullier/ProjetBiereBack
