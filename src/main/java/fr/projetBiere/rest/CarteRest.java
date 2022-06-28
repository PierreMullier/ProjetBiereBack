package fr.projetBiere.rest;

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
	public boolean deletecarte(@PathVariable Long id) {
		Optional<Carte> b1 = carteRepo.findById(id);
		if(b1.isEmpty()) {
			return false;
		}else {
			carteRepo.deleteById(id);
		}
		
		return true;
	}
	
	@PostMapping("/carte")
	public Carte saveClient(@RequestBody Carte b) {
		return carteRepo.save(b);	
	}
	
	
	@GetMapping("/cartes/{id}")
	public Optional<Carte> getcarteById(@PathVariable Long id){
		return (Optional<Carte>) carteRepo.findById(id);
	}
}