package fr.garage.dao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.garage.model.CommandeDetail;
import fr.garage.model.CommandeDetailId;

public interface ICommandeDetailDao extends JpaRepository<CommandeDetail, CommandeDetailId>{

	@Query( value = "select sum(cmde_prix_unitaire) from commande_detail where cmde_commande_id = ?1", nativeQuery = true)
	public BigDecimal findPrixTotalCommandeDetail(int id);
}
