package com.hotel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hotel.common.Constants;
import com.hotel.model.BillModel;
import com.hotel.model.CustomerModel;
import com.hotel.model.RentedRoomModel;
import com.hotel.service.CustomerService;
import com.hotel.service.RentService;
import com.hotel.service.ServiceUsingService;

/**
 * @author Tien
 *
 * class RentController
 */
@Controller
public class RentController{
	
	@Autowired
	private RentService rentService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ServiceUsingService serviceUsingService;
    
    /**
     * phuong thuc tra ve view
     * 
     * @return
     */
    @RequestMapping("/Rent")
    public ModelAndView getView() {
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName(Constants.RENT_VIEW);
    	return mv;
    }
    
    /**
     * phuong thuc lay danh sach phong cho
     * 
     * @return
     */
    @RequestMapping("/Rent/GetEmptyRoom")
    public @ResponseBody List<?> getEmptyRoom() {
    	
    	return rentService.getEmptyRoom();
    }
    
    /**
     * phuong thuc lay thong tin khach hang dang thue phong
     * 
     * @param maPhong kieu String
     * @return
     */
    @RequestMapping("/Rent/GetRentedInfo")
    public @ResponseBody List<?> getRentedInfo() {
    	
    	return rentService.getRentedInfo();
    }
    
    @RequestMapping("/Rent/GetInfoCheckOut")
    public @ResponseBody Object getInfoCheckOut(@RequestParam(name = "maPhong") String maPhong,
    		@RequestParam(name = "maKH") int maKH) {
    	
    	Map<String, Object> map = new HashMap<>();
    	
    	RentedRoomModel rentedRoom = rentService.getRentedInfoForPay(maKH, maPhong);
    	List<?> serviceUsingRoom = serviceUsingService.getServiceUsedForPay(maKH, maPhong);
    	//List<?> reservationRoomList = rentService.getRentedInfoForPay(maKH, maPhong);
    	
    	map.put("rentedRoom", rentedRoom);
    	map.put("serviceUsingRoom", serviceUsingRoom);
    	  		
    	return map;
    }
    
    /**
     * phuong thuc tra phong
     * 
     * @param maPhong kieu String
     * @return
     */
    @RequestMapping("/Rent/CheckOut")
    public @ResponseBody int checkOut(@RequestParam(name = "maPhong") String maPhong,
    		@ModelAttribute("BillModel") BillModel billModel) {
    	
    	rentService.addBill(billModel);
    	
    	serviceUsingService.checkOut(billModel.getMaKH(), maPhong);
    		
    	return rentService.changeStatus(0, maPhong);
    }
    
    /**
     * phuong thuc tim kiem phong
     * 
     * @param tenPhong kieu String
     * @return
     */
    @RequestMapping("/Rent/Search")
    public @ResponseBody Object search(@RequestParam(name = "tenPhong") String tenPhong) {
    	
    	List<?> emptyRoomList = rentService.searchEmptyRoom(tenPhong);
    	
    	List<?> rentedRoomList = rentService.searchRentedRoom(tenPhong);
    	
    	Map<Object, Object> map = new HashMap<>();
    	
    	map.put("emptyRoomList", emptyRoomList);
    	map.put("rentedRoomList", rentedRoomList);
    	
    	return map;
    }
    
    @RequestMapping("/Rent/CancelRenting")
    public @ResponseBody int cancelRenting(@RequestParam(name = "maPhong") String maPhong) {

    	return rentService.changeStatus(0, maPhong);
    }
    
    @RequestMapping("/Rent/GetRentedInfoByRoomID")
    public @ResponseBody RentedRoomModel getRentedInfoByRoomID(@RequestParam(name = "maPhong") String maPhong) {

    	return rentService.getRentedInfoByRoomID(maPhong);
    }
    
    @RequestMapping("/Rent/RentRoom")
    public @ResponseBody int rent(@ModelAttribute("CustomerModel") CustomerModel customerPost, 
    		@ModelAttribute("RentedRoomModel") RentedRoomModel rentedRoomModel) {
    	
    	// lay khac hang theo cmnd
    	CustomerModel customer = customerService.getCustomer(customerPost.getCmnd());
    	
    	// neu khach hang chua co thi add vao database
    	if (customer == null) {
    		
    		customerService.addCustomer(customerPost);
    		
    		// lay lai khach hang sau khi add
    		customer = customerService.getCustomer(customerPost.getCmnd());
    	}
    	
    	// thue phong
    	rentService.changeStatusForRoom(rentedRoomModel.getMaPhong(), Constants.ROOM_RENTED);
    	
    	return rentService.rent(customer, rentedRoomModel);
    }
}
