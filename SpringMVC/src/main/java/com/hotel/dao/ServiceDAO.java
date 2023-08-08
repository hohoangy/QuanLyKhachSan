package com.hotel.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.hotel.common.Constants;
import com.hotel.model.ServiceModel;

/**
 * @author Tien
 *
 * class ServiceDAO
 */
@Repository("serviceDAO")
@Transactional(rollbackOn = Exception.class)
public class ServiceDAO {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * phuong thuc lay danh sach tat ca dich vu
	 * 
	 * @param queryString kieu <code>String</code>
	 * @return
	 */
	public List<?> getAllService(String queryString) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<?> query = session.createQuery(queryString);
		
		List<?> listService = query.list();
		
		return listService;
    }
	
	/**
	 * phuong thuc lay dich vu theo ma DV
	 * 
	 * @param maDV kieu <code>String</code>
	 * @param queryString kieu <code>String</code>
	 * @return
	 */
	public ServiceModel getService(String maDV, String queryString) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<?> query = session.createQuery(queryString);
		query.setParameter("maDV", maDV);
		
		ServiceModel service = (ServiceModel) query.getSingleResult();
		
		return service;
    }
	
	/**
	 * phuong thuc tim kiem dich vu theo ten dich vu
	 * 
	 * @param tenDV kieu <code>String</code>
	 * @param queryString kieu <code>String</code>
	 * @return
	 */
	public List<?> getServiceByName(String tenDV, String queryString) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<?> query = session.createQuery(queryString);
		
		// Xu ly tham so neu searchString khong rong
		if (null != tenDV && !Constants.EMPTY_STRING.equals(tenDV.trim())) {
			query.setParameter("tenDV", Constants.PERCENT_SYMBOL
					+ tenDV.replaceAll(Constants.PERCENT_SYMBOL, Constants.EMPTY_STRING)
					+ Constants.PERCENT_SYMBOL);
		}
		
		List<?> listService = query.list();
		
		return listService;
    }
	
	/**
	 * phuong thuc them dich vu
	 * 
	 * @param serviceModel kieu <code>ServiceModel</code>
	 * @param queryString kieu <code>String</code>
	 * @return
	 */
	public int addService(ServiceModel serviceModel, String queryString) {
		
		int status = 0;
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<?> query = session.createSQLQuery(queryString);
		query.setParameter("maDV", serviceModel.getMaDV());
		query.setParameter("tenDV", serviceModel.getTenDV());
		query.setParameter("giaDV", serviceModel.getGiaDV());

		status = query.executeUpdate();
		
		return status;
	}
	
	/**
	 * phuong thuc chinh sua dich vu
	 * 
	 * @param serviceModel kieu <code>ServiceModel</code>
	 * @param queryString kieu <code>String</code>
	 * @return
	 */
	public int editService(ServiceModel serviceModel, String queryString) {
		
		int status = 0;
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<?> query = session.createQuery(queryString);
		query.setParameter("maDV", serviceModel.getMaDV());
		query.setParameter("tenDV", serviceModel.getTenDV());
		query.setParameter("giaDV", serviceModel.getGiaDV());
		
		status = query.executeUpdate();
		
		return status;
	}
	
	/**
	 * phuong thuc xoa dich vu
	 * 
	 * @param maDV kieu <code>String</code>
	 * @param queryString kieu <code>String</code>
	 * @return
	 */
	public int removeService(String maDV, String queryString) {
		
		int status = 0;
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<?> query = session.createQuery(queryString);
		query.setParameter("maDV", maDV);
		
		status = query.executeUpdate();
		
		return status;
	}
}
