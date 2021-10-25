package com.wecare.Exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class ExceptionControllerAdvice {
@Autowired
private Environment environment;

 @ExceptionHandler(Exception.class)
 public String exceptionHandler(Exception ex)
   {
 
     return environment.getProperty(ExceptionConstants.SERVER_ERROR.toString());
 }
 
 @ExceptionHandler(WecareException.class)
 public ResponseEntity<ErrorMessage> exceptionHandler(WecareException ex)
 {
 ErrorMessage error = new ErrorMessage();
     error.setMessage(ex.getMessage());
     return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
 }

}