package fr.garage.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class AbstractDaoHibernate<T> {

	private static EntityManagerFactory emf;
	protected EntityManager em;
	private Class<T> clz;

	public AbstractDaoHibernate(Class<T> clz) {
		this.clz = clz;

		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("GarageUnit");
		}

		this.em = emf.createEntityManager();
	}

	public List<T> findAll() {
		return this.em.createQuery("select e from " + this.clz.getSimpleName() + " e", this.clz).getResultList();
	}

	// public abstract Optional<T> findById(int id);

	public Optional<T> findById(int id) {
		return Optional.ofNullable(this.em.find(this.clz, id));
	}

	public T add(T entity) {
		try {
			// Démarrage de la transaction
			this.em.getTransaction().begin();

			// Persister
			this.em.persist(entity);

			// Commit de la transaction
			this.em.getTransaction().commit();
			return entity;
		} catch (Exception ex) {
			// ex.printStackTrace();
			this.em.getTransaction().rollback();
		}

		return entity;
	}

	public T update(T entity) {
		try {
			// Démarrage de la transaction
			this.em.getTransaction().begin();

			// Sauvegarde
			entity = this.em.merge(entity);

			// Commit de la transaction
			this.em.getTransaction().commit();
		} catch (Exception ex) {
			this.em.getTransaction().rollback();
		}
		return entity;
	}

	public boolean deleteById(int id) {

		// Démarrage de la transaction
		this.em.getTransaction().begin();

		try {
			this.em.remove(this.em.find(this.clz, id));

			// Commit de la transaction
			this.em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			this.em.getTransaction().rollback();
		}
		return true;
	}
}
