package com.mycom.dao;

import com.mycom.entity.User;

import java.util.List;

public interface UserDao {

	public List<User> findAll();

	public List<User> sort(String type);

	public List<User> findByRole(String role);

	public User FindById(long id);

	public void insert(User user);

	public void update(User user);

	public void delete(long user_id);

}
