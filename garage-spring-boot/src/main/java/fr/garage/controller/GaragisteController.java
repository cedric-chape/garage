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

import fr.garage.model.Garagiste;
import fr.garage.service.GaragisteService;

@Controller
@RequestMapping("/garagiste")
public class GaragisteController {

	@Autowired
	private GaragisteService srvGaragiste;

	@GetMapping("/liste")
	public String findAll(Model model) {

		model.addAttribute("garagistes", this.srvGaragiste.findAll());
		return "liste-garagiste";

	}

	@GetMapping("/ajouter")
	public String add() {

		return "form-garagiste";
	}

	@PostMapping("/ajouter")
	public String add(@Valid Garagiste garagiste, BindingResult result, Model model) {

		if (result.hasErrors()) {

			return "form-garagiste";
		}

		// Encryptage password
//		String passwordEncrypted = Hashing.sha256().hashString(garagiste.getPassword(), StandardCharsets.UTF_8).toString();
//		garagiste.setPassword(passwordEncrypted);

		// Ajout en BDD
		this.srvGaragiste.add(garagiste);

		// Redirection
		model.addAttribute("garagisteAjoute", true);

		return "redirect:liste?garagisteAjoute=true";
	}

	@GetMapping("/modifier")
	public String update(@RequestParam int id, Model model) {

		model.addAttribute("garagiste", this.srvGaragiste.findById(id));
		return "form-garagiste";
	}

	@PostMapping("/modifier")
	public String update(@Valid Garagiste garagiste, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "form-garagiste";
		}

		this.srvGaragiste.update(garagiste);

		return "redirect:liste?garagisteModifie=true";
	}

	@GetMapping("/supprimer")
	public String deleteById(@RequestParam int id) {

		this.srvGaragiste.deleteById(id);
		return "redirect:liste?garagisteSupprime=true";
	}
}
