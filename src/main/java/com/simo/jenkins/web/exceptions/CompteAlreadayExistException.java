package com.simo.jenkins.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CompteAlreadayExistException extends RuntimeException  {

	public CompteAlreadayExistException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteAlreadayExistException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	

}
