package fr.garage.dao;

import java.util.Optional;

import fr.garage.model.Garagiste;

public interface IGaragisteDao extends IDAO<Garagiste>{
	public Optional<Garagiste> findByEmail(String email);
}
