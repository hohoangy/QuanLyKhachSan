package com.hotel.controller;

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

import com.hotel.model.RoomModel;
import com.hotel.service.RoomService;

/**
 * @author Tien
 *
 * class RoomController
 */
@Controller
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
    /**
     * phuong thuc lay tat ca phong va tra ve view
     * 
     * @return
     */
    @RequestMapping("/Room")
	public ModelAndView getView() {
    	
		// khoi tao doi tuong mv ModelAndView
		ModelAndView mv = new ModelAndView();
		
		// set ten view tra ve
		mv.setViewName("RoomManage");
		
		return mv;
	}
    
    /**
     * phuong thuc lay tat ca phong
     * 
     * @return
     */
    @RequestMapping("/Room/GetAllRoom")
	public @ResponseBody List<RoomModel> getAllRoom() {
			
    	// lay danh sach tat ca phong
    	List<RoomModel> roomList = roomService.getAllRoom();
		
		return roomList;
	}
    
    /**
     * phuong thuc lay tat ca phong chua bi xoa
     * 
     * @return
     */
    @RequestMapping("/Room/GetAllRoomNoDeleted")
	public @ResponseBody List<RoomModel> getAllRoomNoDeleted() {
			
    	// lay danh sach tat ca phong
    	List<RoomModel> roomList = roomService.getAllRoomNoDeleted();
		
		return roomList;
	}
    
    /**
     * phuong thuc lay danh sach phong theo ten
     * 
     * @param searchString kieu String
     * @return
     */
    @RequestMapping(value = "/Room/Search",
    		method = RequestMethod.GET)
	public @ResponseBody List<RoomModel> getRoomByName(
			@RequestParam(name = "searchString") String searchString) {
			 
    	// lay danh sach phong theo ten
    	List<RoomModel> roomList = roomService.getRoomByName(searchString);
		
		return roomList;
	}
    
	/**
	 * phuong thuc them phong
	 * 
	 * @param room kieu RoomModel
	 * @return
	 */
	@RequestMapping(value = "/Room/Add", method = RequestMethod.POST)
	public @ResponseBody Object addRoom(@ModelAttribute("RoomModel") RoomModel room) {
		
		// khai bao bien kiem tra co loi khong
		boolean error = false;

		// lay danh sach tat ca cac phong
		List<RoomModel> roomList = roomService.getAllRoom();
		
		// kiem tra phong do co ton tai khong, neu co tra ve loi
		if (!roomService.containRoom(roomList, room)) {
			roomService.addRoom(room);
		} else {
			error = true;
		}
		
		// lay danh sach tat ca phong chua bi xoa
		roomList = roomService.getAllRoomNoDeleted();
		
		// khoi tao doi tuong Map
		Map<Object, Object> map = new HashMap<>();
		
		// put cac doi tuong vao map
		map.put("roomList", roomList);
		map.put("error", error);

		return map;
	}
    
    /**
     * phuong thuc xoa phong
     * 
     * @param maPhong kieu String
     * @return
     */
    @RequestMapping(value = "/Room/Remove",
    		method = RequestMethod.POST)
    public @ResponseBody List<RoomModel> removeRoom(@RequestParam(name = "maPhong") String maPhong) {
    	
    	// thuc hien xoa phong
    	roomService.removeRoom(maPhong);
    	
    	// lay danh sach tat ca phong chua bi xoa
    	List<RoomModel> roomList = roomService.getAllRoomNoDeleted();
    	
    	return roomList;
    }
    
    /**
     * phuong thuc lay phong theo ma phong
     * 
     * @param maPhong kieu String
     * @return
     */
    @RequestMapping(value = "/Room/GetRoom",
    		method = RequestMethod.GET)
    public @ResponseBody RoomModel getRoom(@RequestParam(name = "maPhong") String maPhong) {
    	
    	// thuc hien viec lay phong va tra ve kết qua
    	return roomService.getRoom(maPhong);
    }
    
    /**
     * phuong thuc chinh sua phong
     * 
     * @param room kieu RoomModel
     * @return
     */
    @RequestMapping(value = "/Room/Edit",
    		method = RequestMethod.POST)
    public @ResponseBody List<RoomModel> editRoom(@ModelAttribute("RoomModel") RoomModel room) {
    	
    	// thuc hien chinh sua phong
    	roomService.editRoom(room);
    	
    	// lay danh sach tat ca phong
    	List<RoomModel> roomList = roomService.getAllRoomNoDeleted();
    	
    	return roomList;
    }
}
