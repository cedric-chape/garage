package fr.garage.dao;

public class DAOFactory {
	public static IOperationDao createOperationDao() {
		return new OperationDaoSql();
	}

	public static IGaragisteDao createGaragisteDao() {
		return new GaragisteDaoSql();
	}

	public static IVehicule createVehiculeDao() {
		return new VehiculeDaoSql();
	}

	public static IClientDao createClientDao() {
		return new ClientDaoSql();
	}

}
