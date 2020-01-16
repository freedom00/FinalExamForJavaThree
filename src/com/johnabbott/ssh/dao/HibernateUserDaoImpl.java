package com.johnabbott.ssh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.johnabbott.ssh.entity.User;

@Repository
public class HibernateUserDaoImpl implements IUserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
//		sessionFactory.getCurrentSession().save(user.getAddress());
//		sessionFactory.getCurrentSession().save(user.getTeacher());
		return 1;
	}

	@Override
	public List<User> getUsers() {
		return getSession().createQuery("from User", User.class).list();
	}

	@Override
	public User getUser(String email, String password) {
		String hql = "from User where email= :email and password= :password";
		Query query = getSession().createQuery(hql);
		query.setParameter("email", email);
		query.setParameter("password", password);
		if (query.list().size() > 0) {
			return (User) query.list().get(0);
		} else {
			return null;
		}

	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
