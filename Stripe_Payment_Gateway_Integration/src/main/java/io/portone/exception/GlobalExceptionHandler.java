package io.portone.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetail> notFoundExceptionHandler(NoHandlerFoundException noHandlerFoundException, WebRequest webRequest){
		MyErrorDetail myErrorDetail= new MyErrorDetail();
		
		myErrorDetail.setTimestamp(LocalDateTime.now());
		myErrorDetail.setMessage(noHandlerFoundException.getMessage());
		myErrorDetail.setDetails(webRequest.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(myErrorDetail, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetail> validationExceptionHandler(MethodArgumentNotValidException methodArgumentNotValidException){
		MyErrorDetail myErrorDetail= new MyErrorDetail();
		
		myErrorDetail.setTimestamp(LocalDateTime.now());
		myErrorDetail.setMessage("Validation error");
		myErrorDetail.setDetails(methodArgumentNotValidException.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<MyErrorDetail>(myErrorDetail, HttpStatus.BAD_GATEWAY);
	}
	
	@ExceptionHandler(PortoneException.class)
	public ResponseEntity<MyErrorDetail> portoneExceptionHandler(PortoneException portoneException, WebRequest webRequest){
		MyErrorDetail myErrorDetail = new MyErrorDetail();
		
		myErrorDetail.setTimestamp(LocalDateTime.now());
		myErrorDetail.setMessage(portoneException.getMessage());
		myErrorDetail.setDetails(webRequest.getDescription(false));
		
		return new ResponseEntity<>(myErrorDetail, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetail> exceptionHandler(Exception exception, WebRequest webRequest){
		MyErrorDetail myErrorDetail = new MyErrorDetail();
		
		myErrorDetail.setTimestamp(LocalDateTime.now());
		myErrorDetail.setMessage(exception.getMessage());
		myErrorDetail.setDetails(webRequest.getDescription(false));
		
		return new ResponseEntity<>(myErrorDetail, HttpStatus.BAD_REQUEST);
	}
}
