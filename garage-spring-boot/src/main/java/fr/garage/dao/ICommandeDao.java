package fr.garage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.garage.model.Commande;

public interface ICommandeDao extends JpaRepository<Commande, Integer>{

}
