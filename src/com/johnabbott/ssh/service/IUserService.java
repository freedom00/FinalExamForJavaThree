package com.johnabbott.ssh.service;

import java.util.List;

import com.johnabbott.ssh.entity.User;

public interface IUserService {

	public List<User> getUsers(); // SELECT

	public User getUser(String email, String password); // SELECT

	public boolean addUser(User user); // INSERT

}
