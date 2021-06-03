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

@WebServlet("/modifier-client")
public class ModifierClientServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		ClientService srvClient = new ClientService();

		req.setAttribute("client", srvClient.findById(id));

		this
			.getServletContext()
			.getRequestDispatcher("/WEB-INF/form-client.jsp")
			.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int clientId =  Integer.parseInt(req.getParameter("id"));
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		String raisonSociale = req.getParameter("raisonSociale");
		String typeO = req.getParameter("type");
		String fideliteO = req.getParameter("fidelite");
		TypeClient type = TypeClient.valueOf(typeO);
		Fidelite fidelite = Fidelite.valueOf(fideliteO);
		
		Client client = new Client();
		client.setId(clientId);
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setRaisonSociale(raisonSociale);
		client.setTypeClient(type);
		client.setFidelite(fidelite);
		
		ClientService srvClient = new ClientService();
		srvClient.update(client);
		
		resp.sendRedirect("liste-client?clientModifie=true");
	}
}
