package fr.garage.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDaoSql {
	
	protected static Connection connection;
	
	// constructeur
	public AbstractDaoSql() {
		this.createConnection();
	}
	
	// méthodes
	public void createConnection() {
		
		if (connection == null) {
		
			// Charger le pilote (même si pas obligatoire depuis Java 8)
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}
			catch (ClassNotFoundException e) {
				System.out.println("Chargement du pilote impossible...");
			}
			
			try {
				// Se connecter au serveur
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/garage?serverTimezone=UTC", UserCredentials.UTILISATEUR, UserCredentials.MOTDEPASSE);
				System.out.println("Connexion !");
			}
			
			catch (SQLException sqle) {
				System.out.println("Impossible de se connecter");
			}
		}
	}
	
	public ResultSet getResult(String query) {
		try {
			Statement statement = connection.createStatement();
			return statement.executeQuery(query);
		}
		
		catch (Exception sqle) {
			System.out.println("Impossible d'exécuter la requete");
			return null;
		}
	}
	
	public CustomPreparedStatement prepare(String query) {
		try {
			return new CustomPreparedStatement(connection.prepareStatement(query));
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return null;
	}

}
