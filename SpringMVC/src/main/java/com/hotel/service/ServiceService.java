package com.hotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hotel.common.Constants;
import com.hotel.dao.ServiceDAO;
import com.hotel.model.ServiceModel;

/**
 * @author Tien
 *
 * class ServiceService
 */
@Service
public class ServiceService {
	
	private ServiceDAO serviceDAO;

	public ServiceDAO getServiceDAO() {
		return serviceDAO;
	}

	public void setServiceDAO(ServiceDAO serviceDAO) {
		this.serviceDAO = serviceDAO;
	}
	
	/**
	 * phuong thuc lay danh sach tat ca dich vu
	 * 
	 * @return
	 */
	public List<?> getAllService() {
    	
		StringBuilder builder = new StringBuilder();
		builder.append("from ServiceModel");
    	
    	return serviceDAO.getAllService(builder.toString());
    }
	
	/**
     * phuong thuc lay dich vu theo ma DV
     * 
     * @param maDV kieu <code>String</code>
     * @return
     */
	public ServiceModel getService(String maDV) {
    	
		StringBuilder builder = new StringBuilder();
		builder.append("select s from ServiceModel s where s.maDV = :maDV");
    	
    	return serviceDAO.getService(maDV, builder.toString());
    }
	
	/**
     * phuong thuc tim kiem dich vu theo ten dich vu
     * 
     * @param tenDV kieu <code>String</code>
     * @return
     */
	public List<?> getServiceByName(String tenDV) {
    	
		StringBuilder builder = new StringBuilder();
		builder.append("select s from ServiceModel s ");
		
		// Xu ly query string neu searchString khong rong
		if (null != tenDV && !Constants.EMPTY_STRING.equals(tenDV.trim())) {
			builder.append("where tenDV like :tenDV");
		}
		
    	return serviceDAO.getServiceByName(tenDV, builder.toString());
    }
	
	/**
	 * phuong thuc them dich vu
	 * 
	 * @param serviceModel kieu <code>ServiceModel</code>
	 * @return
	 */
	public int addService(ServiceModel serviceModel) {
		
		StringBuilder builder = new StringBuilder();
		builder.append("insert into dichvu values(:maDV, :tenDV, :giaDV)");
				
		return serviceDAO.addService(serviceModel, builder.toString());
	}
	
	/**
     * phuong thuc chinh sua dich vu
     * 
     * @param serviceModel kieu <code>ServiceModel</code>
     * @return
     */
	public int editService(ServiceModel serviceModel) {
		
		StringBuilder builder = new StringBuilder();
		builder.append("update ServiceModel s set tenDV = :tenDV, giaDV = :giaDV ");
		builder.append("where maDV = :maDV");
				
		return serviceDAO.editService(serviceModel, builder.toString());
	}
	
	/**
     * phuong thuc xoa dich vu
     * 
     * @param maDV kieu <code>String</code>
     * @return
     */
	public int removeService(String maDV) {
		
		StringBuilder builder = new StringBuilder();
		builder.append("delete from ServiceModel where maDV = :maDV");
				
		return serviceDAO.removeService(maDV, builder.toString());
	}
	
	/**
     * phuong thuc kiem tra dich vu co duy nhat hay khong
     * 
     * @param serviceModel kieu <code>ServiceModel</code>
     * @return
     */
	@SuppressWarnings("unchecked")
	public boolean isUnique(ServiceModel serviceModel) {
		
		List<ServiceModel> serviceList = (List<ServiceModel>) getAllService();
		
		boolean isUnique = true;
		
		for (ServiceModel service : serviceList) {
			if (service.equals(serviceModel)) {
				isUnique = false;
				break;
			}
		}
				
		return isUnique;
	}
}
