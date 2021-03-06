package fr.garage.service;

import java.util.List;

import fr.garage.dao.DAOFactory;
import fr.garage.dao.IClientDao;
import fr.garage.exception.IdMustBePositiveException;
import fr.garage.model.Client;

public class ClientService {

	private IClientDao dao = DAOFactory.createClientDao();

	public List<Client> findAll() {
		return this.dao.findAll();
	}

	public Client findById(int id) {
		if (id <= 0) {
			throw new IdMustBePositiveException();
		}

		return this.dao.findById(id).orElseThrow();
	}

	public void add(Client client) {
		this.dao.add(client);
	}

	public void update(Client client) {
		this.dao.update(client);
	}

	public void deleteById(int id) {
		if (id <= 0) {
			throw new IdMustBePositiveException();
		}
		this.dao.deleteById(id);
	}
}
