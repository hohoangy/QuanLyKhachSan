package com.hotel.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.common.Constants;
import com.hotel.model.RoomModel;

/**
 * @author Tien
 *
 * class RoomDAO
 */
@Repository(value = "roomDAO")
@Transactional(rollbackFor = Exception.class)
public class RoomDAO {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * lay danh sach tat ca cac phong
	 * 
	 * @param trangThai kieu <code>int</code>
	 * @param queryString kieu <code>String</code>
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List getAllRoom(String queryString) {
		
		// lay session tu sessionFactory
		Session session = this.sessionFactory.getCurrentSession();
		
		// tao query
		Query query = session.createQuery(queryString);
		
		// execute query, phan trang
		List<RoomModel> roomList = query.list();
		
		return roomList;
	}
	
	/**
	 * lay danh sach tat ca cac phong chua bi xoa
	 * 
	 * @param trangThai kieu <code>int</code>
	 * @param queryString kieu <code>String</code>
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List getAllRoomNoDeleted(int trangThai, String queryString) {
		
		// lay session tu sessionFactory
		Session session = this.sessionFactory.getCurrentSession();
		
		// tao query
		Query query = session.createQuery(queryString);
		query.setParameter("trangThai", trangThai);
		
		// execute query, phan trang
		List<RoomModel> roomList = query.list();
		
		return roomList;
	}
	
	/**
	 * phuong thuc lay phong chua bi xoa theo ma phong
	 * 
	 * @param tenPhong kieu <code>String</code>
	 * @param trangThai kieu <code>int</code>
	 * @param queryString kieu <code>String</code>
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getRoomByName(String searchString, int trangThai, String queryString) {
		
		// lay session tu sessionFactory
		Session session = this.sessionFactory.getCurrentSession();
		
		// tao query
		Query query = session.createQuery(queryString);
		query.setParameter("trangThai", trangThai);
		
		// Xu ly tham so neu searchString khong rong
		if (null != searchString && !Constants.EMPTY_STRING.equals(searchString.trim())) {
			query.setParameter("tenPhong", Constants.PERCENT_SYMBOL
					+ searchString.replaceAll(Constants.PERCENT_SYMBOL, Constants.EMPTY_STRING)
					+ Constants.PERCENT_SYMBOL);
		}

		// execute query
		List<RoomModel> roomList = query.list();
		
		return roomList;
	}
	
	/**
	 * phuong thuc them phong moi
	 * 
	 * @param room kieu RoomModel
	 * @param queryString kieu String
	 */
	@SuppressWarnings("rawtypes")
	public int addRoom(RoomModel room, String queryString) {
		
		// trang thai cua viec thuc thi query
		int status = 0;
		
		// lay session tu sessionFactory
		Session session = this.sessionFactory.getCurrentSession();
		
		// tao query
		Query query = session.createSQLQuery(queryString);
		
		query.setParameter("maPhong", room.getMaPhong());
		query.setParameter("tenPhong", room.getTenPhong());
		query.setParameter("loaiPhong", room.getLoaiPhong());
		query.setParameter("gia", room.getGia());
		query.setParameter("trangThai", Constants.ROOM_EMPTY);
		
		// execute query
		status = query.executeUpdate();
		
		return status;
	}
	
	/**
	 * phuong thuc xoa phong 
	 * 
	 * @param maPhong kieu String
	 * @param trangThai kieu int
	 * @param queryString kieu String
	 */
	@SuppressWarnings("rawtypes")
	public int removeRoom(String maPhong, int trangThai, String queryString) {
		
		// trang thai cua viec thuc thi query
		int status = 0;
		
		// lay session tu sessionFactory
		Session session = this.sessionFactory.getCurrentSession();
		
		// tao query
		Query query = session.createQuery(queryString);
		query.setParameter("trangThai", trangThai);
		query.setParameter("maPhong", maPhong);
		
		// execute query
		status = query.executeUpdate();
		
		return status;
	}
	
	/**
	 * phuong thuc chinh sua thong tin phong
	 * 
	 * @param room kieu RoomModel
	 * @param queryString kieu String
	 */
	@SuppressWarnings("rawtypes")
	public int editRoom(RoomModel room, String queryString) {
		
		// trang thai cua viec thuc thi query
		int status = 0;
		
		// lay session tu sessionFactory
		Session session = this.sessionFactory.getCurrentSession();
		
		// tao query
		Query query = session.createQuery(queryString);
		
		query.setParameter("maPhong", room.getMaPhong());
		query.setParameter("tenPhong", room.getTenPhong());
		query.setParameter("loaiPhong", room.getLoaiPhong());
		query.setParameter("gia", room.getGia());
		
		// execute query
		status = query.executeUpdate();
		
		return status;
	}
	
	/**
	 * phuong thuc lay phong theo ma phong
	 * 
	 * @param maPhong kieu String
	 * @param trangThai kieu int
	 * @param queryString kieu String
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public RoomModel getRoom(String maPhong, int trangThai, String queryString) {
		
		// lay session tu sessionFactory
		Session session = this.sessionFactory.getCurrentSession();
		
		// tao query
		Query query = session.createQuery(queryString);
		query.setParameter("trangThai", trangThai);
		query.setParameter("maPhong", maPhong);
		
		// execute query
		RoomModel room = (RoomModel) query.uniqueResult();
		
		return room;
	}
	
	public List<?> getRoomType(String queryString) {
		
		// lay session tu sessionFactory
		Session session = this.sessionFactory.getCurrentSession();
		
		// tao query
		Query<?> query = session.createQuery(queryString);
		
		// execute query
		List<?> list = query.list();
		
		return list;
	}
	
	public RoomModel getRoomByID(String id) {
		
		// lay session tu sessionFactory
		Session session = this.sessionFactory.getCurrentSession();
		
		return session.get(RoomModel.class, id);
	}
}
