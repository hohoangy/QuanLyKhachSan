package com.hotel.common;

/**
 * @author Tien
 * 
 * class Constants
 */
public class Constants {
	
	public static final String EMTY_STRING = "";
	public static final boolean CUSTOMER_NORMAL = false;
	public static final boolean EMPLOYEE_NORMAL = true;
	// Trang thai phong
	public static int ROOM_EMPTY = 0;
	public static int ROOM_RENTED = 1;
	public static int ROOM_CLEAN = 2;
	public static int ROOM_DELETED = 3;
	
	// Trang thai thue phong
	public static int RENTING = 0;
	public static int CHECKED_OUT = 1;
	public static int CANCELED = 2;

	// Trang thai dich vu da su dung
	public static int U_UNPAID = 0;
	public static int U_PAID = 1;
	public static int U_CANCELED = 2;
	
	// chuoi rong
	public static String EMPTY_STRING = "";
	
	// symbol
	public static String PERCENT_SYMBOL = "%";
	
	// Loai phong
	public static String SINGLE_ROOM = "P0";
	public static String DOUBLE_ROOM = "P1";
	public static String SINGLE_ROOM_TEXT = "Phòng đơn";
	public static String DOUBLE_ROOM_TEXT = "Phòng đôi";
	public static String VIP_ROOM_TEXT = "Phòng VIP";
	
	// service
	public static String HOME_SERVICE ="homeService";
	
	// view
	public static String HOME_VIEW = "Home";
	public static String RENT_VIEW = "Room";
	public static String SYSTEM_VIEW = "System";
	public static String SERVICE_VIEW = "Menu";
	public static String SERVICE_USING_VIEW = "Service";
	public static String LOGIN_VIEW = "Login";
}
