package com.johnabbott.ssh.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.johnabbott.ssh.dao.IUserDao;
import com.johnabbott.ssh.entity.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserDao employeeDao;

	List<User> listUsers;

	public UserServiceImpl() {
		listUsers = new ArrayList<User>();

		listUsers.add(new User(1, "email1", "password1"));
		listUsers.add(new User(2, "email2", "password2"));
		listUsers.add(new User(3, "email3", "password3"));
		listUsers.add(new User(4, "email4", "password4"));
	}

	@Override
	public List<User> getUsers() {
		return employeeDao.getUsers();
	}

	@Override
	public User getUser(String email, String password) {
		return employeeDao.getUser(email, password);
	}

	@Override
	public boolean addUser(User employee) {
		return employeeDao.addUser(employee) > 0;
	}

}
