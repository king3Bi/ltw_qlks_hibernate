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
@Table(name = "hoa_don")
public class HoaDon implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_HD", nullable = false)
	private int idHD;
	
	@Column(name = "ngay_tao")
	private Date ngayTao;
	
	@Column(name = "id_user", nullable = false)
	private int idUser;

	public int getIdHD() {
		return idHD;
	}

	public void setIdHD(int idHD) {
		this.idHD = idHD;
	}

	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
}
