package fr.projetBiere.dao;

import org.springframework.data.repository.CrudRepository;

import fr.projetBiere.entities.Bar;

public interface BarRepository extends CrudRepository<Bar, Long> {

}
