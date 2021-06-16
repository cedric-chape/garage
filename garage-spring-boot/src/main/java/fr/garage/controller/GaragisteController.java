package fr.garage.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.garage.model.Garagiste;
import fr.garage.service.GaragisteService;

@Controller
@RequestMapping("/garagiste")
public class GaragisteController {

	@Autowired
	private GaragisteService srvGaragiste;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/liste")
	public String findAll(Model model) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		model.addAttribute("garagistes", this.srvGaragiste.findAll());
		model.addAttribute("userPrincipal", authentication.getName());
		return "liste-garagiste";

	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/ajouter")
	public String add() {

		return "form-garagiste";
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/ajouter")
	public String add(@Valid Garagiste garagiste, BindingResult result, Model model) {

		if (result.hasErrors()) {

			return "form-garagiste";
		}

		// Encryptage password
		garagiste.setPassword(this.passwordEncoder.encode(garagiste.getPassword()));

		// Ajout en BDD
		this.srvGaragiste.add(garagiste);

		// Redirection
		model.addAttribute("garagisteAjoute", true);

		return "redirect:liste?garagisteAjoute=true";
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/modifier")
	public String update(@RequestParam int id, Model model) {

		model.addAttribute("garagiste", this.srvGaragiste.findById(id));
		return "form-garagiste";
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/modifier")
	public String update(@Valid Garagiste garagiste, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "form-garagiste";
		}

		garagiste.setPassword(this.passwordEncoder.encode(garagiste.getPassword()));
		this.srvGaragiste.update(garagiste);

		return "redirect:liste?garagisteModifie=true";
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/supprimer")
	public String deleteById(@RequestParam int id) {
		
		Garagiste garagiste = this.srvGaragiste.findById(id);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (garagiste.getEmail().equals(authentication.getName())) {
			return "redirect:liste?garagisteSupprime=false";
		}

		this.srvGaragiste.deleteById(id);
		return "redirect:liste?garagisteSupprime=true";
	}
}
