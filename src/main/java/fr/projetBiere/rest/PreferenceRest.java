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

import fr.projetBiere.dao.PreferenceRepository;
import fr.projetBiere.entities.Preference;

@RestController
@CrossOrigin("*")
public class PreferenceRest {

	
	@Autowired
	PreferenceRepository preferenceRepo;
	
	@GetMapping("/preferences")
	public List<Preference> getAllPreference(){
		return (List<Preference>) preferenceRepo.findAll();
	}
	
	@DeleteMapping("preference/{id}")
	public boolean deletePreference(@PathVariable Long id) {
		Optional<Preference> b1 = preferenceRepo.findById(id);
		if(b1.isEmpty()) {
			return false;
		}else {
			preferenceRepo.deleteById(id);
		}
		
		return true;
	}
	
	@PostMapping("/preference")
	public Preference savePreference(@RequestBody Preference b) {
		return preferenceRepo.save(b);	
	}
	
	@PutMapping("preference/update/{id}")
    public Preference editPreference(@PathVariable Long id, @RequestBody Preference b) {

        Optional <Preference> b1 = preferenceRepo.findById(id);
        if (b1.isEmpty()) {
            return null;
        } else {
            b.setIdPref(id);
            return preferenceRepo.save(b);
        }
	}
	
	@GetMapping("/preferences/{id}")
	public Optional<Preference> getPreferenceById(@PathVariable Long id){
		return (Optional<Preference>) preferenceRepo.findById(id);
	}
	
	@GetMapping("preference/maxId") 
	public Preference getLastIdPreference() {
		return preferenceRepo.findIdByMaxId(); 

	}
}
