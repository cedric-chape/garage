package fr.garage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.garage.model.Client;

public interface IClientDao extends JpaRepository<Client, Integer>{

}
