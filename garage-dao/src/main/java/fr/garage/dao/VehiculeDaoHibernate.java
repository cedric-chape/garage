package fr.garage.dao;

import java.util.Optional;

import fr.garage.model.Vehicule;

public class VehiculeDaoHibernate extends AbstractDaoHibernate<Vehicule> implements IVehicule {
	public VehiculeDaoHibernate() {
		super(Vehicule.class);
	}

	@Override
	public Optional<Vehicule> findByImmatriculation(String immatriculation) {
		// TODO Auto-generated method stub
		return null;
	}
}
