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

import fr.projetBiere.dao.BiereRepository;
import fr.projetBiere.entities.Biere;

@RestController
@CrossOrigin("*")
public class BiereRest {
	@Autowired
	public BiereRepository biereRepo;
	
	@GetMapping("/bieres")
	public List<Biere> getAllbiere(){
		return (List<Biere>) biereRepo.findAll();
	}
	
	@DeleteMapping("biere/{id}")
	public boolean deletebiere(@PathVariable Long id) {
		Optional<Biere> b1 = biereRepo.findById(id);
		if(b1.isEmpty()) {
			return false;
		}else {
			biereRepo.deleteById(id);
		}
		
		return true;
	}
	
	@PostMapping("/biere")
	public Biere saveClient(@RequestBody Biere b) {
		return biereRepo.save(b);	
	}
	
	@PutMapping("biere/update/{id}")
    public Biere editUser(@PathVariable Long id, @RequestBody Biere b) {

        Optional <Biere> b1 = biereRepo.findById(id);
        if (b1.isEmpty()) {
            return null;
        } else {
            b.setIdBiere(id);
            return biereRepo.save(b);
        }
	}
	
	@GetMapping("/bieres/{id}")
	public Optional<Biere> getbiereById(@PathVariable Long id){
		return (Optional<Biere>) biereRepo.findById(id);
	}
	
	@GetMapping("/biere/nom/{nom}")
	public Optional<Biere> getbiereByName(@PathVariable String nom){
		return (Optional<Biere>) biereRepo.findByNom(nom);
	}
	
	@GetMapping("/biere/taux/{degre}")
	public List<Biere> getbiereByAlcool(@PathVariable double degre){
		return (List<Biere>) biereRepo.findByDegre(degre);
	}
	
	@GetMapping("/biere/style/{style_id_style}")
	public List<Biere> getbiereByStyle(@PathVariable Long style_id_style){
		return (List<Biere>) biereRepo.findByStyleIdStyle(style_id_style);
	}
}
