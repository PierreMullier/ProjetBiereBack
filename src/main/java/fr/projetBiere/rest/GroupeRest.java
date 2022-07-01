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
import fr.projetBiere.dao.GroupeRepository;
import fr.projetBiere.entities.Avis;
import fr.projetBiere.entities.Bar;
import fr.projetBiere.entities.Groupe;
@RestController
@CrossOrigin("*")
public class GroupeRest {
    @Autowired
    GroupeRepository groupeRepo;

    @GetMapping("/groupe")
    public List<Groupe> getAllGroupe(){
        return (List<Groupe>) groupeRepo.findAll();
}
    @PostMapping("/groupe/save")
    public Groupe saveGroupe(@RequestBody Groupe gr) {
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
    // insertion d'un groupe
            @PostMapping(value = "/groupe/ajout")
            public Groupe insertGroupe(@RequestBody Groupe gr) {

            return groupeRepo.save(gr);
            }



}

