package fr.garage.servlet.garagiste;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.garage.service.GaragisteService;

@WebServlet("/liste-garagiste")
public class ListeGaragisteServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		GaragisteService serviceGar =  new GaragisteService();
		
		req.setAttribute("garagistes", serviceGar.findAll());
		
		this 
			.getServletContext()
			.getRequestDispatcher("/WEB-INF/liste-garagiste.jsp")
			.forward(req, resp);
		
		req.getSession().setAttribute("garagisteAjout", null);
		req.getSession().setAttribute("garagisteModifie", null);
		req.getSession().setAttribute("garagisteSupprime", null);
	}

}
