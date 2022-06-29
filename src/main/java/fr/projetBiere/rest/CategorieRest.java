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

import fr.projetBiere.dao.CategorieRepository;
import fr.projetBiere.entities.Categorie;

@RestController
@CrossOrigin("*")
public class CategorieRest {
	@Autowired
	CategorieRepository categorieRepo;
	
	@GetMapping("/categories")
	public List<Categorie> getAllCategorie(){
		return (List<Categorie>) categorieRepo.findAll();
	}
	
	@DeleteMapping("categorie/{id}")
	public boolean deleteCategorie(@PathVariable Long id) {
		Optional<Categorie> b1 = categorieRepo.findById(id);
		if(b1.isEmpty()) {
			return false;
		}else {
			categorieRepo.deleteById(id);
		}
		
		return true;
	}
	
	@PostMapping("/categorie")
	public Categorie saveCategorie(@RequestBody Categorie b) {
		return categorieRepo.save(b);	
	}
	
	@PutMapping("categorie/update/{id}")
    public Categorie editCategorie(@PathVariable Long id, @RequestBody Categorie b) {

        Optional <Categorie> b1 = categorieRepo.findById(id);
        if (b1.isEmpty()) {
            return null;
        } else {
            b.setIdCat(id);
            return categorieRepo.save(b);
        }
	}
	
	@GetMapping("/categories/{id}")
	public Optional<Categorie> getCategorieById(@PathVariable Long id){
		return (Optional<Categorie>) categorieRepo.findById(id);
	}
}
