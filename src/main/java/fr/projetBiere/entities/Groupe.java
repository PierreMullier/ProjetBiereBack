package fr.projetBiere.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Groupe {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idGroupe;
	private String nomGroupe;
	@OneToOne
	private User owner;
	private String[] membreGroup;
	public Groupe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Groupe(User owner, String[] membreGroup) {
		super();
		this.owner = owner;
		this.membreGroup = membreGroup;
	}
	
	public Groupe(String nomGroupe, User owner) {
		super();
		this.nomGroupe = nomGroupe;
		this.owner = owner;
	}
	public Groupe(User owner) {
		super();
		this.owner = owner;
	}
	public Long getIdGroupe() {
		return idGroupe;
	}
	public void setIdGroupe(Long idGroupe) {
		this.idGroupe = idGroupe;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public String[] getMembreGroup() {
		return membreGroup;
	}
	public void setMembreGroup(String[] membreGroup) {
		this.membreGroup = membreGroup;
	}
	public String getNomGroupe() {
		return nomGroupe;
	}
	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}
	
	
}
