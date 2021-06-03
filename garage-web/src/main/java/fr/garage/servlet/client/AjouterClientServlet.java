package fr.garage.servlet.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.garage.model.Client;
import fr.garage.model.Fidelite;
import fr.garage.model.TypeClient;
import fr.garage.service.ClientService;
import fr.garage.service.VehiculeService;

@WebServlet("/ajouter-client")
public class AjouterClientServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		ClientService srvClient = new ClientService();
		VehiculeService srvVehicule = new VehiculeService();
		
		req.setAttribute("clients", srvClient.findAll());
		req.setAttribute("vehicules", srvVehicule.findAll());
		
		this 
			.getServletContext()
			.getRequestDispatcher("/WEB-INF/form-client.jsp")
			.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		String raisonSociale = req.getParameter("raisonSociale");
		String typeO = req.getParameter("type");
		String fideliteO = req.getParameter("fidelite");
		TypeClient type = TypeClient.valueOf(typeO);
		Fidelite fidelite = Fidelite.valueOf(fideliteO);
		
		
		Client client = new Client();
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setRaisonSociale(raisonSociale);
		client.setTypeClient(type);
		client.setFidelite(fidelite);
		
		ClientService srvClient = new ClientService();
		srvClient.add(client);
		
		resp.sendRedirect("liste-client?clientAjout=true");
	}
}
