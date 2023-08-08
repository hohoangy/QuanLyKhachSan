package com.hotel.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hotel.model.CustomerModel;
import com.hotel.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	public CustomerService customerService;
	
	 @RequestMapping("/Customer/getAllCustomer")
	    public @ResponseBody List<CustomerModel> getAllCustomer() {
	    	
	    	return customerService.getAllCustomer();
	    }
		
	
	@RequestMapping(value = "/Customer/Add", method = RequestMethod.POST)
	//@PostMapping("insertCustomer")
	public @ResponseBody Object addCustomer(@ModelAttribute("CustomerModel") CustomerModel customer) {

		// khai bao bien kiem tra co loi khong
		String error = "";

		// lay danh sach tat ca khách hàng
		List<CustomerModel> customerList = customerService.getAllCustomer();

		// kiem tra khach hang do co ton tai khong, neu co tra ve loi
		if (!customerService.containCustomer(customerList, customer)) {
			customerService.addCustomer(customer);
		} else {
			error = "Khách hàng đã tồn tại";
		}

//		// lay danh sach tat ca phong
		customerList = customerService.getAllCustomer();
//
//		ModelAndView mv = new ModelAndView();
//
//		// set ten view tra ve
//		mv.setViewName("Customer");
//
//		// them cac du lieu can truyen xuong view
//		mv.addObject("listCustomer", customerList);
//		return mv;
		
		// khoi tao doi tuong Map
		Map<Object, Object> map = new HashMap<>();
		
		// put cac doi tuong vao map
		map.put("customerList", customerList);
		map.put("error", error);

		return map;
	}
	
 @RequestMapping("/Customer/GetCustomer")
    public @ResponseBody CustomerModel getCustomer(@RequestParam(value = "cmnd") String cmnd) {
    	    	
    	return customerService.getCustomer(cmnd);
    }
// Search
	@RequestMapping(value = "/Customer/Search", method = RequestMethod.GET)
	public @ResponseBody Object search(
			@RequestParam(name = "searchString") String searchString) {
		

		// lay danh sach phong theo ten
		List<CustomerModel> customerList = customerService.getCustomerByCMND(searchString);
		Map<Object, Object> map = new HashMap<>();
		
		// put cac doi tuong vao map
		map.put("customerList", customerList);

		return map;
	}


	@RequestMapping(value = "/Customer", method = RequestMethod.GET)
	public ModelAndView customer() {

		List<CustomerModel> list = new ArrayList<>();
		list = customerService.getAllCustomer();

		// khoi tao doi tuong ModelAndView
		ModelAndView mv = new ModelAndView();

		// set ten view tra ve
		mv.setViewName("Customer");

		// them cac du lieu can truyen xuong view
		mv.addObject("listCustomer", list);
		return mv;
	}

	@RequestMapping(value = "/Customer/Edit", method = RequestMethod.POST)
	public @ResponseBody Object editCustomer(@ModelAttribute("CustomerModel") CustomerModel customer) {

		// lay RoomService tu ApplicationContext
		

		// thuc hien chinh sua khach hang
		customerService.editCustomer(customer);

		// lay danh sach tat ca khach hang
		List<CustomerModel> customerList = customerService.getAllCustomer();

		// khoi tao doi tuong Map
		Map<Object, Object> map = new HashMap<>();
		
		// put cac doi tuong vao map
		map.put("customerList", customerList);

		return map;
	}


}
