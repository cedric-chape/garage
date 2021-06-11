package fr.garage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.garage.model.CommandeDetail;
import fr.garage.model.CommandeDetailId;

public interface ICommandeDetailDao extends JpaRepository<CommandeDetail, CommandeDetailId>{

}
