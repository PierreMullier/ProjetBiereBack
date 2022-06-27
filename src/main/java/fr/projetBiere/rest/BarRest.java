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
	public Bar saveClient(@RequestBody Bar b) {
		return barRepo.save(b);	
	}
	
	@PutMapping("bar/update/{id}")
    public Bar editUser(@PathVariable Long id, @RequestBody Bar b) {

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
}
