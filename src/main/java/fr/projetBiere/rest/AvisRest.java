package fr.projetBiere.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import fr.projetBiere.dao.AvisRepository;

@RestController 
@CrossOrigin("*")
public class AvisRest {

	@Autowired
	AvisRepository avisRepo;
}
