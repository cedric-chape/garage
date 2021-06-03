package fr.garage.servlet.vehicule;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.garage.dao.CantDeleteRuntimeException;
import fr.garage.service.VehiculeService;

@WebServlet("/supprimer-vehicule")


public class SupprimerVehiculeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//On récupère le paramètre identifiant fournisseur
		String vehiculeIdString = req.getParameter("id");
		int vehiculeId = Integer.parseInt(vehiculeIdString);
		VehiculeService srvVehicule = new VehiculeService();
		
		
		//On supprime ....
		try {
		srvVehicule.deleteById(vehiculeId);
		resp.sendRedirect("liste-vehicule?vehiculeSupprime=true");
		}
		catch(CantDeleteRuntimeException cdre){
			
			resp.sendRedirect("liste-vehicule?vehiculeSupprime=false");
		}
		
		
		//On redirige vers la page de liste des fournisseurs (avec un message de confirmation, solution #2)
		
	}
}