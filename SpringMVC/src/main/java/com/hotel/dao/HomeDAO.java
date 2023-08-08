package com.hotel.dao;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Tien
 *
 * class HomeDAO
 */
@Repository(value = "homeDAO")
@Transactional(rollbackFor = Exception.class)
public class HomeDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * phuong thuc lay so luong phong
	 * 
	 * @param now kieu Date
	 * @param queryString kieu String
	 * @return numOfRoom kieu long
	 */
	@SuppressWarnings("rawtypes")
	public long getNumOfRoom(Date now, String queryString) {
		
		// lay session tu sessionFactory
		Session session = this.sessionFactory.getCurrentSession();
		
		// tao query
		Query query = session.createQuery(queryString);
		
		// set tham so cho query
		query.setParameter("now", now);
		
		// execute query
		long numOfRoom = (long) query.uniqueResult();
		
		return numOfRoom;
	}
	
	/**
	 * @param queryString
	 * @param status
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public long getNumOfRoomByStatus(String queryString, int status) {
		
		// lay session tu sessionFactory
		Session session = this.sessionFactory.getCurrentSession();
		
		// tao query
		Query query = session.createQuery(queryString);
		
		// set tham so cho query
		query.setParameter("trangThai", status);
		
		// execute query
		long numOfEmtyRoom = (long) query.uniqueResult();
		
		return numOfEmtyRoom;
	}
}
