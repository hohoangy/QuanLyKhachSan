package com.hotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hotel.common.Constants;
import com.hotel.dao.RentDAO;
import com.hotel.dao.ServiceUsingDAO;
import com.hotel.model.ServiceUsingModel;

/**
 * @author Tien
 *
 * class ServiceUsingService
 */
@Service
public class ServiceUsingService {
	
	private ServiceUsingDAO serviceUsingDAO;
	
	public ServiceUsingDAO getServiceUsingDAO() {
		return serviceUsingDAO;
	}

	public void setServiceUsingDAO(ServiceUsingDAO serviceUsingDAO) {
		this.serviceUsingDAO = serviceUsingDAO;
	}
	
	private RentDAO rentDAO;

	public RentDAO getRentDAO() {
		return rentDAO;
	}

	public void setRentDAO(RentDAO rentDAO) {
		this.rentDAO = rentDAO;
	}

	public List<?> getAllServiceUsed() {
		
		StringBuilder builder = new StringBuilder();
		builder.append("select s from ServiceUsingModel s ");
		builder.append("where s.trangThai != :trangThai");
		
		return serviceUsingDAO.getAllServiceUsed(Constants.U_CANCELED, builder.toString());
	}
	
	public ServiceUsingModel getServiceUsed(int maKH, String maDV) {
		
		StringBuilder builder = new StringBuilder();
		builder.append("select s from ServiceUsingModel s ");
		builder.append("where s.maKH = :maKH and s.maDV = :maDV");
		
		return serviceUsingDAO.getServiceUsed(maKH, maDV, builder.toString());
	}
	
	public List<?> searchServiceUsed(String searchValue) {
		
		StringBuilder builder = new StringBuilder();
		builder.append("select s from ServiceUsingModel s ");
		builder.append("where s.trangThai != :trangThai and s.customer.tenKH like :searchValue");
		
		return serviceUsingDAO.searchServiceUsed(searchValue, Constants.U_CANCELED, builder.toString());
	}
	
	public int cancelServiceUsed(int maKH, String maDV, String maPhong) {
		
		StringBuilder builder = new StringBuilder();
		builder.append("update ServiceUsingModel s set s.trangThai = :trangThai ");
		builder.append("where s.maKH = :maKH and s.maDV = :maDV and s.maPhong = :maPhong");
		
		return serviceUsingDAO.cancelServiceUsed(maKH, maDV, maPhong, Constants.U_CANCELED, builder.toString());
	}
	
	public List<?> getServiceUsedForPay(int maKH, String maPhong) {
		
		StringBuilder builder = new StringBuilder();
		builder.append("select s from ServiceUsingModel s ");
		builder.append("where s.maKH = :maKH and s.maPhong = :maPhong and s.trangThai = :trangThai");
		
		return serviceUsingDAO.getServiceUsedForPay(maKH, maPhong, Constants.U_UNPAID, builder.toString());
	}
	
	@SuppressWarnings("unchecked")
	public boolean isUnique(ServiceUsingModel serviceModel) {
		
		List<ServiceUsingModel> serviceList = (List<ServiceUsingModel>) getAllServiceUsed();
		
		boolean isUnique = true;
		
		for (ServiceUsingModel service : serviceList) {
			if (service.equals(serviceModel)) {
				isUnique = false;
				break;
			}
		}
				
		return isUnique;
	}
	
	private int getCustomerIDByRoomID(String maPhong) {
		
		StringBuilder builder = new StringBuilder();
		builder.append("select r.maKH from RentedRoomModel r ");
		builder.append("where r.trangThai = :trangThai and r.room.maPhong = :maPhong");
		
		return rentDAO.getCustomerIDByRoomID(maPhong, Constants.RENTING, builder.toString());
	}
	
	private int getQuanitySerivceUsing(ServiceUsingModel serviceUsingModel) {
		StringBuilder builder = new StringBuilder();
		builder.append("select r.soLuong from ServiceUsingModel r ");
		builder.append("where r.trangThai != :trangThai and r.maPhong = :maPhong ");
		builder.append("and r.maKH = :maKH and r.maDV = :maDV ");
		
		return serviceUsingDAO.getQuanitySerivceUsing(serviceUsingModel, Constants.U_CANCELED, builder.toString());
	}
	
	/**
     * phuong thuc su dung dich vu
     * 
     * @param customerIDs kieu <code>String[]</code>
     * @param usingDates kieu <code>String[]</code>
     * @param maDV kieu <code>String</code>
     */
	public int useService(ServiceUsingModel serviceUsingModel) {
		
		int soLuong = 0;
		
		int maKH = getCustomerIDByRoomID(serviceUsingModel.getMaPhong());
		serviceUsingModel.setMaKH(maKH);
		
		StringBuilder builder = new StringBuilder();
		
		boolean isUnique = isUnique(serviceUsingModel);
		
		if (isUnique) {
			builder.append("insert into sddv(MaKH, MaPhong, MaDV, SoLuong, NgaySD, TrangThai) ");
			builder.append("values(:maKH, :maPhong, :maDV, :soLuong, :ngaySD, 0)");
		} else {
			
			soLuong = getQuanitySerivceUsing(serviceUsingModel);
			serviceUsingModel.setSoLuong(soLuong+ serviceUsingModel.getSoLuong());
			
			builder.append("update sddv set SoLuong = :soLuong ");
			builder.append("where TrangThai != :trangThai and MaDV = :maDV and MaKH = :maKH and MaPhong = :maPhong");
		}
			
		return serviceUsingDAO.useService(serviceUsingModel, Constants.U_CANCELED, isUnique, builder.toString());
	}
	
	public int checkOut(int maKH, String maPhong) {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("update ServiceUsingModel set trangThai = :trangThai ");
		builder.append("where trangThai != 2 and maKH = :maKH and maPhong = :maPhong");
		
		return serviceUsingDAO.checkOut(maKH, maPhong, Constants.U_PAID, builder.toString());
	}
}
