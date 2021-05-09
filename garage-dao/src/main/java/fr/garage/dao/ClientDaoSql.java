package fr.garage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.garage.model.Client;
import fr.garage.model.Fidelite;
import fr.garage.model.TypeClient;
import fr.garage.model.Vehicule;

public class ClientDaoSql extends AbstractDaoSql implements IClientDao {

	@Override
	public List<Client> findAll() {
		List<Client> clients = new ArrayList<>();

		try {
			// Selectionner tous les produits
			ResultSet resultSet = this.getResult("SELECT * FROM client");

			// Afficher le libellé de chaque produit
			while (resultSet.next()) {
				Client client = this.map(resultSet);

				clients.add(client);
			}
		}

		catch (SQLException sqle) {
			sqle.printStackTrace(); // TODO : à retirer avant mise en production
		}

		return clients;
	}

	public List<Client> findAllByVehiculeId(int vehiculeId) {
		List<Client> clients = new ArrayList<>();

		try {
			// Selectionner tous les produits
			ResultSet resultSet = this.getResult("SELECT * FROM client WHERE CLI_VEHICULE_ID =" + vehiculeId);

			// Afficher le libellé de chaque produit
			while (resultSet.next()) {
				Client client = this.map(resultSet);

				clients.add(client);
			}
		}

		catch (SQLException sqle) {
			sqle.printStackTrace(); // TODO : à retirer avant mise en production
		}

		return clients;
	}

	public List<Client> findAllByVehicule(Vehicule vehicule) {
		return this.findAllByVehiculeId(vehicule.getId());
	}

	@Override
	public Optional<Client> findById(int id) {
		try {
			// Selectionner tous les produits
			ResultSet resultSet = this.getResult("SELECT * FROM client WHERE CLI_ID = " + id);

			if (resultSet.next()) {

				// Instancier un produit
				Client client = this.map(resultSet);

				return Optional.of(client);
			}
		}

		catch (SQLException sqle) {
			sqle.printStackTrace(); // TODO : à retirer avant mise en production
		}

		return Optional.empty();
		// System.out.println("[bientôt] SELECT * FROM produit WHERE PRO_ID = " + id);

	}

	@Override
	public Client add(Client client) {
		StringBuilder query = new StringBuilder();
		query
			.append("INSERT INTO client(CLI_NOM,")
			.append(" CLI_PRENOM, CLI_RAISON_SOCIALE,")
			.append(" CLI_TYPE, CLI_FIDELITE, CLI_VEHICULE_ID)")
			.append(" VALUES (?, ?, ?, ?, ?, ?)");

		this
			.prepare(query.toString())
			.setParameter(client.getNom())
			.setParameter(client.getPrenom())
			.setParameter(client.getRaisonSociale())
			.setParameter(client.getTypeClient().toString())
			.setParameter(client.getFidelite().toString())
			.setParameter(1)
			.execute();
		
		return client;
	}

	@Override
	public Client update(Client client) {
		StringBuilder query = new StringBuilder();
		query
			.append("UPDATE client SET CLI_NOM = ?,")
			.append(" CLI_PRENOM = ?, CLI_RAISON_SOCIALE = ?,")
			.append(" CLI_TYPE = ?, CLI_FIDELITE = ?, CLI_VEHICULE_ID = ?")
			.append(" WHERE CLI_ID = ?");

		this
			.prepare(query.toString())
			.setParameter(client.getNom())
			.setParameter(client.getPrenom())
			.setParameter(client.getRaisonSociale())
			.setParameter(client.getTypeClient().toString())
			.setParameter(client.getFidelite().toString())
			.setParameter(1)
			.setParameter(client.getId())
			.execute();
		
		return null;
	}

	@Override
	public boolean deleteById(int id) {

		return this
				.prepare("DELETE FROM client WHERE CLI_ID = ?")
				.setParameter(id)
				.execute();
	}

	private Client map(ResultSet resultSet) {
		try {
			// Récupérer les informations
			int id = resultSet.getInt("CLI_ID");
			String nom = resultSet.getString("CLI_NOM");
			String prenom = resultSet.getString("CLI_PRENOM");
			String raisonSociale = resultSet.getString("CLI_RAISON_SOCIALE");
			TypeClient typeClient = TypeClient.valueOf(resultSet.getString("CLI_TYPE"));
			Fidelite fidelite = Fidelite.valueOf(resultSet.getString("CLI_FIDELITE"));
			int vehiculeId = resultSet.getInt("CLI_VEHICULE_ID");
			// Instancier un client, un véhicule
			Client client = new Client();
			Vehicule vehicule = new Vehicule();

			// Affecter ses infos
			client.setId(id);
			client.setNom(nom);
			client.setPrenom(prenom);
			client.setRaisonSociale(raisonSociale);
			client.setTypeClient(typeClient);
			client.setFidelite(fidelite);

			vehicule.setId(vehiculeId);

			// On retourne le client
			return client;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}
}
