package fr.garage.servlet.garagiste;

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
import fr.garage.model.TypeRole;
import fr.garage.service.GaragisteService;

@WebServlet("/modifier-garagiste")
public class ModifierGaragisteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int garagisteId = Integer.parseInt(req.getParameter("id"));
		
		GaragisteService serviceGar = new GaragisteService();
		req.setAttribute("garagiste", serviceGar.findById(garagisteId));
		
		this
			.getServletContext()
			.getRequestDispatcher("/WEB-INF/form-garagiste.jsp")
			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int garagisteId = Integer.parseInt(req.getParameter("id"));
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String confirmPassword = req.getParameter("confirmPassword");
		TypeRole role = TypeRole.valueOf(req.getParameter("role"));

		// Vérification du formulaire
		List<String> errors = new ArrayList();

		if (nom.isBlank()) {
			errors.add("Il faut remplir votre nom");
		}
		if (email.isBlank()) {
			errors.add("Il faut remplir votre email");
		}
		if (password.isBlank()) {
			errors.add("Il faut taper votre mot de passe");
		}
		if (!password.equals(confirmPassword)) {
			errors.add("Il faut saisir deux mots de passe identiques");
		}
		if (!errors.isEmpty()) {
			req.getSession().setAttribute("errors", errors);

			resp.sendRedirect("modifier-garagiste?id=" + garagisteId);
			return;
		}
		
		GaragisteService serviceGar = new GaragisteService();
		Garagiste garagiste = serviceGar.findById(garagisteId);
		
		garagiste.setNom(nom);
		garagiste.setPrenom(prenom);
		garagiste.setEmail(email);
		garagiste.setRole(role);

		// Encryptage du mot de passe
		String passwordEncrypted = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
		garagiste.setPassword(passwordEncrypted);
		
		serviceGar.update(garagiste);
		
		req.getSession().setAttribute("garagisteModifie", true);
		
		resp.sendRedirect("liste-garagiste");
	}
}
