package com.mycom.controller;

import java.util.LinkedList;
import java.util.List;

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
import com.mycom.service.SkillService;
import com.mycom.tdt.Skilldto;
import com.mycom.tdt.TemplateDto;

@RestController
@RequestMapping("/skill")
public class SkillController {

	@Autowired
	private SkillService skillservice;

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public void SkillDelete(@RequestParam(value = "name") String name) {
		skillservice.delete(name);
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public List<Skilldto> getSkills() {
		return TemplateDto.parseSkill(skillservice.findAll());
	}

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/save", method = RequestMethod.PUT)
	@ResponseBody
	public Skill SaveSkill(@Valid @RequestBody Skill skill, BindingResult bindingResult) throws BindException {
		if (bindingResult.hasErrors()) {
			throw new BindException(bindingResult);
		}
		skillservice.insert(skill);
		return skill;
	}

}
