package fr.projetBiere.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.projetBiere.entities.Biere;

public interface BiereRepository extends CrudRepository<Biere, Long> {


	Optional<Biere> findByNom(String nom);

	List<Biere> findByDegre(double degre);

	List<Biere> findByStyleIdStyle(Long style_id_style);

}
