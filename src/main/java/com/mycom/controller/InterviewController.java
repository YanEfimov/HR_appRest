package com.mycom.controller;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.beust.jcommander.internal.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonWriter;
import com.mycom.adapter.HibernateProxyTypeAdapter;
import com.mycom.entity.Interview;
import com.mycom.service.InterviewService;

@RestController
@RequestMapping("/interview")
public class InterviewController {

	@Autowired
	private InterviewService service;

	private List<Interview> list;

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.PUT)
	@ResponseBody
	public Interview SaveInterview(@Valid @RequestBody Interview interview, BindingResult bindingResult)
			throws BindException {
		if (bindingResult.hasErrors()) {
			throw new BindException(bindingResult);
		}
		if (interview.getId() != null)
			service.update(interview);
		else
			service.insert(interview);
		return interview;
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public void InterviewDelete(@RequestParam(value = "id") Long id) {
		Interview interview = service.FindById(id);
		service.delete(id);
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public List<Interview> InterviewAll() {
		// System.out.println(service.findAll());
		//
		// GsonBuilder b = new GsonBuilder();
		// b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		// String gson = b.create().toJson(service.findAll().get(0));
		return service.findAll();
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/sort", method = RequestMethod.GET)
	@ResponseBody
	public List<Interview> Sort(@RequestParam(value = "type") String type) {
		return service.sort(type);
	}

}
