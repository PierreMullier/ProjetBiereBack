package fr.projetBiere.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.projetBiere.dao.BarRepository;
import fr.projetBiere.entities.Bar;
import fr.projetBiere.entities.Biere;



@RestController
@CrossOrigin("*")
public class BarRest {
	@Autowired
	public BarRepository barRepo;
	
	@GetMapping("/bars")
	public List<Bar> getAllBar(){
		return (List<Bar>) barRepo.findAll();
	}
	
	@DeleteMapping("bar/{id}")
	public boolean deleteBar(@PathVariable Long id) {
		Optional<Bar> b1 = barRepo.findById(id);
		if(b1.isEmpty()) {
			return false;
		}else {
			barRepo.deleteById(id);
		}
		
		return true;
	}
	
	@PostMapping("/bar")
	public Bar saveBar(@RequestBody Bar b) {
		return barRepo.save(b);	
	}
	
	@PutMapping("bar/update/{id}")
    public Bar editBar	(@PathVariable Long id, @RequestBody Bar b) {

        Optional <Bar> b1 = barRepo.findById(id);
        if (b1.isEmpty()) {
            return null;
        } else {
            b.setIdBar(id);
            return barRepo.save(b);
        }
	}
	
	@GetMapping("/bars/{id}")
	public Optional<Bar> getBarById(@PathVariable Long id){
		return (Optional<Bar>) barRepo.findById(id);
	}
	@GetMapping("bar/adresse/{codePostal}")
	public List<Bar> getBarByQuartier(@PathVariable String codePostal){
		return barRepo.findByAdresseLike("%"+codePostal+"%");
	}
	
	@GetMapping("bar/nom/{nom}") 
	public List<Bar> getBarByNom(@PathVariable String nom){
		return barRepo.findByNomLike("%"+nom+"%");
	}
	
	@GetMapping("bar/finHapp/{finHapp}")
	public List<Bar> getBarByFinHappyHour(@PathVariable String finHapp){
		return barRepo.findByFinHapp(finHapp);
	}
	
	@GetMapping("bar/happyHours/{heure}")
	public List<Bar> getBarBetweenHappyHours(@PathVariable String heure){
		return barRepo.findByDebHappLessThanAndFinHappGreaterThan(heure,heure);
	}
	
	@GetMapping("bar/prix/{prixMax}")
	public List<Bar> getBarByPriceBeer(@PathVariable double prixMax){
		return barRepo.findByCartesPrix(prixMax);
	}
	
	@GetMapping("bar/degre/{degreMax}")
	public List<Bar> getBarByDegreBeer(@PathVariable double degreMax){
		return barRepo.findByBiereDegre(degreMax);
	}

	@GetMapping("bar/biere/nom/{nom}")
	public List<Bar> getBarByNomBeer(@PathVariable String nom){
		return barRepo.findByBiereNom("%"+nom+"%");
	}
	@GetMapping("bar/pref/{nomBiere}/{prix}/{nomCat}/{taux}")
	public List<Bar> getBarByPref(@PathVariable String nomBiere, @PathVariable double prix, @PathVariable String nomCat, @PathVariable double taux){
		return barRepo.findByPref(nomBiere,prix,nomCat,taux);
	}
	
	@GetMapping("bar/biere/categorie/{categorie}")
	public List<Bar> getBarByCategorieBeer(@PathVariable String categorie){
		return barRepo.findBarByBiereCatNom("%"+categorie+"%");
	}	
	
	@GetMapping("bar/biere/style/{style}")
	public List<Bar> getBarByStyleeBeer(@PathVariable String style){
		return barRepo.findBarByBiereStyleNom(style);
	}

}

