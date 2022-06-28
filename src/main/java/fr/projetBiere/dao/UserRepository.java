package fr.projetBiere.dao;

import org.springframework.data.repository.CrudRepository;

import fr.projetBiere.entities.User;

public interface UserRepository extends CrudRepository<User, Long>{

	User findByMailAndPassword(String mail, String password);

}
