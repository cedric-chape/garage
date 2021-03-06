package fr.garage;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.NoSuchElementException;

import com.google.common.hash.Hashing;

import fr.garage.exception.IdMustBePositiveException;
import fr.garage.model.Client;
import fr.garage.model.Commande;
import fr.garage.model.CommandeDetail;
import fr.garage.model.Fidelite;
import fr.garage.model.Garagiste;
import fr.garage.model.Operation;
import fr.garage.model.Type;
import fr.garage.model.TypeClient;
import fr.garage.model.TypeRole;
import fr.garage.model.Vehicule;
import fr.garage.service.ClientService;
import fr.garage.service.CommandeDetailService;
import fr.garage.service.CommandeService;
import fr.garage.service.GaragisteService;
import fr.garage.service.OperationService;
import fr.garage.service.VehiculeService;

public class Application {

	public static void main(String[] args) {
		
		// findAllOperation();
		// findAllGaragiste();
		// findAllVehicule();
		// findAllClient();
		//findAllCommande();
		//findAllCommandeDetail();
		// findByIdOperation();
		// findByIdGaragiste();
		// findByIdVehicule();
		// findByIdClient();
		// findByImmatriculationVehicule();
		// addOperation();
		 //addGaragiste();
		 //addVehicule();
		 //addClient();
		// updateOperation();
		// updateGaragiste();
		// updateVehicule();
		// updateClient();
		// deleteOperation();
		// deleteGaragiste();
		 deleteVehicule();
		// deleteClient();

	}

	public static void findAllOperation() {
		// test findAll()
		OperationService service = new OperationService();

		List<Operation> operations = service.findAll();

		for (Operation o : operations) {
			System.out
					.println(o.getId() + " " + o.getLibelle() + " " + o.getPrixUnitaire() + "? " + o.getDescription());
		}

		System.out.println("----------------------");
	}
	
	public static void findAllCommandeDetail() {
		CommandeDetailService service = new CommandeDetailService();
		
		List<CommandeDetail> details = service.findAll();
		
		for (CommandeDetail cd : details) {
			System.out.println(cd.getId());
		}
	}

	public static void findAllGaragiste() {
		// test findAll()
		GaragisteService service = new GaragisteService();

		List<Garagiste> garagistes = service.findAll();

		for (Garagiste g : garagistes) {
			System.out.println(g.getId() + " " + g.getNom() + " " + g.getPrenom());
		}

		System.out.println("----------------------");
	}

	public static void findAllVehicule() {
		VehiculeService service = new VehiculeService();

		List<Vehicule> vehicules = service.findAll();

		for (Vehicule p : vehicules) {
			System.out.println(p.getId() + "-" + p.getNom() + "-" + p.getMarque() + "-" + p.getImmatriculation() + "-"
					+ p.getType());
		}
	}

	public static void findAllClient() {
		ClientService service = new ClientService();
		List<Client> clients = service.findAll();

		for (Client c : clients) {
			System.out.println(c.getId() + " - " + c.getNom() + " - " + c.getPrenom() + " - " + c.getRaisonSociale()
					+ " - " + c.getTypeClient() + " - " + c.getFidelite() + " - " + c.getVehicules());
		}
	}

	public static void findAllCommande() {
		CommandeService service = new CommandeService();
		List<Commande> commandes = service.findAll();

		for (Commande c : commandes) {
			System.out.println(c.getId() + " - " + c.getClient().getNom());
		}
	}

	public static void findByIdOperation() {
		OperationService service = new OperationService();

		// test findById(int id)
		try {
			Operation operation = service.findById(10);
			System.out.println(operation.getId() + " " + operation.getLibelle());
		}

		catch (IdMustBePositiveException idex) {
			System.out.println("L'id n'est pas strictement > 0... ");
		}

		catch (NoSuchElementException nseex) {
			System.out.println("Cette op?ration n'existe pas dans la base de donn?es...");
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
			System.out.println("Ce garagiste n'existe pas dans la base de donn?es...");
		}

		System.out.println("----------------------");
	}

	public static void findByIdVehicule() {
		VehiculeService service = new VehiculeService();

		try {
			Vehicule monVehicule = service.findById(2);
			System.out.println(monVehicule.getId() + "-" + monVehicule.getNom() + "-" + monVehicule.getMarque() + "-"
					+ monVehicule.getImmatriculation() + "-" + monVehicule.getType());
		}

		catch (IdMustBePositiveException idex) {
			System.out.println("L'identifiant n'est pas strictement > 0 ...");
		}

		catch (NoSuchElementException nex) {
			System.out.println("Ce v?hicule n'existe pas ...");
		}
	}

	public static void findByIdClient() {
		ClientService service = new ClientService();

		// test findById(int id)
		try {
			Client client = service.findById(10);
			System.out.println(client.getId() + " " + client.getNom() + " " + client.getPrenom());

		}

		catch (IdMustBePositiveException idex) {
			System.out.println("L'id n'est pas strictement > 0... ");
		}

		catch (NoSuchElementException nseex) {
			System.out.println("Cette op?ration n'existe pas dans la base de donn?es...");
		}

		System.out.println("----------------------");
	}

	private static void findByImmatriculationVehicule() {
		VehiculeService service = new VehiculeService();

		try {
			Vehicule monVehicule = service.findByImmatriculation("6515SZ62");
			System.out.println(monVehicule.getId() + "-" + monVehicule.getNom() + "-" + monVehicule.getMarque() + "-"
					+ monVehicule.getImmatriculation() + "-" + monVehicule.getType());
		}

		catch (NoSuchElementException nex) {
			System.out.println("Ce v?hicule n'existe pas ...");
		}

	}

	public static void addOperation() {
		// test addOperation
		OperationService service = new OperationService();

		Operation operation = new Operation();
		operation.setLibelle("Test ajout 2 libell? op?ration");
		operation.setDescription("Test ajout 2 description op?ration");
		operation.setPrixUnitaire(new BigDecimal(500));

		service.add(operation);

		System.out.println("Ajout? !");
	}

	public static void addGaragiste() {
		// test addOperation
		GaragisteService service = new GaragisteService();
		
		String password = "1234";
		String passwordSha256 = Hashing.sha256()
				  .hashString(password, StandardCharsets.UTF_8)
				  .toString();

		Garagiste garagiste = new Garagiste();
		

		
		garagiste.setNom("Chap?");
		garagiste.setPrenom("C?dric");
		garagiste.setEmail("cedric-chape@live.fr");
		garagiste.setPassword(passwordSha256);
		garagiste.setRole(TypeRole.valueOf("ADMIN"));

		service.add(garagiste);
		


		//System.out.println("Ajout? !");
	}

	public static void addVehicule() {
		VehiculeService service = new VehiculeService();

		Client client = new Client();
		client.setId(1);
		Vehicule monVehicule = new Vehicule();
		monVehicule.setNom("308");
		monVehicule.setMarque("Peugeot");
		monVehicule.setImmatriculation("DF8645FD");
		Type type = Type.valueOf("VOITURE");
		monVehicule.setType(type);
		monVehicule.setClient(client);
		service.add(monVehicule);
	}

	public static void addClient() {
		ClientService service = new ClientService();

		Client monClient = new Client();
		monClient.setNom("Pir?s");
		monClient.setPrenom("Robert");
		monClient.setTypeClient(TypeClient.PARTICULIER);
		monClient.setFidelite(Fidelite.CLASSIQUE);

		// monClient.setVehicule(null);
		service.add(monClient);
	}

	public static void updateOperation() {
		OperationService service = new OperationService();

		// On r?cup?re l'op?ration
		Operation operation = service.findById(17);

		// On modifie le libell?
		operation.setLibelle("R??dition du libell? op?ration");

		// Sauvegarde de l'operation
		service.update(operation);

		System.out.println("Mis ? jour !");
	}

	public static void updateGaragiste() {
		GaragisteService service = new GaragisteService();

		// On r?cup?re l'op?ration
		Garagiste garagiste = service.findById(6);

		// On modifie le libell?
		garagiste.setNom("R??dition du nom garagiste");

		// Sauvegarde de l'operation
		service.update(garagiste);

		System.out.println("Mis ? jour !");
	}

	public static void updateVehicule() {
		VehiculeService srvVehicule = new VehiculeService();
		ClientService srvClient = new ClientService();

		for (int i = 1; i < 11; i++) {
			Client client = srvClient.findById(i);
			Vehicule vehicule = srvVehicule.findById(i);
			vehicule.setClient(client);
			srvVehicule.update(vehicule);
		}
//		Client client = srvClient.findById(1);
//		Vehicule vehicule = srvVehicule.findById(1);
//		vehicule.setClient(client);
//		srvVehicule.update(vehicule);
	}

	public static void updateClient() {
		ClientService service = new ClientService();
		Client client = service.findById(11);
		client.setNom("UPDATE PAR JAVA");
		service.update(client);
	}

	public static void deleteOperation() {
		OperationService service = new OperationService();

		try {
			Operation operation = service.findById(17);
			service.deleteById(operation.getId());

			System.out.println("Supprim? !");
		}

		catch (IdMustBePositiveException idex) {
			System.out.println("L'id n'est pas strictement > 0... ");
		}

		catch (NoSuchElementException nseex) {
			System.out.println("Cette op?ration n'existe pas dans la base de donn?es...");
		}
	}

	public static void deleteGaragiste() {
		GaragisteService service = new GaragisteService();

		try {
			Garagiste garagiste = service.findById(6);
			service.deleteById(garagiste.getId());

			System.out.println("Supprim? !");
		}

		catch (IdMustBePositiveException idex) {
			System.out.println("L'id n'est pas strictement > 0... ");
		}

		catch (NoSuchElementException nseex) {
			System.out.println("Ce garagiste n'existe pas dans la base de donn?es...");
		}
	}

	public static void deleteVehicule() {
		VehiculeService srvVehicule = new VehiculeService();

		try {
			Vehicule vehicule = srvVehicule.findById(3);
			srvVehicule.deleteById(vehicule.getId());
		} catch (IdMustBePositiveException idex) {
			System.out.println("L'id n'est pas strictement < 0 ...");
			
		} catch (NoSuchElementException nex) {
			System.out.println("Ce v?hicule n'existe pas dans la base de donn?es...");
		}
		//srvVehicule.deleteById(2);
	}

	public static void deleteClient() {
		ClientService service = new ClientService();

		try {
			Client client = service.findById(11);
			service.deleteById(client.getId());

			System.out.println("Supprim? !");
		}

		catch (IdMustBePositiveException idex) {
			System.out.println("L'id n'est pas strictement > 0... ");
		}

		catch (NoSuchElementException nseex) {
			System.out.println("Ce garagiste n'existe pas dans la base de donn?es...");
		}
	}
}
