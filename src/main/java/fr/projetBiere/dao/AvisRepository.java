package fr.projetBiere.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.projetBiere.entities.Avis;


public interface AvisRepository extends CrudRepository<Avis, Long>{

    @Query("select av from Avis av inner join User u on u.id_user = av.user where u.nom LIKE ?1")
    List<Avis> findAvisByUser(String nom);

    @Query("select av from Avis av inner join Bar b on b.idBar = av.bar where b.nom LIKE ?1")
        List<Avis> findAvisByBar(String nom);

    List<Avis> findAvisByNote(double note);

}