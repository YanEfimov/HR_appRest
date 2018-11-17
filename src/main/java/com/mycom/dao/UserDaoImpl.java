package com.mycom.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycom.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<User> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	@Override
	public List<User> sort(String type) {
		return sessionFactory.getCurrentSession().createQuery("from User order by " + type).list();
	}

	@Override
	public List<User> findByRole(String role) {
		return sessionFactory.getCurrentSession().createQuery("select user from User user where user.role = :role")
				.setParameter("role", role).list();
	}

	@Override
	public User FindById(long id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	@Override
	public void insert(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public void update(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	@Override
	public void delete(long user_id) {
		User user = (User) sessionFactory.getCurrentSession().load(User.class, user_id);
		if (user != null) {
			sessionFactory.getCurrentSession().delete(user);
		}
	}

}
