package com.mycom.service;

import java.util.List;

import com.mycom.entity.Interview;

public interface InterviewService {
	public List<Interview> findAll();
	public List<Interview> sort(String type);
	public Interview FindById(long id);
	public void insert(Interview interview);
	public void update(Interview interview);
	public void delete(long interview_id);
}
