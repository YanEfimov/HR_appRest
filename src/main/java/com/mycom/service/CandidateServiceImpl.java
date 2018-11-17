package com.mycom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycom.dao.CandidateDao;
import com.mycom.entity.Candidate;

@Transactional
@Service
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	private CandidateDao dao;

	@Transactional
	@Override
	public List<Candidate> findAll() {
		return dao.findAll();
	}

	@Transactional
	@Override
	public List<Candidate> sort(String type) {
		return dao.sort(type);
	}

	@Transactional
	@Override
	public List<Candidate> findByState(String state) {
		return dao.findByState(state);
	}

	@Transactional
	@Override
	public Candidate findById(long id) {
		return dao.findById(id);
	}

	@Transactional
	@Override
	public void insert(Candidate candidate) {
		dao.insert(candidate);
	}

	@Transactional
	@Override
	public void update(Candidate candidate) {
		dao.update(candidate);
	}

	@Transactional
	@Override
	public void delete(long candidate_id) {
		dao.delete(candidate_id);
	}

}
