package fr.garage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = " Le véhicule n'existe pas ")
public class VehiculeNotFoundException extends RuntimeException{

}
