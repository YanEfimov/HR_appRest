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
import com.mycom.jdbc.JdbcCandidateDao;
import com.mycom.jdbc.JdbcCandidateStateDao;
import com.mycom.jdbc.JdbcSkillDao;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
	
	@Autowired
	private JdbcCandidateDao jdbccandidatedao;
	
	@Autowired
	private JdbcCandidateStateDao jdbccandidatestatedao;
	
	@Autowired
	private JdbcSkillDao jdbcskilldao;
	
	private List<Candidate> list;
	
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.PUT)
	@ResponseBody
	public Candidate SaveOrUpdate(@Valid @RequestBody Candidate candidate,BindingResult bindingResult) throws BindException {
		if (bindingResult.hasErrors()) {
			throw new BindException(bindingResult);
		}
		if (candidate.getId()!=null)
			jdbccandidatedao.update(candidate);
		else
			jdbccandidatedao.insert(candidate);
		return candidate;
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public void CandidateDelete(@RequestParam(value="id") Long id) {
		jdbccandidatedao.delete(id);
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/filter", method = RequestMethod.GET)
	@ResponseBody
	public List<Candidate> CandidateFilter(@RequestParam(value = "state") String state) {
		list = jdbccandidatedao.findByState(state);
		return list;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/sortname", method = RequestMethod.GET)
	@ResponseBody
	public List<Candidate> CandidateSortName() {
		list = jdbccandidatedao.sortNameCandidate();
		return list;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/sortsalary", method = RequestMethod.GET)
	@ResponseBody
	public List<Candidate> CandidateSortSalary() {
		list = jdbccandidatedao.sortSalaryCandidate();
		return list;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public List<Candidate> CandidateList(){
		list = jdbccandidatedao.findAll();
		return list;
	}
	
}
