package com.hotel.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.hotel.dao.HomeDAO;

/**
 * @author Tien
 * 
 * class HomeService
 */
@Service
public class HomeService {
	
	private HomeDAO homeDAO;

	public HomeDAO getHomeDAO() {
		return homeDAO;
	}

	public void setHomeDAO(HomeDAO homeDAO) {
		this.homeDAO = homeDAO;
	}
	
	/**
	 * phuong thuc lay so luong phong thue trong ngay
	 * 
	 * @param now
	 * @return numOfRentedRoom kieu long
	 */
	private long getNumOfRentedRoomInDay(Date now) {
		
		// khoi tao doi tuong builder kieu StringBuilder
		StringBuilder builder = new StringBuilder();
		
		// thiet lap cau truy van sql
		builder.append("select count(r) from com.hotel.model.RentedRoomModel r ");
		builder.append("where CONVERT(r.ngayDen, DATE) = CONVERT(:now, DATE)");
		
		// lay so luong phong thue trong ngay
		long numOfRentedRoom = homeDAO.getNumOfRoom(now, builder.toString());
		
		return numOfRentedRoom;
	}
	

	
	/**
	 * phuong thuc lay so luong phong thue trong ngay
	 * (bao gom phong thue va dat)
	 * 
	 * @return numOfRentedInDay kieu long
	 */
	public long getNumOfRentedInDay() {
		
		// lay ngay hien tai
		Date now = new Date();
		
		// lay so luong phong thue trong ngay
		long numOfRentedRoom = getNumOfRentedRoomInDay(now);
		
		// lay so luong phong dat trong ngay
	//	long numOfReservationRoom = getNumOfReservationRoomInDay(now);
		
		// lay so luong phong thue trong ngay (bao gom phong thue va dat)
		long numOfRentedInDay = numOfRentedRoom;
		
		return numOfRentedInDay;
	}
	
	/**
	 * phuong thuc lay so luong phong theo tinh trang phong
	 * 
	 * @param status kieu int
	 * @return numOfEmtyRoom kieu long
	 */
	public long getNumOfByStatus(int status) {
		
		// khoi tao doi tuong builder kieu StringBuilder
		StringBuilder builder = new StringBuilder();

		// thiet lap cau truy van sql
		builder.append("select count(r) from com.hotel.model.RoomModel r ");
		builder.append("where r.trangThai = :trangThai");

		// lay so luong phong theo tinh trang phong
		long numOfEmtyRoom = homeDAO.getNumOfRoomByStatus(builder.toString(), status);
		
		return numOfEmtyRoom;
	}
}

