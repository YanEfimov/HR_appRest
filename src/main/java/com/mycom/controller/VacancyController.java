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

import com.mycom.entity.Skill;
import com.mycom.entity.User;
import com.mycom.entity.Vacancy;
import com.mycom.service.VacancyService;

@RestController
@RequestMapping("/vacancy")
public class VacancyController {

	@Autowired
	private VacancyService service;

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.PUT)
	@ResponseBody
	public Vacancy SaveVacancy(@Valid @RequestBody Vacancy vacancy, BindingResult bindingResult) throws BindException {
		if (bindingResult.hasErrors()) {
			throw new BindException(bindingResult);
		}
		if (vacancy.getId() != null)
			service.update(vacancy);
		else
			service.insert(vacancy);
		return vacancy;
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public void VacancyDelete(@RequestParam(value = "id") Long id) {
		service.delete(id);
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public List<Vacancy> VacancyAll() {
		return service.findAll();
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/sort", method = RequestMethod.GET)
	@ResponseBody
	public List<Vacancy> VacancySort(@RequestParam(value = "type") String type) {
		return service.sort(type);
	}

}
