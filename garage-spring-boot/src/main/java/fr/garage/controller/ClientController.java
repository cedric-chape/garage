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

import fr.garage.model.Client;
import fr.garage.service.ClientService;

@Controller
@RequestMapping("/client")
public class ClientController {


	@Autowired
	private ClientService srvClient;
	
	@GetMapping("/liste")
	public String findAll(Model model) {
		List<Client> mesClients = this.srvClient.findAll();
		
		model.addAttribute("clients", mesClients);
		
		return "liste-client";
	}
	
	@GetMapping("/ajouter")
	public String add() {
		
		return "form-client";
	}
	
	@PostMapping("/ajouter")
	public String add(@Valid Client client, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			
			return "form-client";
		}
		
		this.srvClient.add(client);
		
		//Redirection
		model.addAttribute("clientAjoute", true);
		
		return "redirect:liste?clientAjoute=true";
	}
	
	@GetMapping("/modifier")
	public String update(@RequestParam int id, Model model) {
		
		model.addAttribute("client", this.srvClient.findById(id));
		return "form-client";
	}
	
	@PostMapping("/modifier")
	public String update(@Valid Client client, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			return "form-client";
		}
		
		this.srvClient.update(client);
		
		return "redirect:liste?clientModifie=true";
	}
	
	@GetMapping("/supprimer")
	public String deleteById(@RequestParam int id) {
		this.srvClient.deleteById(id);
		
		return "redirect:liste?clientSupprime=true";
	}
}