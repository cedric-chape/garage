package fr.garage.servlet.vehicule;

import java.io.IOException;

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

@WebServlet("/ajouter-vehicule")
public class AjouterVehiculeServlet extends HttpServlet {
	
	public AjouterVehiculeServlet() {
		System.out.println("CREATION Ajout Vehicule");
		}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//VehiculeService srvVehicule = new VehiculeService();
		ClientService srvClient = new ClientService();

		//req.setAttribute("vehicules", srvVehicule.findAll());
		req.setAttribute("clients", srvClient.findAll());
		
		this.getServletContext()
			.getRequestDispatcher("/WEB-INF/form-vehicule.jsp")
			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//On récupère les paramètres
		String marque = req.getParameter("marque");
		String clientIdString = req.getParameter("clientId");
		int clientId = Integer.parseInt(clientIdString);
		String nom = req.getParameter("nom");
		String immatriculation = req.getParameter("immatriculation");
		String typeString = req.getParameter("type");
		Type type = Type.valueOf(typeString);
		
		//On constitue le vehicule
		Vehicule monVehicule = new Vehicule();
		monVehicule.setMarque(marque);
		monVehicule.setNom(nom);
		monVehicule.setImmatriculation(immatriculation);
		monVehicule.setType(type);
		
		//Solution #1 pour l'association
		Client monClient = new Client();
		monClient.setId(clientId);
		monVehicule.setClient(monClient);
		System.out.println(monVehicule);
		//On sauvegarde
		VehiculeService srvVehicule = new VehiculeService();
		System.out.println(srvVehicule);
		srvVehicule.add(monVehicule);
		
		//On redirige vers la liste des produits
		resp.sendRedirect("liste-vehicule?vehiculeAjout=true");
	}
}