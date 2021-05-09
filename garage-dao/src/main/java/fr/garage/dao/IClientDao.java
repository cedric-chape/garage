package fr.garage.dao;

import java.util.List;

import fr.garage.model.Client;
import fr.garage.model.Vehicule;

public interface IClientDao extends IDAO<Client>{
	public List<Client> findAllByVehiculeId(int vehiculeId);
	public List<Client> findAllByVehicule(Vehicule vehicule);
}
