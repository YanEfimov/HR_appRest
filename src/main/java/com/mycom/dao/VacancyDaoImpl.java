package com.mycom.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycom.entity.Vacancy;

@Repository
public class VacancyDaoImpl implements VacancyDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Vacancy> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Vacancy").list();
	}

	@Override
	public List<Vacancy> sort(String type) {
		return sessionFactory.getCurrentSession().createQuery("from Vacancy order by" + type).list();
	}

	@Override
	public Vacancy findById(long id) {
		return (Vacancy) sessionFactory.getCurrentSession().get(Vacancy.class, id);
	}

	@Override
	public void insert(Vacancy vacancy) {
		sessionFactory.getCurrentSession().save(vacancy);
	}

	@Override
	public void update(Vacancy vacancy) {
		sessionFactory.getCurrentSession().update(vacancy);
	}

	@Override
	public void delete(long vacancy_id) {
		Vacancy vacancy = (Vacancy) sessionFactory.getCurrentSession().load(Vacancy.class, vacancy_id);
		if (vacancy != null) {
			sessionFactory.getCurrentSession().delete(vacancy);
		}
	}

}
