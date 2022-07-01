package fr.projetBiere.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.projetBiere.entities.Groupe;

public interface GroupeRepository extends CrudRepository<Groupe, Long> {
	
	@Query("SELECT g FROM Groupe g WHERE id= ?1")
	Groupe findByIdModif(long id_groupe);

}
