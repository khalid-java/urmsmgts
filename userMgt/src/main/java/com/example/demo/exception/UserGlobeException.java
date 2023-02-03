package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserGlobeException {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> exception() {
		return new ResponseEntity<Object>("User Id is not Present", HttpStatus.CHECKPOINT);
	}

}
