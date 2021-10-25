package com.infosys.wecare.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {
	
	@ExceptionHandler(CoachIdNotExist.class)
	public ResponseEntity<ErrorMessage> exceptionHandler2(CoachIdNotExist ex) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}
	@ExceptionHandler(Exception.class)
	public String exceptionHandler2(Exception ex) {
		return ex.getMessage();
	}
}
