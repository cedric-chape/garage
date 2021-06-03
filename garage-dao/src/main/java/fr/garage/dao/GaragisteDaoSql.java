package fr.garage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.garage.model.Garagiste;

public class GaragisteDaoSql extends AbstractDaoSql implements IGaragisteDao{

	@Override
	public List<Garagiste> findAll() {
		List<Garagiste> garagistes = new ArrayList<>();
		try {
			ResultSet resultSet = this.getResult("SELECT * FROM garagiste");
			
			while (resultSet.next()) {
				Garagiste garagiste = this.map(resultSet);
				
				garagistes.add(garagiste);
			}
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return garagistes;
	}

	@Override
	public Optional<Garagiste> findById(int id) {
		try {
			ResultSet resultSet = this.getResult("SELECT * FROM garagiste WHERE GAR_ID = " + id);

			if (resultSet.next()) {
				Garagiste garagiste = this.map(resultSet); 
				
				return Optional.of(garagiste);
			}	
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return Optional.empty();
	}

	@Override
	public Garagiste add(Garagiste garagiste) {
		this
			.prepare("INSERT INTO garagiste (GAR_NOM, GAR_PRENOM) VALUES (?, ?)")
			.setParameter(garagiste.getNom())
			.setParameter(garagiste.getPrenom())
			.execute();
		return garagiste;
	}

	@Override
	public Garagiste update(Garagiste garagiste) {
		StringBuilder query = new StringBuilder();
		query
			.append("UPDATE garagiste SET GAR_NOM = ?,")
			.append(" GAR_PRENOM = ?")
			.append(" WHERE GAR_ID = ?");
		
		this
			.prepare(query.toString())
			.setParameter(garagiste.getNom())
			.setParameter(garagiste.getPrenom())
			.setParameter(garagiste.getId())
			.execute();
				
		return null;
	}

	@Override
	public boolean deleteById(int id) {
		return this
				.prepare("DELETE FROM garagiste WHERE GAR_ID = ?")
				.setParameter(id)
				.execute();
	}
	
	private Garagiste map(ResultSet resultSet) {
		try {
			// Récupérer les informations
			int id = resultSet.getInt("GAR_ID");
			String nom = resultSet.getString("GAR_NOM");
			String prenom = resultSet.getString("GAR_PRENOM");
			
			// Instancier un produit, une catégorie, un fournisseur
			Garagiste garagiste = new Garagiste();
			
			// Affecter ses infos
			garagiste.setId(id);
			garagiste.setNom(nom);
			garagiste.setPrenom(prenom);
			
			// On retourne le produit
			return garagiste;
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}

	@Override
	public Optional<Garagiste> findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
