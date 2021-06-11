package fr.garage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.garage.dao.IVehiculeDao;
import fr.garage.exception.IdMustBePositiveException;
import fr.garage.exception.VehiculeNotFoundException;
import fr.garage.model.Vehicule;

@Service
public class VehiculeService {
	
	@Autowired
	private IVehiculeDao dao;
	
	public List<Vehicule> findAll() {
		return this.dao.findAll();
	}
	
	public Vehicule findById(int id) {
		if (id <= 0) {
			throw new IdMustBePositiveException();
		}
			
		return this.dao.findById(id).orElseThrow(VehiculeNotFoundException::new);
	}
	
	public void update(Vehicule vehicule) {
		this.dao.save(vehicule);
	}
	
	public void add(Vehicule vehicule) {
		this.dao.save(vehicule);
	}

	public void deleteById(int id) {
		if (id <= 0) {
			throw new IdMustBePositiveException();
		}
		this.dao.deleteById(id);
	}
}
