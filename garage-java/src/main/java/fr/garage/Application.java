package fr.garage;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import fr.garage.exception.IdMustBePositiveException;
import fr.garage.model.Garagiste;
import fr.garage.model.Operation;
import fr.garage.service.GaragisteService;
import fr.garage.service.OperationService;

public class Application {

	public static void main(String[] args) {
		
		//findAllOperation();
		//findAllGaragiste();
		//findByIdOperation();
		//findByIdGaragiste();
		//addOperation();
		//addGaragiste();
		//updateOperation();
		//updateGaragiste();
		//deleteOperation();
		deleteGaragiste();

	}
	
	public static void findAllOperation() {
		// test findAll()
		OperationService service = new OperationService();
		
		List<Operation> operations = service.findAll();
		
		for (Operation o: operations) {
			System.out.println(o.getId() + " " + o.getLibelle() + " " + o.getPrixUnitaire() + "€ " + o.getDescription());
		}
		
		System.out.println("----------------------");
	}
	
	public static void findAllGaragiste() {
		// test findAll()
		GaragisteService service = new GaragisteService();
		
		List<Garagiste> garagistes = service.findAll();
		
		for (Garagiste g: garagistes) {
			System.out.println(g.getId() + " " + g.getNom() + " " + g.getPrenom());
		}
		
		System.out.println("----------------------");
	}
	public static void findByIdOperation() {
		OperationService service = new OperationService();

		
		// test findById(int id)
		try {
			Operation operation = service.findById(10);
		}
		
		catch (IdMustBePositiveException idex) {
			System.out.println("L'id n'est pas strictement > 0... ");
		}
		
		catch (NoSuchElementException nseex) {
			System.out.println("Cette opération n'existe pas dans la base de données...");
		}
		
		System.out.println("----------------------");
	}
	
	public static void findByIdGaragiste() {
		GaragisteService service = new GaragisteService();

		
		// test findById(int id)
		try {
			Garagiste garagiste = service.findById(4);
			System.out.println(garagiste.getId() + " " + garagiste.getNom() + " " + garagiste.getPrenom());
		}
		
		catch (IdMustBePositiveException idex) {
			System.out.println("L'id n'est pas strictement > 0... ");
		}
		
		catch (NoSuchElementException nseex) {
			System.out.println("Cette opération n'existe pas dans la base de données...");
		}
		
		System.out.println("----------------------");
	}
	
	public static void addOperation() {
		// test addOperation
		OperationService service = new OperationService();
		
		Operation operation = new Operation();
		operation.setLibelle("Test ajout libellé opération");
		operation.setDescription("Test ajout description opération");
		operation.setPrixUnitaire(new BigDecimal(500));
		
		service.add(operation);
		
		System.out.println("Ajouté !");
	}
	
	public static void addGaragiste() {
		// test addOperation
		GaragisteService service = new GaragisteService();
		
		Garagiste garagiste = new Garagiste();
		garagiste.setNom("Test ajout nom garagiste");
		garagiste.setPrenom("Test ajout prenom garagiste");
		
		service.add(garagiste);
		
		System.out.println("Ajouté !");
	}
	
	public static void updateOperation() {
		OperationService service = new OperationService();
		
		// On récupère l'opération
		Operation operation = service.findById(16);
		
		// On modifie le libellé
		operation.setLibelle("Réédition du libellé opération");
	
		// Sauvegarde de l'operation
		service.update(operation);
		
		System.out.println("Mis à jour !");
	}
	
	public static void updateGaragiste() {
		GaragisteService service = new GaragisteService();
		
		// On récupère l'opération
		Garagiste garagiste = service.findById(5);
		
		// On modifie le libellé
		garagiste.setNom("Réédition du nom garagiste");
	
		// Sauvegarde de l'operation
		service.update(garagiste);
		
		System.out.println("Mis à jour !");
	}
	
	public static void deleteOperation() {
		OperationService service = new OperationService();
		
		try {
			Operation operation = service.findById(16);
			service.deleteById(operation.getId());
			
			System.out.println("Supprimé !");
		}
		
		catch (IdMustBePositiveException idex) {
			System.out.println("L'id n'est pas strictement > 0... ");
		}
		
		catch (NoSuchElementException nseex) {
			System.out.println("Cette opération n'existe pas dans la base de données...");
		}
	}
	
	public static void deleteGaragiste() {
		GaragisteService service = new GaragisteService();
		
		try {
			Garagiste garagiste = service.findById(5);
			service.deleteById(garagiste.getId());
			
			System.out.println("Supprimé !");
		}
		
		catch (IdMustBePositiveException idex) {
			System.out.println("L'id n'est pas strictement > 0... ");
		}
		
		catch (NoSuchElementException nseex) {
			System.out.println("Cette opération n'existe pas dans la base de données...");
		}
	}

}
