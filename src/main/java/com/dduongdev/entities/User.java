package com.dduongdev.entities;

import java.time.LocalDateTime;

public class User {
	private int id;
	private String username;
	private String password;
	private LocalDateTime createdAt;

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public User() {
		super();
		createdAt = LocalDateTime.now();
	}

	public User(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		createdAt = LocalDateTime.now();
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
		createdAt = LocalDateTime.now();
	}

	public User(int id, String username, String password, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.createdAt = createdAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
