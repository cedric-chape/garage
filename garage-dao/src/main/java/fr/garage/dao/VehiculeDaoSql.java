package fr.garage.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.garage.model.Type;
import fr.garage.model.Vehicule;

public class VehiculeDaoSql extends AbstractDaoSql implements IVehicule {

	@Override
	public List<Vehicule> findAll() {
		// TODO Auto-generated method stub
		List<Vehicule> vehicules = new ArrayList<Vehicule>();
		
		try {
			ResultSet resultSet = this.getResult("SELECT * FROM vehicule");
			
			while (resultSet.next()) { 
				int id = resultSet.getInt("VEH_ID");
				String nom = resultSet.getString("VEH_NOM");
				String marque = resultSet.getString("VEH_MARQUE");
				String immatriculation = resultSet.getString("VEH_IMMATRICULATION");
				String type = resultSet.getString("VEH_TYPE");
				Type type1 = Type.valueOf(type);

				Vehicule vehicule = new Vehicule();
				vehicule.setId(id);
				vehicule.setNom(nom);
				vehicule.setMarque(marque);
				vehicule.setImmatriculation(immatriculation);
				vehicule.setType(type1);
				vehicules.add(vehicule);
				}
		}
			catch (SQLException sqle) {
				sqle.printStackTrace(); //TODO : 
			}
		return vehicules;
	}
		
	
	@Override
	public Optional<Vehicule> findById(int id) {
		try {
			ResultSet resultSet = this.getResult("SELECT * FROM vehicule WHERE VEH_ID = " + id);
	
			if (resultSet.next()) {
				Vehicule vehicule = new Vehicule();
				
				String nom = resultSet.getString("VEH_NOM");
				String marque = resultSet.getString("VEH_MARQUE");
				String immatriculation = resultSet.getString("VEH_IMMATRICULATION");
				Type type = Type.valueOf(resultSet.getString("VEH_TYPE"));
				
				vehicule.setId(id);
				vehicule.setNom(nom);
				vehicule.setMarque(marque);
				vehicule.setImmatriculation(immatriculation);
				vehicule.setType(type);
				return Optional.of(vehicule);
			}
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace(); //TODO : 
		}
		
		return Optional.empty();
	}
	
	public Optional<Vehicule> findByImmatriculation(String immatriculation) {
		try {
			ResultSet resultSet = this.getResult("SELECT * FROM vehicule WHERE VEH_IMMATRICULATION = '" + immatriculation + "'");
	
			if (resultSet.next()) {
				Vehicule vehicule = new Vehicule();
				
				int id = resultSet.getInt("VEH_ID");
				String nom = resultSet.getString("VEH_NOM");
				String marque = resultSet.getString("VEH_MARQUE");
				Type type = Type.valueOf(resultSet.getString("VEH_TYPE"));
				
				vehicule.setId(id);
				vehicule.setNom(nom);
				vehicule.setMarque(marque);
				vehicule.setImmatriculation(immatriculation);
				vehicule.setType(type);
				return Optional.of(vehicule);
			}
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace(); //TODO : 
		}
		
		return Optional.empty();
	}

	@Override
	public Vehicule add(Vehicule entity) {
		this
			.prepare("INSERT INTO vehicule (VEH_NOM, VEH_MARQUE, VEH_IMMATRICULATION, VEH_TYPE) VALUES (?, ?, ?, ?)")
			.setParameter(entity.getNom()) 
			.setParameter(entity.getMarque()) 
			.setParameter(entity.getImmatriculation())
			.setParameter(entity.getType().toString())
			.execute();
		
		return entity;
	}

	@Override
	public Vehicule update(Vehicule entity) {
		StringBuilder query = new StringBuilder();
		
		query
			.append("UPDATE vehicule SET VEH_NOM = ?,")
			.append(" VEH_MARQUE = ?,")
			.append(" VEH_IMMATRICULATION = ?,")
			.append(" VEH_TYPE = ?")
			.append(" WHERE VEH_ID = ?");
			
			
		this
			.prepare(query.toString())
			.setParameter(entity.getNom()) 
			.setParameter(entity.getMarque()) 
			.setParameter(entity.getImmatriculation())
			.setParameter(entity.getType().toString())
			.setParameter(entity.getId())
			.execute();
		
		return entity;
	}

	@Override
	public boolean deleteById(int id) {
		return this
			.prepare("DELETE FROM vehicule WHERE VEH_ID = ?")
			.setParameter(id)
			.execute();
	}
	


}
