package com.hotel.controller;

import static org.junit.Assert.assertNotNull;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hotel.model.CustomerModel;
import com.hotel.service.CustomerService;


public class CustomerControllerTest {

	@Mock
	private CustomerService customerService;
	
	@InjectMocks
	private CustomerController customerController;
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testList() throws Exception {
		List<CustomerModel> customer = new ArrayList<>();
		customer.add(new CustomerModel());
		customer.add(new CustomerModel());
		
		when(customerService.getAllCustomer()).thenReturn(customer);
		
	}
	
	//Kiểm tra có tạo được mockMVC hay không
	@Test
	public void CreateMockMvc() {
		assertNotNull(mockMvc);
	}
	
}
