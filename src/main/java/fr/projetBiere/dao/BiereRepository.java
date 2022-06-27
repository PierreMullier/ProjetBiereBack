package fr.projetBiere.dao;

import org.springframework.data.repository.CrudRepository;

import fr.projetBiere.entities.Biere;

public interface BiereRepository extends CrudRepository<Biere, Long> {

}
