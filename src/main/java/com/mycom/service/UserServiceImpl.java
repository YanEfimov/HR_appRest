package com.mycom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycom.dao.UserDao;
import com.mycom.entity.User;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	@Transactional
	@Override
	public List<User> findAll() {
		return dao.findAll();
	}

	@Transactional
	@Override
	public List<User> sort(String type) {
		return dao.sort(type);
	}

	@Transactional
	@Override
	public List<User> findByRole(String role) {
		return dao.findByRole(role);
	}

	@Transactional
	@Override
	public User FindById(long id) {
		return dao.FindById(id);
	}

	@Transactional
	@Override
	public void insert(User user) {
		dao.insert(user);

	}

	@Transactional
	@Override
	public void update(User user) {
		dao.update(user);
	}

	@Transactional
	@Override
	public void delete(long user_id) {
		dao.delete(user_id);
	}
}
