package fr.garage.servlet.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.garage.service.ClientService;

@WebServlet("/supprimer-client")
public class SupprimerClientServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String clientIdString = req.getParameter("id");
		int clientId = Integer.parseInt(clientIdString);
		ClientService srvClient = new ClientService();
		
		srvClient.deleteById(clientId);
		resp.sendRedirect("liste-client?clientSupprime=true");
	}
	
	
}
