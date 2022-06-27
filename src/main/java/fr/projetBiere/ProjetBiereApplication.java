package fr.projetBiere;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import fr.projetBiere.dao.BarRepository;
import fr.projetBiere.dao.BiereRepository;
import fr.projetBiere.entities.Bar;
import fr.projetBiere.entities.Categorie;

@SpringBootApplication
public class ProjetBiereApplication implements CommandLineRunner{
	@Autowired
	BarRepository barRepo;
	@Autowired
	BiereRepository biereRepo;
	
	public static void main(String[] args)  {
		SpringApplication.run(ProjetBiereApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		LocalTime t1 =LocalTime.of(16, 0);
		LocalTime t2 = LocalTime.of(22, 0);	
		
		Bar b1 = new Bar("nom", "localisation", "adresse", t1, t2);
		barRepo.save(b1);
		
		Categorie c1 = new Categorie("testCat");
		
		System.out.println("run success");
	}

}
