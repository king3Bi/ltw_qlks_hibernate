package com.nhom2.qlks.hibernate.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

	public int getKichHoat() {
		return kichHoat;
	}

	public void setKichHoat(int kichHoat) {
		this.kichHoat = kichHoat;
	}

	@Column(name = "mat_khau", nullable = false)
	private String matKhau;
	
	@Column(name = "kich_hoat", nullable = false)
	private int kichHoat;
	
	@ManyToOne
	@JoinColumn(name = "id_quyen")
	private Quyen quyen;
	
	@OneToMany(mappedBy = "user")
	private List<Booking> bookings;
	
	@OneToMany(mappedBy = "user")
	private List<HoaDon> hoaDons;

	public User() {}
	public User(String hoten, Date ngaysinh,String gioitinh,String cmnd,String email,String sdt,String tendn,String mk,int kichhoat,Quyen quyen) {
	
		this.hoTen = hoten;
		this.ngaySinh = ngaysinh;
		this.gioiTinh=gioitinh;
		this.cmnd = cmnd;
		this.email = email;
		this.sdt = sdt;
		this.tenDangNhap = tendn;
		this.matKhau = mk;
		this.kichHoat = kichhoat;
		this.quyen = quyen;
	}
	
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

//	public boolean isKichHoat() {
//		return kichHoat;
//	}
//
//	public void setKichHoat(boolean kichHoat) {
//		this.kichHoat = kichHoat;
//	}

	public Quyen getQuyen() {
		return quyen;
	}

	public void setQuyen(Quyen quyen) {
		this.quyen = quyen;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public List<HoaDon> getHoaDons() {
		return hoaDons;
	}

	public void setHoaDons(List<HoaDon> hoaDons) {
		this.hoaDons = hoaDons;
	}
	
}
