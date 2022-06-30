package fr.projetBiere.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.projetBiere.entities.Bar;
import fr.projetBiere.entities.Preference;

public interface PreferenceRepository extends CrudRepository<Preference, Long> {
	

	@Query("select MAX(pref) from Preference pref" )
	  Preference findIdByMaxId(); 
	
	//@Query("UPDATE p from Preference p inner join User u on u.pref.idPref = p.idPref  where u.pref.idPref = ?1" )
	//  Preference editPrefByUserId(Long id_user);
}
