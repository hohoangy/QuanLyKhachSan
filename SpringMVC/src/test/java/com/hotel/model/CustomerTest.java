package com.hotel.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class CustomerTest {


	//Kiểm tra lấy tên KH có bị null không
	@Test
	public void TestgetTenKH() {
	
		 CustomerModel customer = new CustomerModel();
		 assertEquals(customer.getTenKH(), null);
	}

}
