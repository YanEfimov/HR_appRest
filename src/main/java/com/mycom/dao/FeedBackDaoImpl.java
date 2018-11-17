package com.mycom.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycom.entity.FeedBack;
import com.mycom.entity.Interview;

@Repository
public class FeedBackDaoImpl implements FeedBackDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<FeedBack> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from FeedBack").list();
	}

	@Override
	public List<FeedBack> findByState(String feedbackState) {
		return sessionFactory.getCurrentSession()
				.createQuery(
						"select f from FeedBack f left join fetch f.feedbackState st where st.name = :" + feedbackState)
				.list();
	}

	@Override
	public List<FeedBack> sort(String type) {
		return sessionFactory.getCurrentSession().createQuery("from FeedBack order by" + type).list();
	}

	@Override
	public FeedBack findById(long id) {
		return (FeedBack) sessionFactory.getCurrentSession().get(FeedBack.class, id);
	}

	@Override
	public void insert(FeedBack feedback) {
		sessionFactory.getCurrentSession().save(feedback);

	}

	@Override
	public void update(FeedBack feedback) {
		sessionFactory.getCurrentSession().update(feedback);

	}

	@Override
	public void delete(long feedback_id) {
		FeedBack feedback = (FeedBack) sessionFactory.getCurrentSession().load(FeedBack.class, feedback_id);
		if (feedback != null) {
			sessionFactory.getCurrentSession().delete(feedback);
		}
	}

}
