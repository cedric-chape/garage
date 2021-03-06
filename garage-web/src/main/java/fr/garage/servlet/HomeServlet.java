package fr.garage.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.garage.service.GaragisteService;

@WebServlet("/home")
public class HomeServlet extends HttpServlet{
	
	public HomeServlet() {
		System.out.println("CREATION");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GaragisteService serviceGar = new GaragisteService();
		
		req.setAttribute("garagiste", serviceGar.findById(3));
		
		this
			.getServletContext()
			.getRequestDispatcher("/WEB-INF/home.jsp")
			.forward(req, resp);
	}
}
