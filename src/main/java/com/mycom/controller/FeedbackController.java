package com.mycom.controller;

import com.mycom.entity.FeedBack;
import com.mycom.jdbc.JdbcFeedBackDao;
import com.mycom.jdbc.JdbcFeedBackStateDao;
import com.mycom.jdbc.JdbcInterviewDao;
import com.mycom.jdbc.JdbcUserDao;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

	@Autowired
	private JdbcFeedBackDao jdbcfeedbackdao;
	@Autowired
	private JdbcFeedBackStateDao jdbcfeedbackstatedao;
	@Autowired
	private JdbcInterviewDao jdbcinterviewdao;
	@Autowired
	private JdbcUserDao jdbcuserdao;

	private List<FeedBack> list;
	
	 @ResponseStatus(HttpStatus.CREATED)
	 @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.PUT)
	 @ResponseBody
	 public FeedBack SaveFeedback(@Valid @RequestBody FeedBack feedBack, BindingResult bindingResult) throws BindException {
		 if (bindingResult.hasErrors()) {
			 throw new BindException(bindingResult);
		 }
		 if (feedBack.getId()!=null)
			 jdbcfeedbackdao.update(feedBack);
		 else
			 jdbcfeedbackdao.insert(feedBack);
		 return feedBack;
	 }

	 @ResponseStatus(HttpStatus.NO_CONTENT)
	 @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	 @ResponseBody
	 public void FeedbackDelete(@RequestParam(value = "id") Long id) {
		 FeedBack feedBack = jdbcfeedbackdao.findById(id);
		 jdbcfeedbackdao.delete(id);
	 }
	 @ResponseStatus(HttpStatus.OK)
	 @RequestMapping(value = "/list", method = RequestMethod.GET)
	 @ResponseBody
	 public List<FeedBack> FeedBackAll() {
		 list = jdbcfeedbackdao.findAll();
		 return list;
	 }

	@ResponseStatus(HttpStatus.OK) 
	@RequestMapping(value = "/filter", method = RequestMethod.GET)
	@ResponseBody
	public List<FeedBack> FilterFeedBack(@RequestParam(value = "type") String type) {
		list = jdbcfeedbackdao.findByState(type);
		return list;
	}
}
