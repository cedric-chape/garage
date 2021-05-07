package fr.garage.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.garage.model.Operation;

public class OperationDaoSql extends AbstractDaoSql implements IOperationDao{

	public List<Operation> findAll() {
		
		List<Operation> operations = new ArrayList<>();
		try {
			ResultSet resultSet = this.getResult("SELECT * FROM operation");
			
			while (resultSet.next()) {
				Operation operation = this.map(resultSet);
				
				operations.add(operation);
			}
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return operations;
	}

	public Optional<Operation> findById(int id) {
		try {
			ResultSet resultSet = this.getResult("SELECT * FROM operation WHERE OPE_ID = " + id);

			if (resultSet.next()) {
				Operation operation = this.map(resultSet); 
				
				return Optional.of(operation);
			}
			
			
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
			
		}
		return Optional.empty();
	}

	public Operation add(Operation operation) {
		this
			.prepare("INSERT INTO OPERATION (OPE_LIBELLE, OPE_DESCRIPTION, OPE_PRIX_UNITAIRE) VALUES (?, ?, ?)")
			.setParameter(operation.getLibelle())
			.setParameter(operation.getDescription())
			.setParameter(operation.getPrixUnitaire())
			.execute();
		return operation;
	}

	public Operation update(Operation operation) {
		StringBuilder query = new StringBuilder();
		query
			.append("UPDATE operation SET OPE_LIBELLE = ?,")
			.append(" OPE_DESCRIPTION = ?,")
			.append(" OPE_PRIX_UNITAIRE = ?")
			.append(" WHERE OPE_ID = ?");
		
		this
			.prepare(query.toString())
			.setParameter(operation.getLibelle())
			.setParameter(operation.getDescription())
			.setParameter(operation.getPrixUnitaire())
			.setParameter(operation.getId())
			.execute();
		return null;
	}

	public boolean deleteById(int id) {
		return this
		.prepare("DELETE FROM operation WHERE OPE_ID = ?")
		.setParameter(id)
	
		.execute();
	}
	
	private Operation map(ResultSet resultSet) {
		try {
			// Récupérer les informations
			int id = resultSet.getInt("OPE_ID");
			String libelle = resultSet.getString("OPE_LIBELLE");
			String description = resultSet.getString("OPE_DESCRIPTION");
			BigDecimal prixUnitaire = resultSet.getBigDecimal("OPE_PRIX_UNITAIRE");
			
			// Instancier un produit, une catégorie, un fournisseur
			Operation operation = new Operation();
			
			// Affecter ses infos
			operation.setId(id);
			operation.setLibelle(libelle);
			operation.setDescription(description);
			operation.setPrixUnitaire(prixUnitaire);
			
			// On retourne le produit
			return operation;
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}

}
