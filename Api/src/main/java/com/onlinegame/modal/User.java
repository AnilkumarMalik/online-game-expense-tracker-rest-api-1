package com.onlinegame.modal;





import java.time.LocalDateTime;
import java.util.Objects;

import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	generator = "user_sequence")
	private Integer id;
	@NotNull
	private String full_name;
	@NotNull
	@Column(name = "email",unique = true)
	private String email;
	@NotNull
	@Column(name = "mobile",unique = true,length = 10)
	private String mobile;
	@NotNull
	private String password;
	@CreationTimestamp
	@Column(name = "created_at",updatable = true)
	private LocalDateTime timeStamp;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", full_name=" + full_name + ", email=" + email + ", mobile=" + mobile + ", password="
				+ password + ", timeStamp=" + timeStamp + "]";
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(email, full_name, id, mobile, password, timeStamp);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(full_name, other.full_name)
				&& Objects.equals(id, other.id) && mobile == other.mobile && Objects.equals(password, other.password)
				&& Objects.equals(timeStamp, other.timeStamp);
	}
	
	
	
}
