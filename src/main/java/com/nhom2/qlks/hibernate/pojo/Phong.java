package com.nhom2.qlks.hibernate.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phong")
public class Phong implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_phong", nullable = false)
	private int idPhong;
	
	@Column(name = "ten_phong", nullable = false)
	private String tenPhong;
	
	@Column(name = "id_loai_phong", nullable = false)
	private int idLoaiPhong;
	
	@Column(name = "id_trang_thai", nullable = false)
	private int idTrangThai;

	public int getIdPhong() {
		return idPhong;
	}

	public void setIdPhong(int idPhong) {
		this.idPhong = idPhong;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public int getIdLoaiPhong() {
		return idLoaiPhong;
	}

	public void setIdLoaiPhong(int idLoaiPhong) {
		this.idLoaiPhong = idLoaiPhong;
	}

	public int getIdTrangThai() {
		return idTrangThai;
	}

	public void setIdTrangThai(int idTrangThai) {
		this.idTrangThai = idTrangThai;
	}
}
