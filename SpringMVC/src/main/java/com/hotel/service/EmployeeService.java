package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.common.Constants;
import com.hotel.dao.EmployeeDAO;
import com.hotel.model.EmployeeModel;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	public List<EmployeeModel> getAllEmployee() {
		StringBuilder builder = new StringBuilder();
		builder.append("select r from EmployeeModel r");
		
		return employeeDAO.getAllEmployee(builder.toString());
	}


	public List<EmployeeModel> findById(String id) {
		StringBuilder builder = new StringBuilder();
		builder.append("From com.hotel.model.EmployeeModel A where A.maNV=" + id);
		return employeeDAO.findById(builder.toString());
	}

	/**
	 * phuong thuc them nhân viên moi
	 * 
	 * @param room kieu EmployeeModel
	 * @return
	 */

	public int addEmployee(EmployeeModel employee) {

		// khoi tao doi tuong builder kieu StringBuilder
		StringBuilder builder = new StringBuilder();

		// thiet lap cau truy van sql
		builder.append("insert into nhanvien(maNV, tenNV, ngaySinh, gioiTinh, sdt, matKhau, chucVu, luong, tinhTrang ) ");
		builder.append("values(:maNV, :tenNV, :ngaySinh, :gioiTinh, :sdt, :matKhau, :chucVu, :luong, :tinhTrang)");

		employee.setTinhTrang(Constants.EMPLOYEE_NORMAL);
		// them khachhang
		return employeeDAO.addEmployee(employee, builder.toString());
	}

	/**
	 * phuong thuc kiem tra nhan vien da duoc tao
	 * 
	 * @param customerList kieu List<CustomerModel>
	 * @param customer     kieu CustomerModel
	 * @return
	 */
	public boolean containEmployee(List<EmployeeModel> employeeList, EmployeeModel employee) {

		// khai bao bien kiem tra da ton tai khachhang do chua
		boolean haveEmployee = false;

		// duyet danh sach khach hang
		for (EmployeeModel employeeModel : employeeList) {

			// so sanh cac room trong danh sach voi room can kiem tra
			if (employee.equals(employeeModel)) {
				haveEmployee = true;
				break;
			}
		}

		return haveEmployee;
	}

	/**
	 * phuong thuc lay khach hang theo cmnd
	 * 
	 * @param searchString kieu String
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<EmployeeModel> getEmployeeByMaNV(String searchString) {

		// khoi tao doi tuong builder kieu StringBuilder
		StringBuilder builder = new StringBuilder();

		// thiet lap cau truy van sql
		builder.append("select r from com.hotel.model.EmployeeModel r ");
//
		// Xu ly query string neu searchString khong rong
		if (null != searchString && !Constants.EMTY_STRING.equals(searchString.trim())) {
			builder.append("where r.maNV like :maNV");
		}

		// lay danh sach phong
		List<EmployeeModel> employeeList = employeeDAO.getEmployeeByMaNV(searchString, builder.toString());

		return employeeList;
	}

	@SuppressWarnings("unchecked")
	public List<EmployeeModel> getAllAccount() {

		// khoi tao doi tuong builder kieu StringBuilder
		StringBuilder builder = new StringBuilder();

		// thiet lap cau truy van sql
		builder.append("select r from com.hotel.model.EmployeeModel r ");
//
		// Xu ly query string neu searchString khong rong
			builder.append("where r.tinhTrang = true");

		// lay danh sach phong
		List<EmployeeModel> employeeList = employeeDAO.getAllAccount(builder.toString());

		return employeeList;
	}

	
	/**
	 * phuong thuc xoa khach hang
	 * 
	 * @param maKH kieu int
	 * @return
	 */
	/*
	 * public int removeCustomer(int maKH) {
	 * 
	 * // thiet lap cau truy van sql String queryString =
	 * "delete from com.hotel.model.CustomerModel where maKH = :maKH";
	 * 
	 * // them phong return customerDAO.removeCustomer(maKH, queryString); }
	 * 
	 *//**
		 * phuong thuc chinh sua khach hang
		 * 
		 * @param customer kieu CustomerModel
		 * @return
		 */
	public int editEmployee(EmployeeModel employee) {

		// khoi tao doi tuong builder kieu StringBuilder
		StringBuilder builder = new StringBuilder();

		// thiet lap cau truy van sql

		builder.append("update EmployeeModel s set tenNV = :tenNV, sdt = :sdt, chucVu = :chucVu, luong = :luong ");
		builder.append("where maNV = :maNV");

		return employeeDAO.editEmployee(employee, builder.toString());
	}

	 
	public int editPassword(EmployeeModel employee) {

		// khoi tao doi tuong builder kieu StringBuilder
		StringBuilder builder = new StringBuilder();

		// thiet lap cau truy van sql

		builder.append("update EmployeeModel s set matKhau = :matKhau ");
		builder.append("where maNV = :maNV");

		return employeeDAO.editPassword(employee, builder.toString());
	}
	
	public int editTrangThai(EmployeeModel employee) {

		// khoi tao doi tuong builder kieu StringBuilder
		StringBuilder builder = new StringBuilder();

		// thiet lap cau truy van sql

		builder.append("update EmployeeModel s set tinhTrang = :tinhTrang ");
		builder.append("where maNV = :maNV");

		return employeeDAO.editTrangThai(employee, builder.toString());
	}
	
	
	/**
	 * phuong thuc lay khach hang theo cmnd
	 * 
	 * @param cmnd kieu String
	 * @return
	 */
	public EmployeeModel getEmployee(String maNV) {

		// thiet lap cau truy van sql
		String queryString = "select r from com.hotel.model.EmployeeModel r where maNV = :maNV";

		// lay phong theo ma phong
		EmployeeModel employee = employeeDAO.getEmployee(maNV, queryString);

		return employee;
	}
}
