package fr.garage.service;

import java.util.List;

import fr.garage.dao.DAOFactory;
import fr.garage.dao.IGaragisteDao;
import fr.garage.exception.IdMustBePositiveException;
import fr.garage.model.Garagiste;

public class GaragisteService {
	private IGaragisteDao dao = DAOFactory.createGaragisteDao();
	
	public List<Garagiste> findAll() {
		return this.dao.findAll();
	}
	
	public Garagiste findById(int id) {
		if (id <= 0) {
			throw new IdMustBePositiveException();
		}
		
		return this.dao.findById(id).orElseThrow();
	}
	
	public void add(Garagiste garagiste) {
		
		this.dao.add(garagiste);
	}
	
	public void update(Garagiste garagiste) {
		
		this.dao.update(garagiste);
	}
	
	public void deleteById(int id) {
		if (id <= 0) {
			throw new IdMustBePositiveException();
		}
		this.dao.deleteById(id);
	}
	
	public Garagiste findByEmail(String email) {
		return this.dao.findByEmail(email).orElseThrow();
	}

}
