package fr.garage;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import fr.garage.exception.IdMustBePositiveException;
import fr.garage.model.Operation;
import fr.garage.service.OperationService;

public class Application {

	public static void main(String[] args) {
		
		//findAllOperation();
		//findByIdOperation();
		//addOperation();
		//updateOperation();
		deleteOperation();

	}
	
	public static void findAllOperation() {
		// test findAll()
		OperationService service = new OperationService();
		
		List<Operation> operations = service.findAll();
		
		for (Operation o: operations) {
			System.out.println(o.getId() + " " + o.getLibelle() + " " + o.getPrixUnitaire() + "� " + o.getDescription());
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
			System.out.println("Cette op�ration n'existe pas dans la base de donn�es...");
		}
		
		System.out.println("----------------------");
	}
	
	public static void addOperation() {
		// test addOperation
		OperationService service = new OperationService();
		
		Operation operation = new Operation();
		operation.setLibelle("Test ajout libell� op�ration");
		operation.setDescription("Test ajout description op�ration");
		operation.setPrixUnitaire(new BigDecimal(500));
		
		service.add(operation);
		
		System.out.println("Ajout� !");
	}
	
	public static void updateOperation() {
		OperationService service = new OperationService();
		
		// On r�cup�re l'op�ration
		Operation operation = service.findById(16);
		
		// On modifie le libell�
		operation.setLibelle("R��dition du libell� op�ration");
	
		// Sauvegarde de l'operation
		service.update(operation);
		
		System.out.println("Mis � jour !");
	}
	
	public static void deleteOperation() {
		OperationService service = new OperationService();
		
		try {
			Operation operation = service.findById(16);
			service.deleteById(operation.getId());
			
			System.out.println("Supprim� !");
		}
		
		catch (IdMustBePositiveException idex) {
			System.out.println("L'id n'est pas strictement > 0... ");
		}
		
		catch (NoSuchElementException nseex) {
			System.out.println("Cette op�ration n'existe pas dans la base de donn�es...");
		}
		
		
		
	}

}
