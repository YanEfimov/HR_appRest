package com.mycom.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.google.gson.annotations.JsonAdapter;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.mycom.entity.Candidate;
import com.mycom.entity.CandidateState;
import com.mycom.entity.Skill;
import com.mycom.service.CandidateService;
import com.mycom.tdt.Candidatedto;
import com.mycom.tdt.TemplateDto;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

	@Autowired
	private CandidateService service;

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.PUT)
	@ResponseBody
	public Candidate SaveOrUpdate(@Valid @RequestBody Candidate candidate, BindingResult bindingResult)
			throws BindException {
		if (bindingResult.hasErrors()) {
			throw new BindException(bindingResult);
		}
		if (candidate.getId() != null)
			service.update(candidate);
		else
			service.insert(candidate);
		return candidate;
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public void CandidateDelete(@RequestParam(value = "id") Long id) {
		service.delete(id);
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/filter", method = RequestMethod.GET)
	@ResponseBody
	public List<Candidatedto> CandidateFilter(@RequestParam(value = "state") String state) {
		return TemplateDto.parseCandidatedto(service.findByState(state));
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/sort", method = RequestMethod.GET)
	@ResponseBody
	public List<Candidatedto> CandidateSort(@RequestParam(value = "type") String type) {
		return TemplateDto.parseCandidatedto(service.sort(type));
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public List<Candidatedto> CandidateList() {
		return TemplateDto.parseCandidatedto(service.findAll());
	}

}
