package com.hotel.service;

import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.hotel.dao.CustomerDAO;
import com.hotel.model.CustomerModel;


public class CustomerServiceTest {
	
	String queryString;
	CustomerService customerService = new CustomerService();
	CustomerDAO customerDAO = new CustomerDAO();
	CustomerModel customer = new CustomerModel();
	List<CustomerModel> customerList = Arrays.asList(customer);
	
	@Before
	public void setUp() throws Exception {
	}

	//Kiểm tra lấy danh sách khách hàng có bị null không
	@Test
	public void getAllCustomerNotNull() {
		StringBuilder builder = new StringBuilder();
		builder.append("select r from com.hotel.model.CustomerModel r");
		assertThat(customerDAO.getAllCustomer(builder.toString()), null);
	}

}
