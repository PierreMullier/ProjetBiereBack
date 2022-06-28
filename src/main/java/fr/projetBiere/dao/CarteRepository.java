package fr.projetBiere.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.projetBiere.entities.Carte;

public interface CarteRepository extends CrudRepository<Carte, Long> {

	List<Carte> findByBarIdBar(Long id);

	List<Carte> findByBiereIdBiere(Long id);

}
