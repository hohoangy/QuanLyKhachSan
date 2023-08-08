package com.hotel.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.hotel.common.Constants;
import com.hotel.model.ServiceUsingModel;

/**
 * @author Tien
 *
 * class SeriveUsingDAO
 */
@Repository(value = "serviceUsingDao")
@Transactional(rollbackOn = Exception.class)
public class ServiceUsingDAO {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<?> getAllServiceUsed(int trangThaiHuy, String queryString) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<?> query = session.createQuery(queryString);
		query.setParameter("trangThai", trangThaiHuy);
		
		List<?> listServiceUsed = query.list();
		
		return listServiceUsed;
	}
	
	public ServiceUsingModel getServiceUsed(int maKH, String maDV, String queryString) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<?> query = session.createQuery(queryString);
		query.setParameter("maKH", maKH);
		query.setParameter("maDV", maDV);
		
		ServiceUsingModel serviceUsed = (ServiceUsingModel) query.getSingleResult();
		
		return serviceUsed;
	}
	
	public List<?> searchServiceUsed(String searchValue, int trangThaiHuy, String queryString) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<?> query = session.createQuery(queryString);
		query.setParameter("searchValue", Constants.PERCENT_SYMBOL
				+ searchValue.replaceAll(Constants.PERCENT_SYMBOL, Constants.EMPTY_STRING)
				+ Constants.PERCENT_SYMBOL);
		query.setParameter("trangThai", trangThaiHuy);
		
		List<?> serviceUsedList = query.list();
		
		return serviceUsedList;
	}
	
	public int cancelServiceUsed(int maKH, String maDV, String maPhong, int trangThaiHuy, String queryString) {
		
		int status = 0;
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<?> query = session.createQuery(queryString);
		query.setParameter("maKH", maKH);
		query.setParameter("maDV", maDV);
		query.setParameter("maPhong", maPhong);
		query.setParameter("trangThai", trangThaiHuy);
		
		status = query.executeUpdate();
		
		return status;
	}
	
	public List<?> getServiceUsedForPay(int maKH, String maPhong, int trangThai, String queryString) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<?> query = session.createQuery(queryString);
		query.setParameter("maKH", maKH);
		query.setParameter("maPhong", maPhong);
		query.setParameter("trangThai", trangThai);
		
		List<?> serviceUsedForPayList = query.list();
		
		return serviceUsedForPayList;
	}
	
	/**
	 * phuong thuc su dung dich vu
	 * 
	 * @param serviceUsingBean kieu <code>ServiceUsingBean</code>
	 */
	public int useService(ServiceUsingModel serviceUsingModel, int trangThai, boolean isUnique, String queryString) {
		
		int status = 0;
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<?> query = session.createSQLQuery(queryString);
		
		if (isUnique) {
			query.setParameter("maDV", serviceUsingModel.getMaDV());
			query.setParameter("maKH", serviceUsingModel.getMaKH());
			query.setParameter("maPhong", serviceUsingModel.getMaPhong());
			query.setParameter("ngaySD", serviceUsingModel.getNgaySD());
			query.setParameter("soLuong", serviceUsingModel.getSoLuong());
		} else {
			query.setParameter("maDV", serviceUsingModel.getMaDV());
			query.setParameter("maKH", serviceUsingModel.getMaKH());
			query.setParameter("maPhong", serviceUsingModel.getMaPhong());
			query.setParameter("trangThai", trangThai);
			query.setParameter("soLuong", serviceUsingModel.getSoLuong());
		}
	
		status = query.executeUpdate();
		
		return status;
	}
	
	public int getQuanitySerivceUsing(ServiceUsingModel serviceUsingModel, int trangThai, String queryString) {
		
		int quantity = 0;
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<?> query = session.createQuery(queryString);
				
		query.setParameter("maDV", serviceUsingModel.getMaDV());
		query.setParameter("maKH", serviceUsingModel.getMaKH());
		query.setParameter("maPhong", serviceUsingModel.getMaPhong());
		query.setParameter("trangThai", trangThai);

		quantity = (int) query.getSingleResult();
		
		return quantity;
	}
	
	public int checkOut(int maKH, String maPhong, int trangThai, String queryString) {
		
		int status = 0;
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<?> query = session.createQuery(queryString);
				
		query.setParameter("maKH", maKH);
		query.setParameter("maPhong", maPhong);
		query.setParameter("trangThai", trangThai);

		status = query.executeUpdate();
		
		return status;
	}
}
