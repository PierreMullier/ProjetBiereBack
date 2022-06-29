package fr.projetBiere.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.projetBiere.entities.Bar;

public interface BarRepository extends CrudRepository<Bar, Long> {

	List<Bar> findByAdresseLike(String codePostal);

	List<Bar> findByNomLike(String string);

	List<Bar> findByFinHapp(String string);

	List<Bar> findByDebHappLessThanAndFinHappGreaterThan(String heure, String heure2);

	@Query("select b from Bar b inner join Carte c on c.bar.idBar = b.idBar where c.prix <= ?1")
	List<Bar> findByCartesPrix(double prixMax);

}
