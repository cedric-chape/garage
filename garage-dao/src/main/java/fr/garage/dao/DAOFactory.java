package fr.garage.dao;

public class DAOFactory {
	public static IOperationDao createOperationDao() {
		return new OperationDaoSql();
	}
	
	public static IGaragisteDao createGaragisteDao() {
		return new GaragisteDaoSql();
	}
	

}
