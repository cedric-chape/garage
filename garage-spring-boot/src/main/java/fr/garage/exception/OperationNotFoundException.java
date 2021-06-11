package fr.garage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "L'opération n'existe pas.")
public class OperationNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

}
