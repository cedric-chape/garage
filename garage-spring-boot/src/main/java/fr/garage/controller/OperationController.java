package fr.garage.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.garage.model.Operation;
import fr.garage.service.OperationService;

@Controller
@RequestMapping("/operation")
public class OperationController {

	@Autowired
	private OperationService srvOperation;
	
	@GetMapping("/liste")
	public String findAll(Model model) {
	
		model.addAttribute("operations", this.srvOperation.findAll());
		return "liste-operation";
	}
	
	@GetMapping("/ajouter")
	public String add() {
		
		return "form-operation";
	}
	
	@PostMapping("/ajouter")
	public String add( @Valid Operation operation, BindingResult result) {
		
		if (result.hasErrors()) {
			
			return "form-operation";
		}
		
		this.srvOperation.add(operation);
		
		return "redirect:liste?operationAjoute=true";
	}
	
	@GetMapping("/modifier")
	public String update(@RequestParam int id, Model model) {
		model.addAttribute("operation", this.srvOperation.findById(id));
		
		return "form-operation";
	}
	
	@PostMapping("/modifier")
	public String update(@Valid Operation operation, BindingResult result) {
		
		if (result.hasErrors()) {
			return "form-operation";
		}
		
		this.srvOperation.update(operation);
		
		return "redirect:liste?operationModifie=true";
	}
	
	@GetMapping("/supprimer")
	public String deleteById(@RequestParam int id) {
		this.srvOperation.deleteById(id);
		
		return "redirect:liste?operationSupprime=true";
	}
}
