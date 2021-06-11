package fr.garage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.garage.model.Garagiste;

public interface IGaragisteDao extends JpaRepository<Garagiste, Integer>{

}
