package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotel.model.ServiceModel;
import com.hotel.service.ServiceService;

/**
 * @author Tien
 *
 * class ServiceController
 */
@Controller
public class ServiceController {
	
	@Autowired
	private ServiceService serviceService;
    
    /**
     * phuong thuc lay danh sach tat ca dich vu
     * 
     * @return
     */
    @RequestMapping("/Service/GetAllService")
    public @ResponseBody List<?> getAllService() {
    	
    	return serviceService.getAllService();
    }
    
    /**
     * phuong thuc lay dich vu theo ma DV
     * 
     * @param maDV kieu <code>String</code>
     * @return
     */
    @RequestMapping("/Service/GetService")
    public @ResponseBody ServiceModel getService(@RequestParam(name = "maDV") String maDV) {
    	
    	return serviceService.getService(maDV);
    }
    
    /**
     * phuong thuc tim kiem dich vu theo ten dich vu
     * 
     * @param tenDV kieu <code>String</code>
     * @return
     */
    @RequestMapping("/Service/Search")
    public @ResponseBody List<?> getServiceByName(@RequestParam("searchString") String tenDV) {
    	
    	return serviceService.getServiceByName(tenDV);
    }
    
    /**
     * phuong thuc them dich vu
     * 
     * @param serviceModel kieu <code>ServiceModel</code>
     * @return
     */
    @RequestMapping("/Service/Add")
    public @ResponseBody int addService(@ModelAttribute("ServiceModel") ServiceModel serviceModel) {
    	
    	return serviceService.addService(serviceModel);
    }
    
    /**
     * phuong thuc chinh sua dich vu
     * 
     * @param serviceModel kieu <code>ServiceModel</code>
     * @return
     */
    @RequestMapping("/Service/Edit")
    public @ResponseBody int editService(@ModelAttribute("ServiceModel") ServiceModel serviceModel) {
    	
    	return serviceService.editService(serviceModel);
    }
    
    /**
     * phuong thuc xoa dich vu
     * 
     * @param maDV kieu <code>String</code>
     * @return
     */
    @RequestMapping("/Service/Remove")
    public @ResponseBody int removeService(@RequestParam("maDV") String maDV) {
    	
    	return serviceService.removeService(maDV);
    }
    
    /**
     * phuong thuc kiem tra dich vu co duy nhat hay khong
     * 
     * @param serviceModel kieu <code>ServiceModel</code>
     * @return
     */
    @RequestMapping("/Service/CheckUnique")
    public @ResponseBody boolean isUnique(@ModelAttribute("ServiceModel") ServiceModel serviceModel) {
    	
    	return serviceService.isUnique(serviceModel);
    }
}
