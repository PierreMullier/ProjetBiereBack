package fr.projetBiere.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.projetBiere.entities.User;

public interface UserRepository extends CrudRepository<User, Long>{

	User findByMailAndPassword(String mail, String password);
	
	@Query("SELECT u FROM User u WHERE id= ?1")
	User getUserByIdModif(Long id_user);

	User findByMail(String mail);

}
