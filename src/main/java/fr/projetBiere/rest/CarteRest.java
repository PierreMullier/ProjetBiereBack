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

import fr.projetBiere.dao.CarteRepository;
import fr.projetBiere.entities.Carte;

@RestController
@CrossOrigin("*")
public class CarteRest {
	@Autowired
	CarteRepository carteRepo;
	
	@DeleteMapping("carte/{id}")
	public boolean deleteCarte(@PathVariable Long id) {
		Optional<Carte> b1 = carteRepo.findById(id);
		if(b1.isEmpty()) {
			return false;
		}else {
			carteRepo.deleteById(id);
		}
		
		return true;
	}
	
	@PostMapping("/carte")
	public Carte saveCarte(@RequestBody Carte c) {
		return carteRepo.save(c);	
	}
	
	@GetMapping("/cartes/bar/{id}")
	public List<Carte> getCarteByBarId(@PathVariable Long id){
		return (List<Carte>) carteRepo.findByBarIdBar(id);
	}
	
	@GetMapping("/cartes/biere/{id}")
	public List<Carte> getCarteByBiereId(@PathVariable Long id){
		return (List<Carte>) carteRepo.findByBiereIdBiere(id);
	}
}
