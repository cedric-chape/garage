package fr.garage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.garage.dao.ICommandeDetailDao;
import fr.garage.exception.IdMustBePositiveException;
import fr.garage.model.CommandeDetail;
import fr.garage.model.CommandeDetailId;

@Service
public class CommandeDetailService {

	@Autowired
	private ICommandeDetailDao dao;

	public List<CommandeDetail> findAll() {
		return this.dao.findAll();
	}

	public CommandeDetail findById(CommandeDetailId id) {
		/*if (id <= 0) {
			throw new IdMustBePositiveException();
		}*/

		return this.dao.findById(id).orElseThrow();
	}

	public void add(CommandeDetail commandeDetail) {
		this.dao.save(commandeDetail);
	}

	public void update(CommandeDetail commandeDetail) {
		this.dao.save(commandeDetail);
	}

	public void deleteById(CommandeDetailId id) {
		/*if (id <= 0) {
			throw new IdMustBePositiveException();
		}*/
		this.dao.deleteById(id);
	}
}