package com.mycom.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycom.entity.Candidate;

@Repository
public class CandidateDaoImpl implements CandidateDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Candidate> findAll() {
		return sessionFactory.getCurrentSession().createQuery(
				"select distinct candidate from Candidate candidate left join fetch candidate.candidateState left join fetch candidate.skills")
				.list();
	}

	@Override
	public List<Candidate> sort(String type) {
		return sessionFactory.getCurrentSession().createQuery(
				"select distinct candidate from Candidate candidate left join fetch candidate.candidateState left join fetch candidate.skills order by candidate."
						+ type)
				.list();
	}

	@Override
	public List<Candidate> findByState(String state) {
		return sessionFactory.getCurrentSession().createQuery(
				"select distinct candidate from Candidate candidate left join fetch candidate.candidateState ct left join fetch candidate.skills where ct.name = :state")
				.setParameter("state", state).list();
	}

	@Override
	public Candidate findById(long id) {
		return (Candidate) sessionFactory.getCurrentSession().get(Candidate.class, id);
	}

	@Override
	public void insert(Candidate candidate) {
		sessionFactory.getCurrentSession().saveOrUpdate(candidate);
	}

	@Override
	public void update(Candidate candidate) {
		sessionFactory.getCurrentSession().update(candidate);
	}

	@Override
	public void delete(long candidate_id) {
		Candidate candidate = (Candidate) sessionFactory.getCurrentSession().load(Candidate.class, candidate_id);
		if (candidate != null)
			sessionFactory.getCurrentSession().delete(candidate);
	}

}
