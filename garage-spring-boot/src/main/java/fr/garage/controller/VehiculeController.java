package fr.garage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.garage.service.VehiculeService;

@Controller
public class VehiculeController {

	@Autowired
	private VehiculeService srvVehicule;
}
