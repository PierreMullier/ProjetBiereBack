package fr.projetBiere.dao;

import org.springframework.data.repository.CrudRepository;

import fr.projetBiere.entities.Preference;

public interface PreferenceRepository extends CrudRepository<Preference, Long> {

}
