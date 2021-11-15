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
	
	@Column(name = "id_KH")
	private int idKH;
	
	@Column(name = "id_HD")
	private int idHD;
	
	@Column(name = "id_phong", nullable = false)
	private int idPhong;

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

	public int getIdHD() {
		return idHD;
	}

	public void setIdHD(int idHD) {
		this.idHD = idHD;
	}

	public int getIdPhong() {
		return idPhong;
	}

	public void setIdPhong(int idPhong) {
		this.idPhong = idPhong;
	}

	public int getIdKH() {
		return idKH;
	}

	public void setIdKH(int idKH) {
		this.idKH = idKH;
	}
	
}
