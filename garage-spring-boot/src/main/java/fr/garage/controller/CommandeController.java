package fr.garage.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.garage.model.Commande;
import fr.garage.service.ClientService;
import fr.garage.service.CommandeService;
import fr.garage.service.GaragisteService;
import fr.garage.service.VehiculeService;

@Controller
@RequestMapping("/commande")
public class CommandeController {

	@Autowired
	private CommandeService srvCommande;
	
	@Autowired
	private ClientService srvClient;
	
	@Autowired
	private VehiculeService srvVehicule;
	
	@Autowired
	private GaragisteService srvGaragiste;
	
	@GetMapping("liste")
	public String findAll(Model model) {
		List<Commande> mesCommandes = this.srvCommande.findAll();
		
		model.addAttribute("commandes", mesCommandes);
		
		return "liste-commandes";
	}
	
	@GetMapping("/ajouter")
	public String add(Model model) {
		model.addAttribute("clients", this.srvClient.findAll()); 
		model.addAttribute("vehicules", this.srvVehicule.findAll());
		model.addAttribute("garagistes", this.srvGaragiste.findAll());
		return "form-commande";
	}
	
	@PostMapping("/ajouter")
	public String add(@Valid Commande commande, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("clients", this.srvClient.findAll());
			model.addAttribute("garagistes", this.srvGaragiste.findAll());
			model.addAttribute("vehicules", this.srvVehicule.findAll());
			return "form-commande";
		}
		
		commande.setPrixTotal(new BigDecimal(0));
		this.srvCommande.add(commande);
		return "redirect:liste?commandeAjout=true";
	}
	

	@GetMapping("/modifier")
	public String update(@RequestParam int id, Model model) {
		model.addAttribute("clients", this.srvClient.findAll());
		model.addAttribute("garagistes", this.srvGaragiste.findAll());
		model.addAttribute("vehicules", this.srvVehicule.findAll());
		model.addAttribute("commande", this.srvCommande.findById(id));
		return "form-commande";
	}
	
	
	@PostMapping("/modifier")
	public String update(@Valid Commande commande, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("clients", this.srvClient.findAll());
			model.addAttribute("garagistes", this.srvGaragiste.findAll());
			model.addAttribute("vehicules", this.srvVehicule.findAll());
			return "form-commande";
		}
		this.srvCommande.update(commande);
		
		return "redirect:liste?commandeModifie=true";
	}
	
	@GetMapping("/supprimer")
	public String deleteById(@RequestParam int id) {
		this.srvCommande.deleteById(id);
		return "redirect:liste?commandeSupprime=true";
	}
}
