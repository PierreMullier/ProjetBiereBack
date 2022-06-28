package fr.projetBiere;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import fr.projetBiere.dao.BarRepository;
import fr.projetBiere.dao.BiereRepository;
import fr.projetBiere.dao.CategorieRepository;
import fr.projetBiere.dao.ImportDataFromJson;
import fr.projetBiere.dao.PreferenceRepository;
import fr.projetBiere.dao.StyleRepository;
import fr.projetBiere.dao.UserRepository;
import fr.projetBiere.entities.Bar;
import fr.projetBiere.entities.Biere;
import fr.projetBiere.entities.Categorie;
import fr.projetBiere.entities.Preference;
import fr.projetBiere.entities.Style;
import fr.projetBiere.entities.User;

@SpringBootApplication
public class ProjetBiereApplication implements CommandLineRunner{
	@Autowired
	BarRepository barRepo;
	@Autowired
	BiereRepository biereRepo;
	@Autowired
	StyleRepository styleRepo;
	@Autowired
	CategorieRepository categorieRepo;
	@Autowired
	UserRepository userRepo;
	@Autowired
	PreferenceRepository prefRepo;
	
	public static void main(String[] args)  {
		SpringApplication.run(ProjetBiereApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//LocalTime t1 =LocalTime.of(16, 0);
		//LocalTime t2 = LocalTime.of(22, 0);	
		
		//Bar b1 = new Bar("nom", "localisation", "adresse", "16:00:00", "22:00:00", "erre.fr");
		//barRepo.save(b1);
		
		Categorie c1 = new Categorie("testCat");
		categorieRepo.save(c1);
		
		Style s1 = new Style(c1, "Test Style");
		styleRepo.save(s1);
		
		Biere bi1 = new Biere("La bière de Pierre", c1, s1, 11.0, "Elle est bonne");
		biereRepo.save(bi1); 
		
		Preference p1= new Preference("test", 4, 11.8, "Leffe");
		prefRepo.save(p1);
		
		User u1 = new User("Pierre", "Mullier", "123@456.789", "test", p1);
		userRepo.save(u1);
		ImportDataFromJson.insertData(categorieRepo,styleRepo,biereRepo,barRepo,userRepo);
		System.out.println("run success");
	}

}
