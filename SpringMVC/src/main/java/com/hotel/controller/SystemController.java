package com.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hotel.common.Constants;

/**
 * @author Tien
 *
 * class SystemController
 */
/**
 * @author Administrator
 *
 * class SystemController
 */
@Controller
public class SystemController {
    
    @RequestMapping("/System")
	public ModelAndView system() {
		
		// khoi tao doi tuong ModelAndView
		ModelAndView mv = new ModelAndView();
		
		// set ten view tra ve
		mv.setViewName(Constants.SYSTEM_VIEW);
		
		return mv;
	}
    
    @RequestMapping("/System/Service")
	public ModelAndView service() {
		
		// khoi tao doi tuong ModelAndView
		ModelAndView mv = new ModelAndView();
		
		// set ten view tra ve
		mv.setViewName(Constants.SERVICE_VIEW);
		
		return mv;
	}
    
    @RequestMapping("/System/ServiceUsing")
	public ModelAndView getView() {
    	
    	// khoi tao doi tuong ModelAndView
		ModelAndView mv = new ModelAndView();
		
		// set ten view tra ve
		mv.setViewName(Constants.SERVICE_USING_VIEW);
		
		return mv;
	}
}
