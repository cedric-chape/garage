package fr.garage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.garage.model.Vehicule;

public interface IVehiculeDao extends JpaRepository<Vehicule, Integer>{

	List<Vehicule> findAllByClientId(int id);

}
