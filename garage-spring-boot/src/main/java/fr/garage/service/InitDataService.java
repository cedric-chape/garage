package fr.garage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.garage.dao.IGaragisteDao;
import fr.garage.model.Garagiste;

// Implémentation de CommandLineRunner pour que SPRING BOOT exécute run() au démarrage

//@Service
public class InitDataService implements CommandLineRunner {
	@Autowired
	private IGaragisteDao daoGaragiste;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
		Garagiste admin = new Garagiste();
		Garagiste user = new Garagiste();
		
		admin.setEmail("admin@igc.fr");
		admin.setPassword(this.passwordEncoder.encode("123456"));
		admin.setAdmin(true);
		admin.setNom("Admin");
		
		user.setEmail("user@igc.fr");
		user.setPassword(this.passwordEncoder.encode("123456"));
		user.setAdmin(false);
		user.setNom("User");

		this.daoGaragiste.save(admin);
		this.daoGaragiste.save(user);
	}
}