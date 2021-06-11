package fr.garage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.garage.dao.IClientDao;
import fr.garage.exception.ClientNotFoundException;
import fr.garage.exception.IdMustBePositiveException;
import fr.garage.model.Client;

@Service
public class ClientService {

	@Autowired
	private IClientDao dao;

	public List<Client> findAll() {
		return this.dao.findAll();
	}

	public Client findById(int id) {
		if (id <= 0) {
			throw new IdMustBePositiveException();
		}

		return this.dao.findById(id).orElseThrow(ClientNotFoundException::new);
	}

	public void add(Client client) {
		this.dao.save(client);
	}

	public void update(Client client) {
		this.dao.save(client);
	}

	public void deleteById(int id) {
		if (id <= 0) {
			throw new IdMustBePositiveException();
		}
		this.dao.deleteById(id);
	}
}
