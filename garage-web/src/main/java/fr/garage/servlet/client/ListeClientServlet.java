package fr.garage.servlet.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.garage.model.Client;
import fr.garage.service.ClientService;

@WebServlet("/liste-client")
public class ListeClientServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ClientService srvClient = new ClientService();

		// On récupère la liste des clients
		List<Client> clients = srvClient.findAll();

		// On ajoute la liste au scope Request
		req.setAttribute("clients", clients);

		// On délègue
		this.getServletContext().getRequestDispatcher("/WEB-INF/liste-client.jsp").forward(req, resp);
	}
}
