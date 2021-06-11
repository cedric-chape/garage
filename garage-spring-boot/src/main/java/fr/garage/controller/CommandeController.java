package fr.garage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.garage.service.CommandeService;

@Controller
public class CommandeController {

	@Autowired
	private CommandeService srvCommande;
}
