package fr.projetBiere.dao;

import org.springframework.data.repository.CrudRepository;

import fr.projetBiere.entities.Admin;

public interface AdminRepository extends CrudRepository<Admin, Long>{

    Admin findByMailAndPassword(String mail, String password);

    

}