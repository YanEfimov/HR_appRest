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
import com.mycom.service.UserService;
import com.mycom.tdt.TemplateDto;
import com.mycom.tdt.Userdto;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.PUT)
	@ResponseBody
	public User SaveUser(@Valid @RequestBody User user, BindingResult bindingResult) throws BindException {
		if (bindingResult.hasErrors()) {
			throw new BindException(bindingResult);
		}
		if (user.getId() != null)
			service.update(user);
		else
			service.insert(user);
		return user;
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public void UserDelete(@RequestParam(value = "id") Long id) {
		service.delete(id);
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/filter", method = RequestMethod.GET)
	@ResponseBody
	public List<Userdto> FilterUser(@RequestParam(value = "role") String role) {
		return TemplateDto.parseUserdto(service.findByRole(role));
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/sort", method = RequestMethod.GET)
	@ResponseBody
	public List<Userdto> UserSort(@RequestParam(value = "type") String type) {
		return TemplateDto.parseUserdto(service.sort(type));
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public List<Userdto> UserAll() {
		return TemplateDto.parseUserdto(service.findAll());
	}

}
