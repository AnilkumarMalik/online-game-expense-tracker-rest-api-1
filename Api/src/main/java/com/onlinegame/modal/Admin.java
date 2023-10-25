package com.onlinegame.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Admin {
	
	@Id
	@Column(name = "id")
	private Integer Aid = 917;
	private String full_name = "Anil Kumar";
	private String email = "anilkumar.malik7327@gmail.com";
	private long mobile = 9178954497l;
	private String password = "kumar@91";
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getAid() {
		return Aid;
	}

	public void setAid(Integer aid) {
		Aid = aid;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
