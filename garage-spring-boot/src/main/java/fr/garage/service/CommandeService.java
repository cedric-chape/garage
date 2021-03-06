package fr.garage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.garage.dao.ICommandeDao;
import fr.garage.exception.CommandeNotFoundException;
import fr.garage.exception.IdMustBePositiveException;
import fr.garage.model.Commande;
import fr.garage.model.EtatCommande;

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
	
	public List<Commande> findAllByEtatCommandeAndGaragisteId(EtatCommande etatCommande, int garagisteId) {
		return this.dao.findAllByEtatCommandeAndGaragisteId(etatCommande, garagisteId);
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
