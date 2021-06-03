package fr.garage.servlet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.hash.Hashing;

import fr.garage.model.Garagiste;
import fr.garage.service.GaragisteService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		this.getServletContext() // -> récupérer le contexte de Servlet
				.getRequestDispatcher("/WEB-INF/login.jsp") // -> récupérer le dispatcher
				.forward(req, resp); // -> transfert de la requete et réponse HTTP
		
		req.getSession().setAttribute("errorLogin", null);
	}

	// Traitement de la connexion
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		String passwordEncrypted = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();

		// On vérifie si l'email est en BDD
		GaragisteService serviceGar = new GaragisteService();
		Garagiste garagiste = serviceGar.findByEmail(email);

		if (garagiste.getEmail().equals(email) && garagiste.getPassword().equals(passwordEncrypted)) {
			req.getSession().setAttribute("sessionUser", email);
			resp.sendRedirect("home");
		} else {
			req.getSession().setAttribute("errorLogin", true);
			resp.sendRedirect("login");
		}
	}
}
