package fr.garage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestHibernateApplication {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("GarageUnit");

		// R�cup�rer un EntityManager
		EntityManager em = emf.createEntityManager();
	}

}
