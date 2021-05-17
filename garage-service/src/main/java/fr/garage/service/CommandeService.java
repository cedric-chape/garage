package fr.garage.service;

import java.util.List;

import fr.garage.dao.DAOFactory;
import fr.garage.dao.ICommandeDao;
import fr.garage.exception.IdMustBePositiveException;
import fr.garage.model.Commande;

public class CommandeService {
	
	private ICommandeDao dao = DAOFactory.createCommandeDao();

	public List<Commande> findAll() {
		return this.dao.findAll();
	}
	
	public Commande findById(int id) {
		if (id <= 0) {
			throw new IdMustBePositiveException();
		}
		
		return this.dao.findById(id).orElseThrow();
	}
	
	public void add(Commande commande) {
		this.dao.add(commande);
	}
	
	public void update(Commande commande) {
		this.dao.update(commande);
	}
	
	public void deleteById(int id) {
		if (id <= 0) {
			throw new IdMustBePositiveException();
		}
		this.dao.deleteById(id);
	}
}
