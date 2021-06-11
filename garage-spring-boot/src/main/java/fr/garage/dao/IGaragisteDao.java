package fr.garage.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.garage.model.Garagiste;

public interface IGaragisteDao extends JpaRepository<Garagiste, Integer>{

	public Optional<Garagiste> findByEmail(String email);
}
