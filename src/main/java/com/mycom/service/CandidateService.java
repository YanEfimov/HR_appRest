package com.mycom.service;

import java.util.List;

import com.mycom.entity.Candidate;

public interface CandidateService {
	public List<Candidate> findAll();

	public List<Candidate> sort(String type);

	public List<Candidate> findByState(String state);

	public Candidate findById(long id);

	public void insert(Candidate candidate);

	public void update(Candidate candidate);

	public void delete(long candidate_id);
}
