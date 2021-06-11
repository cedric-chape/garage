package fr.garage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.garage.service.GaragisteService;

@Controller
public class GaragisteController {

	@Autowired
	private GaragisteService srvGaragiste;
}
