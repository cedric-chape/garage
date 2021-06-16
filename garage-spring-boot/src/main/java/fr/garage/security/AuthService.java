package fr.garage.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.garage.dao.IGaragisteDao;
import fr.garage.model.Garagiste;

@Service
public class AuthService implements UserDetailsService{

	@Autowired
	private IGaragisteDao daoGaragiste;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Garagiste garagiste = this
				.daoGaragiste
				.findByEmail(username)
				.orElseThrow(()-> new UsernameNotFoundException("Le garagiste n'existe pas"));
		
		return new UtilisateurPrincipal(garagiste);
	}

}
