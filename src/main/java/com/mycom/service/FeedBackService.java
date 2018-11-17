package com.mycom.service;

import java.util.List;

import com.mycom.entity.FeedBack;

public interface FeedBackService {
	public List<FeedBack> findAll();

	public List<FeedBack> findByState(String feedbackState);

	public List<FeedBack> sort(String type);

	public FeedBack findById(long id);

	public void insert(FeedBack feedback);

	public void update(FeedBack feedback);

	public void delete(long feedback_id);
}
