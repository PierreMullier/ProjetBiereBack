package fr.projetBiere.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.projetBiere.entities.Preference;

public interface PreferenceRepository extends CrudRepository<Preference, Long> {
	
	@Query(value ="SELECT MAX(id_pref) FROM preference", nativeQuery = true)
	Preference findLastId();

}
