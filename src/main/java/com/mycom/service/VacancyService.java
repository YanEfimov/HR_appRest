package com.mycom.service;

import java.util.List;

import com.mycom.entity.Vacancy;

public interface VacancyService {
	public List<Vacancy> findAll();

	public List<Vacancy> sort(String type);

	public Vacancy findById(long id);

	public void insert(Vacancy vacancy);

	public void update(Vacancy vacancy);

	public void delete(long vacancy_id);
}
