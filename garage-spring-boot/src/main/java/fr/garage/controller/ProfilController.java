package fr.garage.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("profil")
public class ProfilController {

	@Autowired
	private GaragisteService srvGaragiste;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/monEspace")
	public String findByEmail(Model model) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("garagiste", this.srvGaragiste.findByEmail(authentication.getName()));
		
		return "profil-garagiste";	
	}
	
	@GetMapping("/modifier")
	public String update(@RequestParam int id, Model model) {
		
		model.addAttribute("garagiste", this.srvGaragiste.findById(id));
		return "editProfil";
	}
	
	@PostMapping("/modifier")
	public String update(@Valid Garagiste garagiste, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			return "editProfil";
		}
		// Encryptage mot de passe
		garagiste.setPassword(this.passwordEncoder.encode(garagiste.getPassword()));
		
		this.srvGaragiste.update(garagiste);
		
		return "redirect:monEspace?garagisteModifie=true";
	}

}
