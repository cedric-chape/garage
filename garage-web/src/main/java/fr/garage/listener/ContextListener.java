package fr.garage.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import fr.garage.service.ClientService;
import fr.garage.service.CommandeDetailService;
import fr.garage.service.CommandeService;
import fr.garage.service.GaragisteService;
import fr.garage.service.OperationService;
import fr.garage.service.VehiculeService;

public class ContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		new ClientService();
		new CommandeDetailService();
		new CommandeService();
		new GaragisteService();
		new OperationService();
		new VehiculeService();
	}

}
