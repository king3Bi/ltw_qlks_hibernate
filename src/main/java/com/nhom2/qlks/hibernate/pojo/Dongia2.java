package com.nhom2.qlks.hibernate.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "giatien")
public class Dongia2 {
	
	private int idHD;

	private double giatien;
	private int iduser;
	private Date ngaytao;
	private String tenQuyen;
	private int booking;
	
	public Date getNgaytao() {
		return ngaytao;
	}
	public void setNgaytao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}
	public String getTenQuyen() {
		return tenQuyen;
	}
	public void setTenQuyen(String tenQuyen) {
		this.tenQuyen = tenQuyen;
	}
	public int getBooking() {
		return booking;
	}
	public void setBooking(int booking) {
		this.booking = booking;
	}
	public int getIdHD() {
		return idHD;
	}
	public void setIdHD(int idHD) {
		this.idHD = idHD;
	}
	public double getGiatien() {
		return giatien;
	}
	public void setGiatien(double giatien) {
		this.giatien = giatien;
	}
//	public Dongia2(Dongia2 dongia) {
//		this.id_giatien = dongia.id_giatien;
//		this.giatien=dongia.giatien;	
//	}
	
	public Dongia2(int idHD, int iduser,Date ngaytao,String tenquyen,double giatien,int booking) {
		this.idHD= idHD;
		this.giatien=giatien;
		this.iduser=iduser;
		this.ngaytao=ngaytao;
		this.tenQuyen=tenquyen;
		this.booking=booking;
	}
	public int getIduser() {
		return iduser;
	}
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	
	
}
