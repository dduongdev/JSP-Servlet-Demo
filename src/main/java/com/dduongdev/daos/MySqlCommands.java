package com.dduongdev.daos;

public class MySqlCommands {
	public static final String USER_SAVE_QUERY = "INSERT INTO users (username, password, created_at) VALUES(?, ?, ?)";
	public static final String USER_FIND_BY_USERNAME_QUERY = "SELECT * FROM users WHERE username = ?";
	public static final String USER_FIND_ALL_QUERY = "SELECT * FROM users";
}
