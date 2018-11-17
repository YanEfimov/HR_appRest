package com.mycom.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.proxy.HibernateProxyHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.beust.jcommander.internal.Lists;
import com.mycom.entity.Candidate;
import com.mycom.entity.Interview;

@Repository
public class InterviewDaoImpl implements InterviewDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Interview> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Interview> list = session.createQuery("from Interview").list();
		return list;
	}

	@Override
	public List<Interview> sort(String type) {
		return sessionFactory.getCurrentSession().createQuery("from interview order by" + type).list();
	}

	@Override
	public Interview FindById(long id) {
		return (Interview) sessionFactory.getCurrentSession().get(Interview.class, id);
	}

	@Override
	public void insert(Interview interview) {
		sessionFactory.getCurrentSession().saveOrUpdate(interview);

	}

	@Override
	public void update(Interview interview) {
		sessionFactory.getCurrentSession().update(interview);

	}

	@Override
	public void delete(long interview_id) {
		Interview interview = (Interview) sessionFactory.getCurrentSession().load(Interview.class, interview_id);
		if (interview != null) {
			sessionFactory.getCurrentSession().delete(interview);
		}
	}

}
