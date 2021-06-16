package fr.garage.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import fr.garage.model.Garagiste;

public class UtilisateurPrincipal implements UserDetails{

	private Garagiste garagiste;
	
	public UtilisateurPrincipal(Garagiste garagiste) {
		this.garagiste = garagiste;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		if (this.garagiste.isAdmin()) {
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}
		else {
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		}
		
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return this.garagiste.getPassword();
	}

	@Override
	public String getUsername() {
		
		return this.garagiste.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
