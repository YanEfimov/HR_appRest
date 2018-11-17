package com.mycom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycom.dao.FeedBackDao;
import com.mycom.entity.FeedBack;

@Transactional
@Service
public class FeedBackServiceImpl implements FeedBackService {

	@Autowired
	private FeedBackDao dao;

	@Transactional
	@Override
	public List<FeedBack> findAll() {
		return dao.findAll();
	}

	@Transactional
	@Override
	public List<FeedBack> findByState(String feedbackState) {
		return dao.findByState(feedbackState);
	}

	@Transactional
	@Override
	public List<FeedBack> sort(String type) {
		return dao.sort(type);
	}

	@Transactional
	@Override
	public FeedBack findById(long id) {
		return dao.findById(id);
	}

	@Transactional
	@Override
	public void insert(FeedBack feedback) {
		dao.insert(feedback);
	}

	@Transactional
	@Override
	public void update(FeedBack feedback) {
		dao.update(feedback);
	}

	@Transactional
	@Override
	public void delete(long feedback_id) {
		dao.delete(feedback_id);
	}

}
