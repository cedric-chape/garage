package fr.garage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.garage.dao.IGaragisteDao;
import fr.garage.exception.GaragisteNotFoundException;
import fr.garage.exception.IdMustBePositiveException;
import fr.garage.model.Garagiste;

@Service
public class GaragisteService {
	
	@Autowired
	private IGaragisteDao dao; 
	
	public List<Garagiste> findAll() {
		return this.dao.findAll();
	}
	
	public Garagiste findById(int id) {
		if (id <= 0) {
			throw new IdMustBePositiveException();
		}
		
		return this.dao.findById(id).orElseThrow(GaragisteNotFoundException::new);
	}
	
	public void add(Garagiste garagiste) {
		
		this.dao.save(garagiste);
	}
	
	public void update(Garagiste garagiste) {
		
		this.dao.save(garagiste);
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
