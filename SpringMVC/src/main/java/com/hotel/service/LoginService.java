/**
 * 
 */
package com.hotel.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.hotel.dao.LoginDAO;
import com.hotel.model.EmployeeModel;

/**
 * @author Administrator
 *
 */
@Service
public class LoginService {
	
	private LoginDAO loginDAO;

	public LoginDAO getLoginDAO() {
		return loginDAO;
	}

	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}
	
	public EmployeeModel login(String taiKhoan, String matKhau) {

		// thiet lap cau truy van sql
		String queryString = "select r from EmployeeModel r where r.maNV = :taiKhoan and r.matKhau = :matKhau";

		// lay phong theo ma phong
		EmployeeModel employee = loginDAO.login(taiKhoan, matKhau, queryString);

		return employee;
	}
	
	public EmployeeModel checkCookie(HttpServletRequest request) {
        Cookie [] cookies=request.getCookies();
        EmployeeModel account=null;
        String username="",  password="";
        for (Cookie ck:cookies) {
            if(ck.getName().equalsIgnoreCase("username"))
                username=ck.getValue();
            if(ck.getName().equalsIgnoreCase("password"))
                password=ck.getValue();
        }
        if(!username.isEmpty() && !password.isEmpty())
            account= login(username, password);;
        return account;
    }
	
	public void setCookie(EmployeeModel employee, HttpServletResponse response) {
		Cookie ckUsername=new Cookie("username",employee.getMaNV());
        ckUsername.setMaxAge(30);
        response.addCookie(ckUsername);
        Cookie ckPassword=new Cookie("password",employee.getMatKhau());
        ckUsername.setMaxAge(30);
        response.addCookie(ckPassword);
	}
}
