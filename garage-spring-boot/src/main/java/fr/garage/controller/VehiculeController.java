package fr.garage.controller;

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

import fr.garage.model.Vehicule;
import fr.garage.service.ClientService;
import fr.garage.service.VehiculeService;

@Controller
@RequestMapping("/vehicule")
public class VehiculeController {

	@Autowired
	private VehiculeService srvVehicule;
	
	@Autowired
	private ClientService srvClient;
	
	@GetMapping("liste")
	public String findAll(Model model) {
		List<Vehicule> mesVehicules = this.srvVehicule.findAll();
		
		model.addAttribute("vehicules", mesVehicules);
		
		return "liste-vehicules";
	}
	
	@GetMapping("/ajouter")
	public String add(Model model) {
		model.addAttribute("clients", this.srvClient.findAll()); 
		return "form-vehicule";
	}
	
	@PostMapping("/ajouter")
	public String add(@Valid Vehicule vehicule, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("clients", this.srvClient.findAll());
			return "form-vehicule";
		}
		this.srvVehicule.add(vehicule);
		return "redirect:liste?vehiculeAjout=true";
	}
	
	@GetMapping("/modifier")
	public String update(@RequestParam int id, Model model) {
		model.addAttribute("clients", this.srvClient.findAll());
		model.addAttribute("vehicule", this.srvVehicule.findById(id));
		//model.addAttribute("clients", this.srvClient.findById(ClientId));
		return "form-vehicule";
	}
	
	@PostMapping("/modifier")
	public String update(@Valid Vehicule vehicule, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("clients", this.srvClient.findAll());
			return "form-vehicule";
		}
		this.srvVehicule.update(vehicule);
		
		return "redirect:liste?vehiculeModifie=true";
	}
	
	@GetMapping("/supprimer")
	public String deleteById(@RequestParam int id) {
		this.srvVehicule.deleteById(id);
		
		return "redirect:liste?vehiculeSupprime=true";
	}
}
