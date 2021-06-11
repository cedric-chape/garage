package fr.garage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.garage.service.ClientService;

@Controller
public class ClientController {

	@Autowired
	private ClientService srvClient;
}
