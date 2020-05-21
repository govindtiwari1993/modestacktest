package com.modestack.assignment.apiassignment.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.modestack.assignment.apiassignment.user.UserNotFoundException;

//for comman exception
@ControllerAdvice
@RestController
public class CustomizedResponseEntityException extends 
ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
		// TODO Auto-generated method stub
		ExceptionResponse exceptionResponse =
				new ExceptionResponse(new Date(), ex.getMessage(),request.getDescription(false));
	
		return new ResponseEntity(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	protected ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) {
		// TODO Auto-generated method stub
		ExceptionResponse exceptionResponse =
				new ExceptionResponse(new Date(), ex.getMessage(),request.getDescription(false));
	
		return new ResponseEntity(exceptionResponse,HttpStatus.NOT_FOUND);
	}

	
	
	

}
