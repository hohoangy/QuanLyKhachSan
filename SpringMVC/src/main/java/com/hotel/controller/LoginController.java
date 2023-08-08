package com.hotel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hotel.common.Constants;
import com.hotel.model.EmployeeModel;
import com.hotel.service.LoginService;

/**
 * @author Tien
 *
 * class LoginController
 */
@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView loginRequestHandler(ModelMap modelMap, HttpSession session, HttpServletRequest request) {
        EmployeeModel employee = loginService.checkCookie(request);
        if (employee == null) {
            return new ModelAndView(Constants.LOGIN_VIEW);
        }   
        else {          

            if (loginService.login(employee.getMaNV(), employee.getMatKhau()) != null) {
                session.setAttribute("userName", employee.getTenNV());
                session.setAttribute("chucVu", employee.getChucVu());
                session.setAttribute("maNV", employee.getMaNV());
                return new ModelAndView("redirect:/Home");
            } else {
                modelMap.put("errorMSg", "invalid login from cookie");
                return new ModelAndView(Constants.LOGIN_VIEW);
            }
        }       
    }
	
	@GetMapping("/Login")
    public ModelAndView getView() {
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName(Constants.LOGIN_VIEW);
    	return mv;
    }
	
	@PostMapping("/Login")
	public ModelAndView login(ModelMap model,@RequestParam("taiKhoan") String taiKhoan,
			@RequestParam("matKhau") String matKhau, boolean rememberMe, HttpSession session,
			HttpServletRequest request,HttpServletResponse response) {

		EmployeeModel employee = loginService.login(taiKhoan, matKhau);
		if (employee == null) {
			model.addAttribute("message", "Tài khoản hoặc mật khẩu không đúng.");
			model.addAttribute("taiKhoan", taiKhoan);
			model.addAttribute("matKhau", matKhau);
			return new ModelAndView("Login", model);
		}
		
		session.setAttribute("userName", employee.getTenNV());
		session.setAttribute("chucVu", employee.getChucVu());
		session.setAttribute("maNV", employee.getMaNV());
		
		if (rememberMe) {
			loginService.setCookie(employee, response);
		}
		
		return new ModelAndView("redirect:/Home");
	}
}
