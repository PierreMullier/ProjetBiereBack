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

import fr.projetBiere.dao.AvisRepository;
import fr.projetBiere.entities.Avis;
import fr.projetBiere.entities.Bar;
import fr.projetBiere.entities.User;


@RestController 
@CrossOrigin("*")
public class AvisRest {

    @Autowired
    AvisRepository avisRepo;

    @GetMapping("/avis")
    public List<Avis> getAllAvis(){
        return (List<Avis>) avisRepo.findAll();
    }

    @PostMapping("/avis/save")
    public Avis saveAvis(@RequestBody Avis av) {
        return avisRepo.save(av);    
    }

    @DeleteMapping("avis/{id}")
    public boolean deleteAvis(@PathVariable Long id) {
        Optional<Avis> av = avisRepo.findById(id);
        if(av.isEmpty()) {
            return false;
        }else {
            avisRepo.deleteById(id);
        }
        return true;
    }


    // insertion d'un avis
        @PostMapping(value = "/avis/ajout")
        public Avis insertAvis(@RequestBody Avis av) {

        return avisRepo.save(av);
        }

        @GetMapping("avis/user/{nom}")
        public List<Avis> getAvisByNomUser(@PathVariable String nom){
            return avisRepo.findAvisByUserNom("%"+nom+"%");
        }

        @GetMapping("avis/bar/{nom}")
        public List<Avis> getAvisByNomBar(@PathVariable String nom){
            return avisRepo.findAvisByBarNom("%"+nom+"%");
        }
}