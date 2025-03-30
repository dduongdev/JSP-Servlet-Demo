package com.dduongdev.daos;

import java.util.List;
import java.util.Optional;

import com.dduongdev.entities.User;

public interface UserDao {
	Optional<User> findByUsername(String username);
	void save(User user);
}
