package com.johnabbott.ssh.dao;

import java.util.List;

import com.johnabbott.ssh.entity.User;

public interface IUserDao {

	public List<User> getUsers(); // SELECT

	public User getUser(String email, String passwrod); // SELECT

	int addUser(User user); // INSERT

}
