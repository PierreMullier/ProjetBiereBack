package fr.projetBiere.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import fr.projetBiere.dao.BarRepository;



@RestController
@CrossOrigin("*")
public class BarRest {
	@Autowired
	public BarRepository clientRepo;
}
