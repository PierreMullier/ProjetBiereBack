package fr.projetBiere.dao;

import org.springframework.data.repository.CrudRepository;

import fr.projetBiere.entities.Groupe;

public interface GroupeRepository extends CrudRepository<Groupe, Long> {

}
