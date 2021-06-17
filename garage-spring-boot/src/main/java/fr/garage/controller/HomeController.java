package fr.garage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.garage.model.Commande;
import fr.garage.model.EtatCommande;
import fr.garage.model.Garagiste;
import fr.garage.service.CommandeService;
import fr.garage.service.GaragisteService;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private GaragisteService srvGaragiste;
	
	@Autowired
	private CommandeService srvCommande;
	
	@GetMapping
	public String home(Model model) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Garagiste garagiste = this.srvGaragiste.findByEmail(authentication.getName());
		
		List<Commande> commandesEnCours = this.srvCommande.findAllByEtatCommande(EtatCommande.ENCOURS);
		
		model.addAttribute("garagiste", garagiste);
		model.addAttribute("commandesEnCours", this.srvCommande.findAllByEtatCommande(EtatCommande.ENCOURS));
		
		for (Commande c : commandesEnCours)
			System.out.println(c.getId());
		
		return "home";
	}
	
}
