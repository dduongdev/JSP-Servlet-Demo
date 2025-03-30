package com.dduongdev.services;

import java.util.Optional;

import com.dduongdev.entities.User;

public interface AuthService {
	void signUp(String username, String password);
	Optional<User> login(String username, String password);
}
