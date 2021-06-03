package fr.garage.servlet.garagiste;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.garage.service.GaragisteService;

@WebServlet("/supprimer-garagiste")
public class SupprimerGaragisteServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int garagisteId = Integer.parseInt(req.getParameter("id"));
		
		GaragisteService serviceGar = new GaragisteService();
		serviceGar.deleteById(garagisteId);
		
		req.getSession().setAttribute("garagisteSupprime", true);
		resp.sendRedirect("liste-garagiste");
	}

}
