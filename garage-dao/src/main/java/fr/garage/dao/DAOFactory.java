package fr.garage.dao;

public class DAOFactory {
	public static IOperationDao createOperationDao() {
		return new OperationDaoSql();
	}
	

}
