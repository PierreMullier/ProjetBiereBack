package fr.projetBiere.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CarteKey implements Serializable{
	Long bar;
	Long biere;
}
