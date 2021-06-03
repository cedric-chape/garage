package fr.garage.dao;

import java.util.Optional;

import fr.garage.model.Garagiste;

public class GaragisteDaoHibernate extends AbstractDaoHibernate<Garagiste> implements IGaragisteDao {

	public GaragisteDaoHibernate() {
		super(Garagiste.class);
	}

	public Optional<Garagiste> findByEmail(String email) {

		return Optional.ofNullable(
				this.em.createQuery("select g from Garagiste g where GAR_EMAIL='" + email + "'", Garagiste.class)
						.getSingleResult());
	}

}
