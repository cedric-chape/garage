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

@WebServlet("/ajouter-garagiste")
public class AjouterGaragisteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/WEB-INF/form-garagiste.jsp").forward(req, resp);

		req.getSession().setAttribute("errors", null);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

			resp.sendRedirect("ajouter-garagiste");
			return;
		}

		// Affectation des infos
		Garagiste garagiste = new Garagiste();

		garagiste.setNom(nom);
		garagiste.setPrenom(prenom);
		garagiste.setEmail(email);
		garagiste.setRole(role);

		// Encryptage du mot de passe
		String passwordEncrypted = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
		garagiste.setPassword(passwordEncrypted);

		GaragisteService serviceGar = new GaragisteService();
		serviceGar.add(garagiste);

		req.getSession().setAttribute("garagisteAjout", true);
		resp.sendRedirect("liste-garagiste");

	}

}
