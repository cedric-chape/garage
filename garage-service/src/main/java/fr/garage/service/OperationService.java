package fr.garage.service;

import java.util.List;

import fr.garage.dao.DAOFactory;
import fr.garage.dao.IOperationDao;
import fr.garage.exception.IdMustBePositiveException;
import fr.garage.model.Operation;

public class OperationService {
	private IOperationDao dao = DAOFactory.createOperationDao();

	public List<Operation> findAll() {
		return this.dao.findAll();
	}
	
	public Operation findById(int id) {
		if (id <= 0) {
			throw new IdMustBePositiveException();
		}
		
		return this.dao.findById(id).orElseThrow();
	}
	
	public void add(Operation operation) {
		
		this.dao.add(operation);
	}
	
	public void update(Operation operation) {
		
		this.dao.update(operation);
	}
	
	public void deleteById(int id) {
		if (id <= 0) {
			throw new IdMustBePositiveException();
		}
		this.dao.deleteById(id);
	}
	
	
}
