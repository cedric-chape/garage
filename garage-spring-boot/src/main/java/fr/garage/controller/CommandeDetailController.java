package fr.garage.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.garage.model.Commande;
import fr.garage.model.CommandeDetail;
import fr.garage.model.CommandeDetailId;
import fr.garage.model.Operation;
import fr.garage.service.CommandeDetailService;
import fr.garage.service.CommandeService;
import fr.garage.service.OperationService;

@Controller
@RequestMapping("/commande/commande-detail")
public class CommandeDetailController {

	@Autowired
	private CommandeDetailService srvCommandeDetail;
	
	@Autowired
	private CommandeService srvCommande;
	
	@Autowired
	private OperationService srvOperation;
	
//	@GetMapping("/detail")
//	public String findAll(@RequestParam int id, Model model) {
//		model.addAttribute("commandesDetails", this.srvCommandeDetail.findAll());
//		
//		return "liste-commandeDetail";
//	}
	
	
//	@GetMapping("/modifier")
//	public String update(@RequestParam int id, Model model) {
//		model.addAttribute("commandes", this.srvCommande.findAll());
//		model.addAttribute("operations", this.srvOperation.findAll());
//		model.addAttribute("commande", this.srvCommande.findById(id));
//		return "liste-commandeDetail";
//	}
	
	@GetMapping("detail")
	public String findAll(@RequestParam int id, Model model) {
		List<CommandeDetail> mesCommandesDetails = this.srvCommandeDetail.findAll();
		model.addAttribute("commandesDetails", mesCommandesDetails);
		model.addAttribute("commande", this.srvCommande.findById(id));
		return "liste-commandeDetail";
	}
	
	@GetMapping( "detail/{id}/ajouter")
	public String add(Model model, @PathVariable int id) {
		model.addAttribute("operations", this.srvOperation.findAll());
		model.addAttribute("commandeId", id);
		return "form-detail";
	}
	
	@PostMapping("detail/{id}/ajouter")
	public String add(@RequestParam int quantite, @RequestParam int commandeId, @RequestParam int operationId, @PathVariable int id, Model model) {
		CommandeDetail commandeDetail = new CommandeDetail();
		CommandeDetailId detailId = new CommandeDetailId();
		Operation operation = this.srvOperation.findById(operationId);
		Commande commande = this.srvCommande.findById(commandeId);
		
		detailId.setCommande(new Commande());
		detailId.setOperation(new Operation());
		
		detailId.getCommande().setId(commandeId);
		detailId.getOperation().setId(operationId);
		
		commandeDetail.setQuantite(quantite);
		commandeDetail.setId(detailId);
		commandeDetail.setPrixUnitaire(new BigDecimal(commandeDetail.getQuantite()).multiply(operation.getPrixUnitaire()));
		this.srvCommandeDetail.add(commandeDetail);
		
		// Mise à jour commande
		commande.setPrixTotal(this.srvCommandeDetail.findPrixTotalCommandeDetail(commandeId));
		this.srvCommande.update(commande);
		
		return "redirect:/commande/commande-detail/detail?id=" + commandeId;
	}
	
//	@GetMapping("detail/{id}/supprimer")
//	public String deleteById(@RequestParam int id) {
//		this.srvOperation.deleteById(id);
//		
//		return "redirect:liste?operationSupprime=true";
//	}
}
