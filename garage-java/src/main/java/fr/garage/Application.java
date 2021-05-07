package fr.garage;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import fr.garage.exception.IdMustBePositiveException;
import fr.garage.model.Garagiste;
import fr.garage.model.Operation;
import fr.garage.model.Type;
import fr.garage.model.Vehicule;
import fr.garage.service.GaragisteService;
import fr.garage.service.OperationService;
import fr.garage.service.VehiculeService;

public class Application {

	public static void main(String[] args) {
		
		//findAllOperation();
		//findAllGaragiste();
		//findAllVehicule();
		//findByIdOperation();
		//findByIdGaragiste();
		//findByIdVehicule();
		findByImmatriculationVehicule();
		//addOperation();
		//addGaragiste();
		//addVehicule();
		//updateOperation();
		//updateGaragiste();
		//updateVehicule();
		//deleteOperation();
		//deleteGaragiste();
		//deleteVehicule();

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
	
	public static void findAllVehicule() {
		VehiculeService service = new VehiculeService();
		
		List<Vehicule> vehicules = service.findAll();
		
		for (Vehicule p : vehicules) {
			System.out.println(p.getId() + "-" + p.getNom() + "-" +p.getMarque() + "-" + p.getImmatriculation() +"-" + p.getType());
		}
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
			System.out.println("Ce garagiste n'existe pas dans la base de données...");
		}
		
		System.out.println("----------------------");
	}
	
	public static void findByIdVehicule() {
		VehiculeService service = new VehiculeService();
		
		try {
			Vehicule monVehicule = service.findById(2);
			System.out.println(monVehicule.getId() + "-" + monVehicule.getNom() + "-" + monVehicule.getMarque() + "-" + monVehicule.getImmatriculation() +"-" + monVehicule.getType());
		}
		
		catch (IdMustBePositiveException idex) {
			System.out.println("L'identifiant n'est pas strictement > 0 ...");
		}
		
		catch (NoSuchElementException nex) {
			System.out.println("Ce véhicule n'existe pas ...");
		}
	}
	
	private static void findByImmatriculationVehicule() {
		VehiculeService service = new VehiculeService();
		
		try {
			Vehicule monVehicule = service.findByImmatriculation("6515SZ62");
			System.out.println(monVehicule.getId() + "-" + monVehicule.getNom() + "-" + monVehicule.getMarque() + "-" + monVehicule.getImmatriculation() +"-" + monVehicule.getType());
		}
		
		catch (NoSuchElementException nex) {
			System.out.println("Ce véhicule n'existe pas ...");
		}

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
	
	public static void addVehicule() {
		VehiculeService service = new VehiculeService();
		
		try {
			Vehicule monVehicule = new Vehicule();
			monVehicule.setNom("308");
			monVehicule.setMarque("Peugeot");
			monVehicule.setImmatriculation("DF8645FD");
			Type type = Type.valueOf("VOITURE");
			monVehicule.setType(type);
			service.add(monVehicule);
		}
		catch (IdMustBePositiveException idex) {
			System.out.println("L'identifiant n'est pas strictement > 0 ...");
			
		}
		catch (NoSuchElementException nex) {
			System.out.println("Ce véhicule n'existe pas...");
		}
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
	
	public static void updateVehicule() {
		VehiculeService srvVehicule = new VehiculeService();
		Vehicule vehicule = srvVehicule.findById(14);
		vehicule.setNom("VEHICULE UPDATE JAVA");
		Type type = Type.valueOf("CAMION");
		vehicule.setType(type);
		srvVehicule.update(vehicule);
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
			System.out.println("Ce garagiste n'existe pas dans la base de données...");
		}
	}

	public static void deleteVehicule() {
		VehiculeService srvVehicule = new VehiculeService();
		
		try {
			Vehicule vehicule = srvVehicule.findById(14);
			srvVehicule.deleteById(vehicule.getId());
		}
		catch (IdMustBePositiveException idex) {
			System.out.println("L'id n'est pas strictement < 0 ...");;
		}
		catch (NoSuchElementException nex) {
			System.out.println("Ce véhicule n'existe pas dans la base de données...");
		}
		srvVehicule.deleteById(14);
	}
}
