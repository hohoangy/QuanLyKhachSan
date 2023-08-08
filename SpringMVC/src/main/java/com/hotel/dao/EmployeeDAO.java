package com.hotel.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.common.Constants;
import com.hotel.model.EmployeeModel;

@Repository("customerDAO")
@Transactional(rollbackFor = Exception.class)
public class EmployeeDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EmployeeModel> getAllEmployee(String queryString) {
		List<EmployeeModel> list = new ArrayList<>();
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery(queryString);
		list = query.list();
		return list;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EmployeeModel> getAllAccount(String queryString) {
		List<EmployeeModel> list = new ArrayList<>();
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery(queryString);
		list = query.list();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<EmployeeModel> findById(String queryString) {
		List<EmployeeModel> list = new ArrayList<>();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(queryString);
		list = query.getResultList();
		return list;
	}

	/**
	 * phuong thuc them nhân viên moi
	 * 
	 * @param employee    kieu EmployeeModel
	 * @param queryString kieu String
	 */
	@SuppressWarnings("rawtypes")
	public int addEmployee(EmployeeModel employee, String queryString) {
		int status = 0;

		// lay session tu sessionFactory
		Session session = this.sessionFactory.getCurrentSession();

		// tao query
		Query query = session.createSQLQuery(queryString);
		query.setParameter("maNV", employee.getMaNV());
		query.setParameter("tenNV", employee.getTenNV());
		query.setParameter("ngaySinh", employee.getNgaySinh());
		query.setParameter("gioiTinh", employee.isGioiTinh());
		query.setParameter("sdt", employee.getSdt());
		query.setParameter("matKhau", employee.getMatKhau());
		query.setParameter("chucVu", employee.getChucVu());
		query.setParameter("luong", employee.getLuong());
		query.setParameter("tinhTrang", employee.isTinhTrang());

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
	public List getEmployeeByMaNV(String searchString, String queryString) {

		// lay session tu sessionFactory
		Session session = this.sessionFactory.getCurrentSession();

		// tao query
		Query query = session.createQuery(queryString);

		if (null != searchString) {
			query.setParameter("maNV",
					Constants.PERCENT_SYMBOL + searchString.replaceAll(Constants.PERCENT_SYMBOL, Constants.EMTY_STRING)
							+ Constants.PERCENT_SYMBOL);
		}

		// execute query
		List<EmployeeModel> employeeList = query.list();

		return employeeList;
	}

	/**
	 * phuong thuc xoa khachhang
	 * 
	 * @param maKH        kieu int
	 * @param queryString kieu String
	 *//*
		 * @SuppressWarnings("rawtypes") public int removeCustomer(int maKH, String
		 * queryString) {
		 * 
		 * // trang thai cua viec thuc thi query int status = 0;
		 * 
		 * // lay session tu sessionFactory Session session =
		 * this.sessionFactory.getCurrentSession();
		 * 
		 * // tao query Query query = session.createQuery(queryString);
		 * 
		 * query.setParameter("maKH", maKH);
		 * 
		 * // execute query status = query.executeUpdate();
		 * 
		 * return status; }
		 */

	/**
	 * phuong thuc chinh sua thong tin nhân viên
	 * 
	 * @param employee    kieu EmployeeModel
	 * @param queryString kieu String
	 */
	@SuppressWarnings("rawtypes")
	public int editEmployee(EmployeeModel employee, String queryString) {

		// trang thai cua viec thuc thi query
		int status = 0;

		// lay session tu sessionFactory
		Session session = sessionFactory.getCurrentSession();

		// tao query
		Query query = session.createQuery(queryString);
		query.setParameter("maNV", employee.getMaNV());
		query.setParameter("tenNV", employee.getTenNV());
	//	query.setParameter("ngaySinh", employee.getNgaySinh());
	//	query.setParameter("gioiTinh", employee.isGioiTinh());
		query.setParameter("sdt", employee.getSdt());
	//	query.setParameter("matKhau", employee.getMatKhau());
		query.setParameter("chucVu", employee.getChucVu());
		query.setParameter("luong", employee.getLuong());
	//	query.setParameter("tinhTrang", employee.isTinhTrang());
		// execute query
		status = query.executeUpdate();

		return status;
	}

	@SuppressWarnings("rawtypes")
	public int editPassword(EmployeeModel employee, String queryString) {

		// trang thai cua viec thuc thi query
		int status = 0;

		// lay session tu sessionFactory
		Session session = sessionFactory.getCurrentSession();

		// tao query
		Query query = session.createQuery(queryString);
		query.setParameter("maNV", employee.getMaNV());
		
		query.setParameter("matKhau", employee.getMatKhau());
		
	//	query.setParameter("tinhTrang", employee.isTinhTrang());
		// execute query
		status = query.executeUpdate();

		return status;
	}
	
	@SuppressWarnings("rawtypes")
	public int editTrangThai(EmployeeModel employee, String queryString) {

		// trang thai cua viec thuc thi query
		int status = 0;

		// lay session tu sessionFactory
		Session session = sessionFactory.getCurrentSession();

		// tao query
		Query query = session.createQuery(queryString);
		query.setParameter("maNV", employee.getMaNV());
		
		//query.setParameter("matKhau", employee.getMatKhau());
		
		query.setParameter("tinhTrang", employee.isTinhTrang());
		// execute query
		status = query.executeUpdate();

		return status;
	}
	
	/**
	 * phuong thuc lay nhan vien theo manv
	 * 
	 * @param manv        kieu String
	 * @param queryString kieu String
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public EmployeeModel getEmployee(String manv, String queryString) {

		// lay session tu sessionFactory
		Session session = sessionFactory.getCurrentSession();

		// tao query
		Query query = session.createQuery(queryString);

		query.setParameter("maNV", manv);

		// execute query
		EmployeeModel employee = (EmployeeModel) query.uniqueResult();

		return employee;
	}
}
