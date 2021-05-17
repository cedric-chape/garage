package fr.garage.dao;

import fr.garage.model.Commande;

public class CommandeDaoHibernate extends AbstractDaoHibernate<Commande> implements ICommandeDao{

	public CommandeDaoHibernate() {
		super(Commande.class);
	}
}
