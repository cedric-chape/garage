package fr.garage.servlet.vehicule;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.garage.model.Client;
import fr.garage.model.Type;
import fr.garage.model.Vehicule;
import fr.garage.service.ClientService;
import fr.garage.service.VehiculeService;

@WebServlet("/modifier-vehicule")
public class ModifierVehiculeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Récupérer l'id vehicule
		String vehiculeIdString = req.getParameter("id");
		int vehiculeId = Integer.parseInt(vehiculeIdString);
		
		//Récupérer le vehicule
		VehiculeService srvVehicule = new VehiculeService();
		Vehicule monVehicule = srvVehicule.findById(vehiculeId);
		
		//Récupérer les clients
		ClientService srvClient = new ClientService();
		List<Client> mesClients = srvClient.findAll();
		
		//Injecter dans le scope request
		//req.setAttribute("vehicules", monVehicule);
		req.setAttribute("clients", mesClients);
		req.setAttribute("vehicule", monVehicule);
		
		//Déléguer vers la vue
		this.getServletContext()
			.getRequestDispatcher("/WEB-INF/form-vehicule.jsp")
			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//On récupère les paramètres
		String vehiculeIdString = req.getParameter("id");
		int vehiculeId = Integer.parseInt(vehiculeIdString);
		String marque = req.getParameter("marque");
		String clientIdString = req.getParameter("clientId");
		int clientId = Integer.parseInt(clientIdString);
		String nom = req.getParameter("nom");
		String immatriculation = req.getParameter("immatriculation");
		String typeString = req.getParameter("type");
		Type type = Type.valueOf(typeString);
		
		//Solution #1 pour l'association
		Client monClient = new Client();
		monClient.setId(clientId);
		
		
		//On constitue le vehicule
		Vehicule monVehicule = new Vehicule();
		monVehicule.setMarque(marque);
		monVehicule.setNom(nom);
		monVehicule.setImmatriculation(immatriculation);
		monVehicule.setType(type);
		monVehicule.setId(vehiculeId); //Important sinon Hibernate va en faire un ajout
		monVehicule.setClient(monClient);
		
		//On sauvegarde
		VehiculeService srvVehicule = new VehiculeService();
		srvVehicule.update(monVehicule);
		
		//On redirige vers la liste des produits
		resp.sendRedirect("liste-vehicule?vehiculeModifie=true");
	}
}