package com.dduongdev.services;

import org.mindrot.jbcrypt.BCrypt;

import com.dduongdev.daos.MySqlUserDao;
import com.dduongdev.daos.UserDao;
import com.dduongdev.entities.User;

public class AuthServiceImpl implements AuthService {
	private UserDao userDao = new MySqlUserDao();
	
	@Override
	public void signUp(String username, String password) {
		userDao.findByUsername(username)
		.ifPresent(existingUser -> {
			throw new IllegalArgumentException(
					"User with username " + username + " is already exists.");
		});
		
		password = BCrypt.hashpw(password, BCrypt.gensalt(12));
		
		userDao.save(new User(username, password));
	}

}
