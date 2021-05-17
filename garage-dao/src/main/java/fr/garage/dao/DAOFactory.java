package fr.garage.dao;

public class DAOFactory {
	public static IOperationDao createOperationDao() {
		// return new OperationDaoSql();
		return new OperationDaoHibernate();
	}

	public static IGaragisteDao createGaragisteDao() {
		// return new GaragisteDaoSql();
		return new GaragisteDaoHibernate();
	}

	public static IVehicule createVehiculeDao() {
		// return new VehiculeDaoSql();
		return new VehiculeDaoHibernate();
	}

	public static IClientDao createClientDao() {
		// return new ClientDaoSql();
		return new ClientDaoHibernate();
	}

	public static ICommandeDao createCommandeDao() {
		return new CommandeDaoHibernate();
	}

	public static ICommandeDetailDao createCommandeDetail() {
		return new CommandeDetailDaoHibernate();
	}

}
