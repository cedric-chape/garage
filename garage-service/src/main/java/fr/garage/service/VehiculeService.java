package fr.garage.service;

import java.util.List;

import fr.garage.dao.DAOFactory;
import fr.garage.dao.IVehicule;
import fr.garage.exception.IdMustBePositiveException;
import fr.garage.model.Vehicule;

public class VehiculeService {
	
	private IVehicule dao = DAOFactory.createVehiculeDao();
	
	public List<Vehicule> findAll() {
		return this.dao.findAll();
	}
	
	public Vehicule findById(int id) {
		if (id <= 0) {
			throw new IdMustBePositiveException();
		}
			
		return this.dao.findById(id).orElseThrow();
	}
	
	public Vehicule findByImmatriculation(String immatriculation) {
			
		return this.dao.findByImmatriculation(immatriculation).orElseThrow();
	}
	
	
	public void update(Vehicule vehicule) {
		this.dao.update(vehicule);
	}
	
	public void add(Vehicule vehicule) {
		this.dao.add(vehicule);
	}

	public void deleteById(int id) {
		if (id <= 0) {
			throw new IdMustBePositiveException();
		}
		this.dao.deleteById(id);
	}
}
