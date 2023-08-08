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

import com.hotel.model.EmployeeModel;
import com.hotel.service.EmployeeService;

@Controller
@RequestMapping
public class AccountController {
	
	@Autowired
	public EmployeeService employeeService;
	
	 @RequestMapping("/Account/getAllEmployee")
	    public @ResponseBody List<EmployeeModel> getAllEmployee() {
	    	
	    	return employeeService.getAllAccount();
	    }
		
	
	
 @RequestMapping("/Account/GetEmployee")
    public @ResponseBody EmployeeModel getEmployee(@RequestParam(value = "maNV") String maNV) {
    	    	
    	return employeeService.getEmployee(maNV);
    }
// Search
	@RequestMapping(value = "/Account/Search", method = RequestMethod.GET)
	public @ResponseBody Object search(
			@RequestParam(name = "searchString") String searchString) {
		

		// lay danh sach phong theo ten
		List<EmployeeModel> employeeList = employeeService.getEmployeeByMaNV(searchString);
		Map<Object, Object> map = new HashMap<>();
		
		// put cac doi tuong vao map
		map.put("employeeList", employeeList);

		return map;
	}


	@RequestMapping(value = "/Account", method = RequestMethod.GET)
	public ModelAndView employee() {
		
		List<EmployeeModel> list = new ArrayList<>();
		list = employeeService.getAllAccount();

		// khoi tao doi tuong ModelAndView
		ModelAndView mv = new ModelAndView();

		// set ten view tra ve
		mv.setViewName("Account");

		// them cac du lieu can truyen xuong view
		mv.addObject("listEmployee", list);
		return mv;
	}

	@RequestMapping(value = "/Account/EditPass", method = RequestMethod.POST)
	public @ResponseBody Object editEmployee(@ModelAttribute("EmployeeModel") EmployeeModel employee) {

		// thuc hien chinh sua nhan vien
		employeeService.editPassword(employee);

		// lay danh sach tat ca nhan vien
		List<EmployeeModel> employeeList = employeeService.getAllAccount();

		// khoi tao doi tuong Map
		Map<Object, Object> map = new HashMap<>();
		
		// put cac doi tuong vao map
		map.put("employeeList", employeeList);

		return map;
	}
	@RequestMapping(value = "/Account/EditTrangThai", method = RequestMethod.POST)
	public @ResponseBody Object editTrangThai(@ModelAttribute("EmployeeModel") EmployeeModel employee) {

		// thuc hien chinh sua nhan vien
		employeeService.editTrangThai(employee);

		// lay danh sach tat ca nhan vien
		List<EmployeeModel> employeeList = employeeService.getAllAccount();

		// khoi tao doi tuong Map
		Map<Object, Object> map = new HashMap<>();
		
		// put cac doi tuong vao map
		map.put("employeeList", employeeList);

		return map;
	}

}
