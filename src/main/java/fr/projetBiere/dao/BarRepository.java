package fr.projetBiere.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.projetBiere.entities.Bar;

public interface BarRepository extends CrudRepository<Bar, Long> {

	List<Bar> findByAdresseLike(String codePostal);

	List<Bar> findByNomLike(String string);

	List<Bar> findByFinHapp(String string);

	List<Bar> findByDebHappLessThanAndFinHappGreaterThan(String heure, String heure2);

	@Query("select DISTINCT b from Bar b inner join Carte c on c.bar.idBar = b.idBar where c.prix <= ?1")
	List<Bar> findByCartesPrix(double prixMax);
	
	@Query("select DISTINCT b from Bar b inner join Carte c on c.bar.idBar = b.idBar  inner join Biere bi on bi.idBiere = c.biere.idBiere where c.biere.degre  <= ?1" )
	List<Bar> findByBiereDegre(double degreMax);

	@Query("select DISTINCT b from Bar b inner join Carte c on c.bar.idBar = b.idBar  inner join Biere bi on bi.idBiere = c.biere.idBiere where c.biere.nom LIKE ?1" )
	List<Bar> findByBiereNom(String nom);
	
	@Query("SELECT DISTINCT b FROM Bar b INNER JOIN Carte c ON c.bar.idBar = b.idBar INNER JOIN Biere bi ON bi.idBiere = c.biere.idBiere INNER JOIN Categorie cate ON bi.cat.idCat =cate.idCat WHERE c.biere.nom LIKE %?1% AND c.prix < ?2 AND c.biere.cat.nomCat LIKE %?3% AND c.biere.degre <?4")
	List<Bar> findByPref(String nomBiere, double prix, String nomCat, double taux);

	@Query("SELECT DISTINCT b FROM Bar b INNER JOIN Carte c ON c.bar.idBar = b.idBar INNER JOIN Biere bi ON bi.idBiere = c.biere.idBiere INNER JOIN Categorie cate ON bi.cat.idCat=cate.idCat WHERE  cate.nomCat LIKE ?1")
	List<Bar> findBarByBiereCatNom(String categorie);
	
	@Query("SELECT DISTINCT b FROM Bar b INNER JOIN Carte c ON c.bar.idBar = b.idBar INNER JOIN Biere bi ON bi.idBiere = c.biere.idBiere INNER JOIN Style s ON bi.style.idStyle=s.idStyle WHERE  c.biere.style.nom LIKE %?1% ")
	List<Bar> findBarByBiereStyleNom(String style);
}
