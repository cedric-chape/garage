package fr.garage.service;

import java.util.List;

import fr.garage.dao.DAOFactory;
import fr.garage.dao.ICommandeDetailDao;
import fr.garage.exception.IdMustBePositiveException;
import fr.garage.model.CommandeDetail;

public class CommandeDetailService {

	private ICommandeDetailDao dao = DAOFactory.createCommandeDetail();

	public List<CommandeDetail> findAll() {
		return this.dao.findAll();
	}

	public CommandeDetail findById(int id) {
		if (id <= 0) {
			throw new IdMustBePositiveException();
		}

		return this.dao.findById(id).orElseThrow();
	}

	public void add(CommandeDetail commandeDetail) {
		this.dao.add(commandeDetail);
	}

	public void update(CommandeDetail commandeDetail) {
		this.dao.update(commandeDetail);
	}

	public void deleteById(int id) {
		if (id <= 0) {
			throw new IdMustBePositiveException();
		}
		this.dao.deleteById(id);
	}
}
