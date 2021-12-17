package com.nhom2.qlks.hibernate.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dongia")
public class dongia implements Serializable{
	@Column(name = "iddongia")
	private int id_giatien;
	@Column(name = "giatien")
	private float giatien;
	
	public int getId_giatien() {
		return id_giatien;
	}
	public void setId_giatien(int id_giatien) {
		this.id_giatien = id_giatien;
	}
	public float getGiatien() {
		return giatien;
	}
	public void setGiatien(float giatien) {
		this.giatien = giatien;
	}
	
}
