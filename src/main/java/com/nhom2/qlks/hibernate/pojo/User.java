package com.nhom2.qlks.hibernate.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "ho_ten")
	private String hoTen;
	
	@Column(name = "ngay_sinh")
	private Date ngaySinh;
	
	@Column(name = "gioi_tinh")
	private String gioiTinh;
	
	@Column(name = "cmnd")
	private String cmnd;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "sdt", nullable = false)
	private String sdt;
	
	@Column(name = "ten_dang_nhap", nullable = false)
	private String tenDangNhap;
	
	@Column(name = "mat_khau", nullable = false)
	private String matKhau;
	
	@Column(name = "kich_hoat", nullable = false)
	private boolean kichHoat;
	
	@Column(name = "id_quyen")
	private int idQuyen;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public boolean isKichHoat() {
		return kichHoat;
	}

	public void setKichHoat(boolean kichHoat) {
		this.kichHoat = kichHoat;
	}

	public int getIdQuyen() {
		return idQuyen;
	}

	public void setIdQuyen(int idQuyen) {
		this.idQuyen = idQuyen;
	}
}
