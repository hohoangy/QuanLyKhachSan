package com.hotel.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.common.Constants;
import com.hotel.model.CustomerModel;

@Repository("customerDAO")
@Transactional(rollbackFor = Exception.class)
public class CustomerDAO {
	

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CustomerModel> getAllCustomer(String queryString) {
		List<CustomerModel> list = new ArrayList<>();
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery(queryString);
		list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<CustomerModel> findById(String queryString) {
		List<CustomerModel> list = new ArrayList<>();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(queryString);
		list = query.getResultList();
		return list;
	}

	/**
	 * phuong thuc them khach hang moi
	 * 
	 * @param customer    kieu CustomerModel
	 * @param queryString kieu String
	 */
	@SuppressWarnings("rawtypes")
	public int addCustomer(CustomerModel customer, String queryString) {
		int status = 0;

		// lay session tu sessionFactory
		Session session = this.sessionFactory.getCurrentSession();

		// tao query
		Query query = session.createSQLQuery(queryString);
		query.setParameter("tenKH", customer.getTenKH());
		query.setParameter("cmnd", customer.getCmnd());
		query.setParameter("sdt", customer.getSdt());
		query.setParameter("quocTich", customer.getQuocTich());
		query.setParameter("vip", false);

		// execute query
		status = query.executeUpdate();

		return status;
	}

	/**
	 * phuong thuc lay khachhang theo cmnd
	 * 
	 * @param cmnd        kieu String
	 * @param queryString kieu String
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getCustomerByCMND(String searchString, String queryString) {

		// lay session tu sessionFactory
		Session session = this.sessionFactory.getCurrentSession();

		// tao query
		Query query = session.createQuery(queryString);

		if (null != searchString) {
			query.setParameter("cmnd",
					Constants.PERCENT_SYMBOL + searchString.replaceAll(Constants.PERCENT_SYMBOL, Constants.EMTY_STRING)
							+ Constants.PERCENT_SYMBOL);
		}

		// execute query
		List<CustomerModel> customerList = query.list();

		return customerList;
	}

	/**
	 * phuong thuc xoa khachhang
	 * 
	 * @param maKH        kieu int
	 * @param queryString kieu String
	 */
	@SuppressWarnings("rawtypes")
	public int removeCustomer(int maKH, String queryString) {

		// trang thai cua viec thuc thi query
		int status = 0;

		// lay session tu sessionFactory
		Session session = this.sessionFactory.getCurrentSession();

		// tao query
		Query query = session.createQuery(queryString);

		query.setParameter("maKH", maKH);

		// execute query
		status = query.executeUpdate();

		return status;
	}

	/**
	 * phuong thuc chinh sua thong tin khach hang
	 * 
	 * @param customer    kieu CustomerModel
	 * @param queryString kieu String
	 */
	@SuppressWarnings("rawtypes")
	public int editCustomer(CustomerModel customer, String queryString) {

		// trang thai cua viec thuc thi query
		int status = 0;

		// lay session tu sessionFactory
		Session session = sessionFactory.getCurrentSession();

		// tao query
		Query query = session.createQuery(queryString);

		query.setParameter("tenKH", customer.getTenKH());
		query.setParameter("cmnd", customer.getCmnd());
		query.setParameter("sdt", customer.getSdt());
		query.setParameter("quocTich", customer.getQuocTich());

		// execute query
		status = query.executeUpdate();

		return status;
	}

	/**
	 * phuong thuc lay khachhang theo cmnd
	 * 
	 * @param cmnd        kieu String
	 * @param queryString kieu String
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public CustomerModel getCustomer(String cmnd, String queryString) {

		// lay session tu sessionFactory
		Session session = sessionFactory.getCurrentSession();

		// tao query
		Query query = session.createQuery(queryString);

		query.setParameter("cmnd", cmnd);

		// execute query
		CustomerModel customer = (CustomerModel) query.uniqueResult();

		return customer;
	}
}
