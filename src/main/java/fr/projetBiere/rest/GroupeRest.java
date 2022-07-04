package fr.projetBiere.rest;
import java.util.ArrayList;
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
import fr.projetBiere.dao.GroupeRepository;
import fr.projetBiere.dao.UserRepository;
import fr.projetBiere.entities.Avis;
import fr.projetBiere.entities.Bar;
import fr.projetBiere.entities.Groupe;
import fr.projetBiere.entities.User;

@RestController
@CrossOrigin("*")
public class GroupeRest {
    @Autowired
    GroupeRepository groupeRepo;
    @Autowired
    UserRepository userRepo;

    @GetMapping("/groupe")
    public List<Groupe> getAllGroupe(){
        return (List<Groupe>) groupeRepo.findAll();
}
    @PostMapping("/groupe/save/{id_owner}")
    public Groupe saveGroupe(@RequestBody Groupe gr, @PathVariable long id_owner) {
    	User u = userRepo.getUserByIdModif(id_owner);
    	gr.setOwner(u);
        return groupeRepo.save(gr);    
    }

    @GetMapping("/groupe/{id}")
    public Optional<Groupe> getGroupeById(@PathVariable Long id){
        return (Optional<Groupe>) groupeRepo.findById(id);

    }
    @DeleteMapping("groupe/{id}")
    public boolean deleteGroupe(@PathVariable Long id) {
        Optional<Groupe> gr = groupeRepo.findById(id);
        if(gr.isEmpty()) {
            return false;
        }else {
            groupeRepo.deleteById(id);
        }

        return true;
    }
    
    @GetMapping("groupe/user/{id_owner}")
    public Groupe getGroupebyIdOwner(@PathVariable Long id_owner) {
    	return groupeRepo.findByOwnerIdUser(id_owner);
    }
    // insertion personne dans le groupe
    @PutMapping("groupe/{id_groupe}/{mail}")
    public Groupe addUserToGroupe(@PathVariable long id_groupe, @PathVariable String mail) {
    	Groupe g = null;
    	//	User u = userRepo.findByMail(mail);
    	g= groupeRepo.findByIdModif(id_groupe);
    	String[] lu =g.getMembreGroup();
    	String[] lu1;
    	if(lu==null) {
    		 lu1= new String[0];
    	}
    	else {
    		 lu1 =g.getMembreGroup();
    	}
    	
    	int l =lu1.length;
    	String[] lu2 = new String[l+1];
    	lu2[l+1]=mail;
    	g.setMembreGroup(lu2);
    	return groupeRepo.save(g);
    	
    }
         



}

