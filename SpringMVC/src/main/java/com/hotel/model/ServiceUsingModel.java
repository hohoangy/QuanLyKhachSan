package com.hotel.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Tien
 *
 * class ServiceUsingModel
 */
@Entity
@Table(name = "sddv")
public class ServiceUsingModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MaKH")
	private int maKH;
	@Id
	@Column(name = "MaDV")
	private String maDV;
	@Id
	@Column(name = "MaPhong")
	private String maPhong;
	@Column(name = "ngaySD")
	private Date ngaySD;
	@Column(name = "TrangThai")
	private int trangThai;
	@Column(name = "SoLuong")
	private int soLuong;
	@ManyToOne
	@JoinColumn(name="MaKH")
	private CustomerModel customer;
	@ManyToOne
	@JoinColumn(name="MaDV")
	private ServiceModel service;
	@ManyToOne
	@JoinColumn(name="MaPhong")
	private RoomModel room;
	
	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getMaKH() {
		return maKH;
	}

	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}

	public String getMaDV() {
		return maDV;
	}

	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}

	public Date getNgaySD() {
		return ngaySD;
	}

	public void setNgaySD(Date ngaySD) {
		this.ngaySD = ngaySD;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public CustomerModel getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerModel customer) {
		this.customer = customer;
	}

	public ServiceModel getService() {
		return service;
	}

	public void setService(ServiceModel service) {
		this.service = service;
	}

	public RoomModel getRoom() {
		return room;
	}

	public void setRoom(RoomModel room) {
		this.room = room;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maDV, maKH, maPhong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServiceUsingModel other = (ServiceUsingModel) obj;
		return Objects.equals(maDV, other.maDV) && maKH == other.maKH && Objects.equals(maPhong, other.maPhong);
	}
}
