package fr.projetBiere.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.projetBiere.entities.User;

public interface UserRepository extends CrudRepository<User, Long>{

	User findByMailAndPassword(String mail, String password);
	
	//@Query("Update User u Set u.idPref = ?1 WHERE u.id = ?2")
	//User UpdateIdPrefUser(Long id_pref,Long id);
}
