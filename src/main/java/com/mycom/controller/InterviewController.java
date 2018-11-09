package com.mycom.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.mycom.jdbc.JdbcInterviewDao;


import com.mycom.entity.Interview;


@RestController
@RequestMapping("/interview")
public class InterviewController {

    @Autowired
    private JdbcInterviewDao jdbcinterviewdao;

    private List<Interview> list;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.PUT)
    @ResponseBody
    public Interview SaveInterview(@Valid @RequestBody Interview interview, BindingResult bindingResult) throws BindException {
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        }
        if (interview.getId()!=null)
            jdbcinterviewdao.update(interview);
        else
            jdbcinterviewdao.insert(interview);
        return interview;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public void InterviewDelete(@RequestParam(value = "id") Long id) {
        Interview interview = jdbcinterviewdao.FindById(id);
        jdbcinterviewdao.delete(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Interview> InterviewAll() {
        list = jdbcinterviewdao.findAll();
        return list;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/sortPlanDate", method = RequestMethod.GET)
    @ResponseBody
    public List<Interview> InterviewSortPlanDate() {
        list = jdbcinterviewdao.SortByDatePlan();
        return list;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/sortFactDate", method = RequestMethod.GET)
    @ResponseBody
    public List<Interview> InterviewSortFactDate() {
        list = jdbcinterviewdao.SortByDateFact();
        return list;
    }

}
