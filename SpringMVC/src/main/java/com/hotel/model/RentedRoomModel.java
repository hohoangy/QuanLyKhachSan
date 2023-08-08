package com.hotel.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Tien
 * 
 * class RentedRoomModel
 */
@Entity
@Table(name = "thuephong")
public class RentedRoomModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "MaKH")
	private int maKH;
	@Column(name = "NgayDen")
	private Date ngayDen;
	@Column(name = "NgayDi")
	private Date ngayDi;
	@Id
	@Column(name = "MaPhong")
	private String maPhong;
	@Id
	@Column(name = "MaNV")
	private String maNV;
	@Column(name = "TrangThai")
	private int trangThai;
	@Column(name = "NgayThucHien")
	private Date ngayThucHien;
	@ManyToOne
	@JoinColumn(name = "MaKH")
	private CustomerModel customer;
	@ManyToOne
	@JoinColumn(name = "MaPhong")
	private RoomModel room;
	@ManyToOne
	@JoinColumn(name = "MaNV")
	private EmployeeModel employee;
	
	public int getMaKH() {
		return maKH;
	}

	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}

	public Date getNgayDen() {
		return ngayDen;
	}

	public void setNgayDen(Date ngayDen) {
		this.ngayDen = ngayDen;
	}

	public Date getNgayDi() {
		return ngayDi;
	}

	public void setNgayDi(Date ngayDi) {
		this.ngayDi = ngayDi;
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public Date getNgayThucHien() {
		return ngayThucHien;
	}

	public void setNgayThucHien(Date ngayThucHien) {
		this.ngayThucHien = ngayThucHien;
	}

	public CustomerModel getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerModel customer) {
		this.customer = customer;
	}

	public RoomModel getRoom() {
		return room;
	}

	public void setRoom(RoomModel room) {
		this.room = room;
	}
}
