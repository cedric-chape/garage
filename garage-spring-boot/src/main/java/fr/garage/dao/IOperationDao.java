package fr.garage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.garage.model.Operation;

public interface IOperationDao extends JpaRepository<Operation, Integer>{

}
