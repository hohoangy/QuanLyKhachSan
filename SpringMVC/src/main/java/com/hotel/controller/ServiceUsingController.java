package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotel.model.ServiceUsingModel;
import com.hotel.service.ServiceUsingService;

/**
 * @author Tien
 *
 * class ServiceUsingController
 */
@Controller
public class ServiceUsingController {
	
	@Autowired
	private ServiceUsingService serviceUsingService;
	
	@RequestMapping("/ServiceUsing/GetAllServiceUsed")
	public @ResponseBody List<?> getAllServiceUsed() {
		
		return serviceUsingService.getAllServiceUsed();
	}
	
	@RequestMapping("/ServiceUsing/GetServiceUsed")
	public @ResponseBody ServiceUsingModel getServiceUsed(@RequestParam("maKH") int maKH,
			@RequestParam("maDV") String maDV) {
		
		return serviceUsingService.getServiceUsed(maKH, maDV);
	}
	
	@RequestMapping("/ServiceUsing/Search")
	public @ResponseBody List<?> searchServiceUsed(@RequestParam("searchValue") String searchValue) {
		
		return serviceUsingService.searchServiceUsed(searchValue);
	}
	
	@RequestMapping("/ServiceUsing/Cancel")
	public @ResponseBody int cancelServiceUsed(@RequestParam("maKH") int maKH,
			@RequestParam("maDV") String maDV, @RequestParam("maPhong") String maPhong) {
		
		return serviceUsingService.cancelServiceUsed(maKH, maDV, maPhong);
	}
	
	@RequestMapping("/ServiceUsing/GetServiceUsedForPay")
	public @ResponseBody List<?> getServiceUsedForPay(@RequestParam("maKH") int maKH, 
			@RequestParam("maPhong") String maPhong) {
		
		return serviceUsingService.getServiceUsedForPay(maKH, maPhong);
	}
	
	/**
     * phuong thuc su dung dich vu
     * 
     * 
     * @param maDV kieu <code>String</code>
     */
    @RequestMapping("/ServiceUsing/Use")
    public @ResponseBody int useService(@ModelAttribute("ServiceUsingModel") ServiceUsingModel serviceUsingModel) {
    	
    	return serviceUsingService.useService(serviceUsingModel);
    }
}
