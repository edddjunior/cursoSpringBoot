package com.example.demo.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.example.demo.domain.User;

public class UserService {

	public static User authenticated() {
		try {
			return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}
}
