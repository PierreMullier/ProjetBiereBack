package fr.projetBiere.entities;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AvisKey implements Serializable {
	Long bar;
	Long user;
}
