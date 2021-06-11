package fr.garage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.garage.dao.ICommandeDao;
import fr.garage.exception.CommandeNotFoundException;
import fr.garage.exception.IdMustBePositiveException;
import fr.garage.model.Commande;

@Service
public class CommandeService {
	
	@Autowired
	private ICommandeDao dao;

	public List<Commande> findAll() {
		return this.dao.findAll();
	}
	
	public Commande findById(int id) {
		if (id <= 0) {
			throw new IdMustBePositiveException();
		}
		
		return this.dao.findById(id).orElseThrow(CommandeNotFoundException::new);
	}
	
	public void add(Commande commande) {
		this.dao.save(commande);
	}
	
	public void update(Commande commande) {
		this.dao.save(commande);
	}
	
	public void deleteById(int id) {
		if (id <= 0) {
			throw new IdMustBePositiveException();
		}
		this.dao.deleteById(id);
	}
}
