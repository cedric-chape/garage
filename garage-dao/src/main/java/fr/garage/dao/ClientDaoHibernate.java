package fr.garage.dao;

import fr.garage.model.Client;

public class ClientDaoHibernate extends AbstractDaoHibernate<Client> implements IClientDao {

	public ClientDaoHibernate() {
		super(Client.class);
	}

}
