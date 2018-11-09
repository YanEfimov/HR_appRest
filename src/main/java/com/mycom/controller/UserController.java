package com.mycom.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.mycom.entity.User;
import com.mycom.jdbc.JdbcUserDao;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private JdbcUserDao jdbcuserdao;
	
	private static List<User> list;
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.PUT)
	@ResponseBody
	public User SaveUser(@Valid @RequestBody User user, BindingResult bindingResult) throws BindException {
		if (bindingResult.hasErrors()) {
			throw new BindException(bindingResult);
		}
		if (user.getId()!=null)
			jdbcuserdao.update(user);
		else 
			jdbcuserdao.insert(user);
		return user;
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public void UserDelete(@RequestParam(value = "id") Long id) {
		jdbcuserdao.delete(id);
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/filter", method = RequestMethod.GET)
	@ResponseBody
	public List<User> FilterUser(@RequestParam(value = "type") String type) {
		list = jdbcuserdao.findByRole(type);
		return list;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/sortname", method = RequestMethod.GET)
	@ResponseBody
	public List<User> UserSortName() {
		list = jdbcuserdao.findAllSortName();
		return list;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public List<User> UserAll() {
		list = jdbcuserdao.findAll();
		return list;
	}
	
}
