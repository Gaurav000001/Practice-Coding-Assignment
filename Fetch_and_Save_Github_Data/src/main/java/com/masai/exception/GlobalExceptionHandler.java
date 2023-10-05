package com.masai.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> exceptionHandler(Exception ex, WebRequest wq) {
		ErrorDetails error = ErrorDetails.builder()
		.message(ex.getLocalizedMessage())
		.uri(wq.getDescription(false))
		.error(HttpStatus.NOT_FOUND.getReasonPhrase())
		.errorCode(HttpStatus.NOT_FOUND.value())
		.build();
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}
