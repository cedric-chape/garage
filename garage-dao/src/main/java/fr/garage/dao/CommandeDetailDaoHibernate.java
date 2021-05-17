package fr.garage.dao;

import fr.garage.model.CommandeDetail;

public class CommandeDetailDaoHibernate extends AbstractDaoHibernate<CommandeDetail> implements ICommandeDetailDao {
	
	public CommandeDetailDaoHibernate() {
		super(CommandeDetail.class);
	}

}
