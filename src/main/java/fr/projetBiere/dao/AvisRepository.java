package fr.projetBiere.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.projetBiere.entities.Avis;

public interface AvisRepository extends CrudRepository<Avis, Long>{

}