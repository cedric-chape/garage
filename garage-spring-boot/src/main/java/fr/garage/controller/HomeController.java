package fr.garage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.garage.model.Garagiste;
import fr.garage.service.GaragisteService;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private GaragisteService srvGaragiste;
	
	@GetMapping
	public String home(Model model) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Garagiste garagiste = this.srvGaragiste.findByEmail(authentication.getName());
		
		model.addAttribute("garagiste", garagiste);
		
		System.out.println("home");
		return "home";
	}
	
}
