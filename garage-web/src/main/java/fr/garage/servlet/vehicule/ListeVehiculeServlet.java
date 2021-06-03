package fr.garage.servlet.vehicule;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.garage.service.VehiculeService;



@WebServlet("/liste-vehicule")
public class ListeVehiculeServlet extends HttpServlet {
	
	public ListeVehiculeServlet() {
		System.out.println("CREATION Liste Vehicule");
		}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		VehiculeService srvVehicule = new VehiculeService();
		
		//On enregistre la liste de fournisseurs dans le scope Request
		req.setAttribute("vehicules", srvVehicule.findAll());
		
		//On délègue vers la vue
		this.getServletContext()
			.getRequestDispatcher("/WEB-INF/liste-vehicules.jsp")
			.forward(req, resp);
		
		//On supprime ici l'attribut pour le message de confirmation (solution #1)
		req.getSession().setAttribute("vehiculeAjout", null);
	}
}