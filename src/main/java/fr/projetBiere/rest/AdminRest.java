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

import fr.projetBiere.dao.AdminRepository;
import fr.projetBiere.entities.Admin;


@RestController
@CrossOrigin("*")
public class AdminRest {

    @Autowired
    AdminRepository adminRepo;

    @GetMapping("/admins")
    public List<Admin> getAllAdmin(){
        return (List<Admin>) adminRepo.findAll();
    }

    @DeleteMapping("admin/{id}")
    public boolean deleteAdmin(@PathVariable Long id) {
        Optional<Admin> a1 = adminRepo.findById(id);
        if(a1.isEmpty()) {
            return false;
        }else {
            adminRepo.deleteById(id);
        }

        return true;
    }


    @PostMapping("/admin")
    public Admin saveAdmin(@RequestBody Admin a) {
        return adminRepo.save(a);    
    }

    @PutMapping("admin/update/{id}")
    public Admin editAdmin(@PathVariable Long id, @RequestBody Admin a) {

        Optional <Admin> a1 = adminRepo.findById(id);
        if (a1.isEmpty()) {
            return null;
        } else {
            a.setIdAdmin(id);
            return adminRepo.save(a);
        }
    }

    @GetMapping("/admins/{id}")
    public Optional<Admin> getUserById(@PathVariable Long id){
        return (Optional<Admin>) adminRepo.findById(id); 
    }

    @GetMapping("/admin/{mail}/{password}")
    public Admin getAdminByMailPassword(@PathVariable String mail,@PathVariable String password) {
        return adminRepo.findByMailAndPassword(mail, password);
    }

}