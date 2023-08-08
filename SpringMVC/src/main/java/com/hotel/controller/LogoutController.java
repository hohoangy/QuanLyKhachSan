package com.hotel.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hotel.common.Constants;

/**
 * @author Tien
 *
 */
@Controller
public class LogoutController {
	
	@RequestMapping("/Logout")
	public ModelAndView logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return new ModelAndView(Constants.LOGIN_VIEW);
	}
}
