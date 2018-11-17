package com.mycom.service;

import java.util.List;

import com.mycom.entity.User;

public interface UserService {
	public List<User> findAll();

	public List<User> sort(String type);

	public List<User> findByRole(String role);

	public User FindById(long id);

	public void insert(User user);

	public void update(User user);

	public void delete(long user_id);
}
