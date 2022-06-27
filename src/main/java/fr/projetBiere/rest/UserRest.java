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

import fr.projetBiere.dao.UserRepository;
import fr.projetBiere.entities.User;

@RestController
@CrossOrigin("*")
public class UserRest {

	@Autowired
	UserRepository userRepo;
	
	@GetMapping("/users")
	public List<User> getAlluser(){
		return (List<User>) userRepo.findAll();
	}
	
	@DeleteMapping("user/{id}")
	public boolean deleteuser(@PathVariable Long id) {
		Optional<User> b1 = userRepo.findById(id);
		if(b1.isEmpty()) {
			return false;
		}else {
			userRepo.deleteById(id);
		}
		
		return true;
	}
	
	@PostMapping("/user")
	public User saveClient(@RequestBody User b) {
		return userRepo.save(b);	
	}
	
	@PutMapping("user/update/{id}")
    public User editUser(@PathVariable Long id, @RequestBody User b) {

        Optional <User> b1 = userRepo.findById(id);
        if (b1.isEmpty()) {
            return null;
        } else {
            b.setIdUser(id);
            return userRepo.save(b);
        }
	}
	
	@GetMapping("/users/{id}")
	public Optional<User> getuserById(@PathVariable Long id){
		return (Optional<User>) userRepo.findById(id); 
	}
}
