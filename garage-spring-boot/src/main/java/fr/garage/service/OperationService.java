package fr.garage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.garage.dao.IOperationDao;
import fr.garage.exception.IdMustBePositiveException;
import fr.garage.exception.OperationNotFoundException;
import fr.garage.model.Operation;

@Service
public class OperationService {
	@Autowired
	private IOperationDao dao;

	public List<Operation> findAll() {
		return this.dao.findAll();
	}
	
	public Operation findById(int id) {
		if (id <= 0) {
			throw new IdMustBePositiveException();
		}
		
		return this.dao.findById(id).orElseThrow(OperationNotFoundException::new);
	}
	
	public void add(Operation operation) {
		
		this.dao.save(operation);
	}
	
	public void update(Operation operation) {
		
		this.dao.save(operation);
	}
	
	public void deleteById(int id) {
		if (id <= 0) {
			throw new IdMustBePositiveException();
		}
		this.dao.deleteById(id);
	}
	
	
}
