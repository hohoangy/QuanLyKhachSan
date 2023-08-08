package com.hotel.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nhanvien")
public class EmployeeModel implements Serializable{
		
		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "MaNV")
		private String maNV;
		@Column(name = "TenNV")
		private String tenNV;
		@Column(name = "NgaySinh")
		private Date ngaySinh;
		@Column(name = "GioiTinh")
		private boolean gioiTinh;
		@Column(name = "SDT")
		private String sdt;
		@Column(name = "MatKhau")
		private String matKhau;
		@Column(name = "ChucVu")
		private String chucVu;
		@Column(name = "Luong")
		private long luong;
		@Column(name = "TinhTrang")
		private boolean tinhTrang;
		public String getMaNV() {
			return maNV;
		}
		public void setMaNV(String maNV) {
			this.maNV = maNV;
		}
		public String getTenNV() {
			return tenNV;
		}
		public void setTenNV(String tenNV) {
			this.tenNV = tenNV;
		}
		public Date getNgaySinh() {
			return ngaySinh;
		}
		public void setNgaySinh(Date ngaySinh) {
			this.ngaySinh = ngaySinh;
		}
		public boolean isGioiTinh() {
			return gioiTinh;
		}
		public void setGioiTinh(boolean gioiTinh) {
			this.gioiTinh = gioiTinh;
		}
		public String getSdt() {
			return sdt;
		}
		public void setSdt(String sdt) {
			this.sdt = sdt;
		}
		public String getMatKhau() {
			return matKhau;
		}
		public void setMatKhau(String matKhau) {
			this.matKhau = matKhau;
		}
		public String getChucVu() {
			return chucVu;
		}
		public void setChucVu(String chucVu) {
			this.chucVu = chucVu;
		}
		public long getLuong() {
			return luong;
		}
		public void setLuong(long luong) {
			this.luong = luong;
		}
		public boolean isTinhTrang() {
			return tinhTrang;
		}
		public void setTinhTrang(boolean tinhTrang) {
			this.tinhTrang = tinhTrang;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		
}
