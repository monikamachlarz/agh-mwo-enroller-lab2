package com.company.enroller.persistence;

import com.company.enroller.model.Meeting;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component("meetingService")
public class MeetingService {

	DatabaseConnector connector;

	public MeetingService() {
		connector = DatabaseConnector.getInstance();
	}


	public Collection<Meeting> getAll() {
		String hql = "FROM Meeting";
		Query query = this.connector.getSession().createQuery(hql);
		return query.list();
	}

	public Meeting findById(Long id) {
		return connector.getSession().get(Meeting.class, id);
	}

	public Meeting findByTitle(String title) {
		String hql = "FROM Meeting WHERE title = :title";
		Query query = this.connector.getSession().createQuery(hql);
		query.setParameter("title", title);
		return (Meeting) query.uniqueResult();
	}

	public Meeting add(Meeting meeting) {
		Transaction transaction = connector.getSession().beginTransaction();
		connector.getSession().save(meeting);
		transaction.commit();
		return meeting;
	}

	public void update(Meeting meeting) {
		Transaction transaction = connector.getSession().beginTransaction();
		connector.getSession().merge(meeting);
		transaction.commit();
	}

	public void delete(Meeting meeting) {
		Transaction transaction = connector.getSession().beginTransaction();
		connector.getSession().delete(meeting);
		transaction.commit();
	}

}
