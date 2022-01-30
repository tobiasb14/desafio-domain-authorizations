package com.devsuperior.movieflix.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.controller.exception.UnauthorizedException;
import com.devsuperior.movieflix.entity.User;
import com.devsuperior.movieflix.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public User authenticated() {
		try {
			return userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		} catch (Exception e) {
			throw new UnauthorizedException("Usuário Inválido");
		}
	}
}
