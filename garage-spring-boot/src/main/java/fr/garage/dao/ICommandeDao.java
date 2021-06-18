package fr.garage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.garage.model.Commande;
import fr.garage.model.EtatCommande;

public interface ICommandeDao extends JpaRepository<Commande, Integer>{
	
	public List<Commande> findAllByEtatCommandeAndGaragisteId(EtatCommande etatCommande, int garagisteId);
	

}
