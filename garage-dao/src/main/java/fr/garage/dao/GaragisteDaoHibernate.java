package fr.garage.dao;

import fr.garage.model.Garagiste;

public class GaragisteDaoHibernate extends AbstractDaoHibernate<Garagiste> implements IGaragisteDao{

	public GaragisteDaoHibernate() {
		super(Garagiste.class);
	}

}
