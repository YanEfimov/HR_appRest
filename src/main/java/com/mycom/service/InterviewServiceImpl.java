package com.mycom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycom.dao.InterviewDao;
import com.mycom.entity.Interview;

@Service
@Transactional
public class InterviewServiceImpl implements InterviewService{
	
	@Autowired
	private InterviewDao dao;

	@Override
	@Transactional
	public List<Interview> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public List<Interview> sort(String type) {
		return dao.sort(type);
	}

	@Override
	@Transactional
	public Interview FindById(long id) {
		return dao.FindById(id);
	}

	@Override
	@Transactional
	public void insert(Interview interview) {
		dao.insert(interview);
		
	}

	@Override
	@Transactional
	public void update(Interview interview) {
		dao.update(interview);
		
	}

	@Override
	@Transactional
	public void delete(long interview_id) {
		dao.delete(interview_id);
	}
}
