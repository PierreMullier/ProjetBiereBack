package fr.projetBiere.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.projetBiere.entities.Bar;
import fr.projetBiere.entities.Biere;

public interface BiereRepository extends CrudRepository<Biere, Long> {


	Optional<Biere> findByNom(String nom);

	List<Biere> findByDegre(double degre);

	List<Biere> findByStyleIdStyle(Long style_id_style);
	
	//("select b from Bar b inner join Carte c on c.bar.idBar = b.idBar  inner join Biere bi on bi.idBiere = c.biere.idBiere where c.biere.nom LIKE ?1" )
	@Query("select bi from Biere bi inner join Carte c on c.biere.idBiere = bi.idBiere  inner join Bar b on b.idBar = c.bar.idBar where b.nom LIKE ?1" )
	List<Biere> findByBarNom(String nom);

}
