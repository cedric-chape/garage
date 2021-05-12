package fr.garage.dao;

import fr.garage.model.Operation;

public class OperationDaoHibernate extends AbstractDaoHibernate<Operation> implements IOperationDao{

	public OperationDaoHibernate() {
		super(Operation.class);
		// TODO Auto-generated constructor stub
	}

}
