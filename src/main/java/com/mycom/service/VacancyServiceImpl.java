package com.mycom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycom.dao.VacancyDao;
import com.mycom.entity.Vacancy;

@Transactional
@Service
public class VacancyServiceImpl implements VacancyService{

	@Autowired
	private VacancyDao dao;
	
	@Transactional
	@Override
	public List<Vacancy> findAll() {
		return dao.findAll();
	}

	@Transactional
	@Override
	public List<Vacancy> sort(String type) {
		return dao.sort(type);
	}

	@Transactional
	@Override
	public Vacancy findById(long id) {
		return dao.findById(id);
	}

	@Transactional
	@Override
	public void insert(Vacancy vacancy) {
		dao.insert(vacancy);
	}

	@Transactional
	@Override
	public void update(Vacancy vacancy) {
		dao.update(vacancy);
	}

	@Transactional
	@Override
	public void delete(long vacancy_id) {
		dao.delete(vacancy_id);
	}
}
