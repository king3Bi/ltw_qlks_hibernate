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
@Table(name = "booking")
public class Booking implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_booking", nullable = false)
	private int idBooking;
	
	@Column(name = "so_nguoi")
	private int soNguoi;
	
	@Column(name = "co_nguoi_nuoc_ngoai")
	private boolean coNguoiNuocNgoai;
	
	@Column(name = "check_in", nullable = false)
	private Date checkIn;
	
	@Column(name = "check_out", nullable = false)
	private Date checkOut;
	
	@Column(name = "don_gia")
	private Float donGia;
	
	@Column(name = "dat_online")
	private boolean datOnline;
	
	@ManyToOne
	@JoinColumn(name = "id_KH")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "id_HD")
	private HoaDon hoaDon;
	
	@ManyToOne
	@JoinColumn(name = "id_phong", nullable = false)
	private Phong phong;
	
	@OneToMany(mappedBy = "booking")
	private List<KhachHang> khachHangs;

	public int getIdBooking() {
		return idBooking;
	}

	public void setIdBooking(int idBooking) {
		this.idBooking = idBooking;
	}

	public int getSoNguoi() {
		return soNguoi;
	}

	public void setSoNguoi(int soNguoi) {
		this.soNguoi = soNguoi;
	}

	public boolean isCoNguoiNuocNgoai() {
		return coNguoiNuocNgoai;
	}

	public void setCoNguoiNuocNgoai(boolean coNguoiNuocNgoai) {
		this.coNguoiNuocNgoai = coNguoiNuocNgoai;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	public Float getDonGia() {
		return donGia;
	}

	public void setDonGia(Float donGia) {
		this.donGia = donGia;
	}

	public boolean isDatOnline() {
		return datOnline;
	}

	public void setDatOnline(boolean datOnline) {
		this.datOnline = datOnline;
	}
	
	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public Phong getPhong() {
		return phong;
	}

	public void setPhong(Phong phong) {
		this.phong = phong;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<KhachHang> getKhachHangs() {
		return khachHangs;
	}

	public void setKhachHangs(List<KhachHang> khachHangs) {
		this.khachHangs = khachHangs;
	}
	
}
