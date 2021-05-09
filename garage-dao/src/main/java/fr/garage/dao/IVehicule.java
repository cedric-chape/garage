package fr.garage.dao;

import java.util.Optional;

import fr.garage.model.Vehicule;

public interface IVehicule extends IDAO<Vehicule> {
	public Optional<Vehicule> findByImmatriculation(String immatriculation);
}
