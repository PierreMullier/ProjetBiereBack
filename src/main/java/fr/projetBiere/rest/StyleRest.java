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

import fr.projetBiere.dao.StyleRepository;
import fr.projetBiere.entities.Style;

@RestController
@CrossOrigin("*")
public class StyleRest {
	
	@Autowired
	StyleRepository styleRepo;
	
	@GetMapping("/styles")
	public List<Style> getAllStyle(){
		return (List<Style>) styleRepo.findAll();
	}
	
	@DeleteMapping("style/{id}")
	public boolean deleteStyle(@PathVariable Long id) {
		Optional<Style> b1 = styleRepo.findById(id);
		if(b1.isEmpty()) {
			return false;
		}else {
			styleRepo.deleteById(id);
		}
		
		return true;
	}
	
	@PostMapping("/style")
	public Style saveStyle(@RequestBody Style b) {
		return styleRepo.save(b);	
	}
	
	@PutMapping("style/update/{id}")
    public Style editStyle(@PathVariable Long id, @RequestBody Style b) {

        Optional <Style> b1 = styleRepo.findById(id);
        if (b1.isEmpty()) {
            return null;
        } else {
            b.setIdStyle(id);
            return styleRepo.save(b);
        }
	}
	
	@GetMapping("/styles/{id}")
	public Optional<Style> getStyleById(@PathVariable Long id){
		return (Optional<Style>) styleRepo.findById(id);
	}

}
