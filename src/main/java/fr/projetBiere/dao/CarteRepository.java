package fr.projetBiere.dao;

import org.springframework.data.repository.CrudRepository;

import fr.projetBiere.entities.Carte;

public interface CarteRepository extends CrudRepository<Carte, Long> {

}
