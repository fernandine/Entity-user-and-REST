package com.curso.workshopmongo.resources.exception;


import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.curso.workshopmongo.services.exception.ObjectNotFoundException;

public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandError err = new StandError(System.currentTimeMillis(),status.value(),"Não encontrado!",e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
