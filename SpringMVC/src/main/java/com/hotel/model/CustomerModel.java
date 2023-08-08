package com.hotel.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Tien
 * 
 * class CustomerModel
 */
@Entity
@Table(name = "khachhang")
public class CustomerModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MaKH")
	private int maKH;
	@Column(name="TenKH")
	private String tenKH;
	@Column(name="CMND")
	private String cmnd;
	@Column(name="SDT")
	private String sdt;
	@Column(name="QuocTich")
	private String quocTich;
	@Column(name="VIP")
	private boolean vip;
	
	
	
	public int getMaKH() {
		return maKH;
	}

	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getQuocTich() {
		return quocTich;
	}

	public void setQuocTich(String quocTich) {
		this.quocTich = quocTich;
	}

	public boolean getVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}
}
