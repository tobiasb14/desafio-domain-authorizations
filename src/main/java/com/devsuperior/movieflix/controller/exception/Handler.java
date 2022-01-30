package com.devsuperior.movieflix.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Handler {
	
	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<OauthCustomError> unauthourized(UnauthorizedException e) {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new OauthCustomError("unauthourized", e.getMessage()));
	}
}
