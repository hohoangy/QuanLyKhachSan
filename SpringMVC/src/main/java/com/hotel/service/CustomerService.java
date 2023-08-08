package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.common.Constants;
import com.hotel.dao.CustomerDAO;
import com.hotel.model.CustomerModel;

@Service
public class CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	public CustomerDAO getCustomerDAO() {
		return customerDAO;
	}

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	public List<CustomerModel> getAllCustomer() {
		StringBuilder builder = new StringBuilder();
		builder.append("select r from com.hotel.model.CustomerModel r");

		return customerDAO.getAllCustomer(builder.toString());
	}

	public List<CustomerModel> findById(String id) {
		StringBuilder builder = new StringBuilder();
		builder.append("From com.hotel.model.CustomerModel A where A.MaNV=" + id);
		return customerDAO.findById(builder.toString());
	}

	/**
	 * phuong thuc them khach hang moi
	 * 
	 * @param room kieu CustomerModel
	 * @return
	 */
	
	public int addCustomer(CustomerModel customer) {

		// khoi tao doi tuong builder kieu StringBuilder
		StringBuilder builder = new StringBuilder();

		// thiet lap cau truy van sql
		builder.append("insert into khachhang(tenKH, cmnd, sdt, quocTich, vip) ");
		builder.append("values(:tenKH, :cmnd, :sdt, :quocTich, :vip)");

		customer.setVip(Constants.CUSTOMER_NORMAL);
		// them khachhang
		return customerDAO.addCustomer(customer, builder.toString());
	}

	/**
	 * phuong thuc kiem tra khachhang da duoc tao
	 * 
	 * @param customerList kieu List<CustomerModel>
	 * @param customer     kieu CustomerModel
	 * @return
	 */
	public boolean containCustomer(List<CustomerModel> customerList, CustomerModel customer) {

		// khai bao bien kiem tra da ton tai khachhang do chua
		boolean haveCustomer = false;

		// duyet danh sach khach hang
		for (CustomerModel customerModel : customerList) {

			// so sanh cac room trong danh sach voi room can kiem tra
			if (customer.equals(customerModel)) {
				haveCustomer = true;
				break;
			}
		}

		return haveCustomer;
	}

	/**
	 * phuong thuc lay khach hang theo cmnd
	 * 
	 * @param searchString kieu String
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<CustomerModel> getCustomerByCMND(String searchString) {

		// khoi tao doi tuong builder kieu StringBuilder
		StringBuilder builder = new StringBuilder();

		// thiet lap cau truy van sql
		builder.append("select r from com.hotel.model.CustomerModel r ");
//
		// Xu ly query string neu searchString khong rong
		if (null != searchString && !Constants.EMTY_STRING.equals(searchString.trim())) {
			builder.append("where r.cmnd like :cmnd");
		}

		// lay danh sach phong
		List<CustomerModel> customerList = customerDAO.getCustomerByCMND(searchString, builder.toString());

		return customerList;
	}

	/**
	 * phuong thuc xoa khach hang
	 * 
	 * @param maKH kieu int
	 * @return
	 */
	public int removeCustomer(int maKH) {

		// thiet lap cau truy van sql
		String queryString = "delete from com.hotel.model.CustomerModel where maKH = :maKH";

		// them phong
		return customerDAO.removeCustomer(maKH, queryString);
	}

	/**
	 * phuong thuc chinh sua khach hang
	 * 
	 * @param customer kieu CustomerModel
	 * @return
	 */
	public int editCustomer(CustomerModel customer) {

		// khoi tao doi tuong builder kieu StringBuilder
		StringBuilder builder = new StringBuilder();
		
		// thiet lap cau truy van sql
		
		builder.append("update CustomerModel s set tenKH = :tenKH, sdt = :sdt, quocTich = : quocTich ");
		builder.append("where cmnd = :cmnd");
		
		return customerDAO.editCustomer(customer, builder.toString());
	}

	/**
	 * phuong thuc lay khach hang theo cmnd
	 * 
	 * @param cmnd kieu String
	 * @return
	 */
	public CustomerModel getCustomer(String cmnd) {

		// thiet lap cau truy van sql
		String queryString = "select r from com.hotel.model.CustomerModel r where cmnd = :cmnd";

		// lay phong theo ma phong
		CustomerModel customer = customerDAO.getCustomer(cmnd, queryString);

		return customer;
	}
}
