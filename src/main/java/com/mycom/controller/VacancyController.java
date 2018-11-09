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
import com.mycom.jdbc.JdbcSkillDao;
import com.mycom.jdbc.JdbcUserDao;
import com.mycom.jdbc.JdbcVacancyDao;

@RestController
@RequestMapping("/vacancy")
public class VacancyController {
	
	@Autowired
	private JdbcVacancyDao jdbcvacancydao;
	
	@Autowired
	private JdbcSkillDao jdbcskilldao;
	
	@Autowired
	private JdbcUserDao jdbcuserdao;
	
	private static List<Vacancy> list;

	 @ResponseStatus(HttpStatus.CREATED)
	 @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.PUT)
	 @ResponseBody
	 public Vacancy SaveVacancy(@Valid @RequestBody Vacancy vacancy, BindingResult bindingResult) throws BindException {
		 if (bindingResult.hasErrors()) {
			 throw new BindException(bindingResult);
		 }
		 if (vacancy.getId()!=null)
			 jdbcvacancydao.update(vacancy);
		 else
			 jdbcvacancydao.insert(vacancy);
		 return vacancy;
	 }

	 @ResponseStatus(HttpStatus.NO_CONTENT)
	 @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	 @ResponseBody
	 public void VacancyDelete(@RequestParam(value = "id") Long id) {
		 jdbcvacancydao.delete(id);
	 }

	 @ResponseStatus(HttpStatus.OK)
	 @RequestMapping(value = "/list", method = RequestMethod.GET)
	 @ResponseBody
	 public List<Vacancy> VacancyAll() {
		 list = jdbcvacancydao.findAll();
		 return list;
	 }


	 @ResponseStatus(HttpStatus.OK)
	 @RequestMapping(value = "/sortSalaryTo", method = RequestMethod.GET)
	 @ResponseBody
	 public List<Vacancy> VacancySortSalaryTo() {
		 list = jdbcvacancydao.sortForSalaryTo();
		 return list;
	 }

	 @ResponseStatus(HttpStatus.OK)
	 @RequestMapping(value = "/sortSalaryFrom", method = RequestMethod.GET)
	 @ResponseBody
	 public List<Vacancy> VacancySortSalaryFrom() {
		 list = jdbcvacancydao.sortForSalaryFrom();
		 return list;
	 }
	 
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/SortExperience", method = RequestMethod.GET)
	@ResponseBody
	public List<Vacancy> SortExperience(Model model) {
		list = jdbcvacancydao.sortForExperience();
		return list;
	}
	
}
