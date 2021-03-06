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
	public List<User> getAllUser(){
		return (List<User>) userRepo.findAll();
	}
	
	@DeleteMapping("user/{id}")
	public boolean deleteUser(@PathVariable Long id) {
		Optional<User> b1 = userRepo.findById(id);
		if(b1.isEmpty()) {
			return false;
		}else {
			userRepo.deleteById(id);
		}
		
		return true;
	}
	
	@PostMapping("/user")
	public User saveUser(@RequestBody User b) {
		return userRepo.save(b);	
	}
	
	@PutMapping("user/update/{id}")
    public User editUser(@PathVariable Long id, @RequestBody User b) {

        Optional <User> b1 = userRepo.findById(id);
        if (b1.isEmpty()) {
            return null;
        } else {
            b.setId_user(id);
            return userRepo.save(b);
        }
	}
	
	@GetMapping("/users/{id}")
	public  Optional<User> getUserById(@PathVariable Long id){
		return userRepo.findById(id); 
	}
	
	@GetMapping("/user/{mail}/{password}")
	public User getUserByMailPassword(@PathVariable String mail,@PathVariable String password) {
		return userRepo.findByMailAndPassword(mail, password);
	}
	
	@GetMapping("/user/{mail}")
	public User getUserByMail(@PathVariable String mail) {
		return userRepo.findByMail(mail);
	}
	
	@GetMapping("/user/modif/{id}")
	public User getUserByidModif(@PathVariable Long id_user) {
		return userRepo.getUserByIdModif(id_user);
	}
	
}
