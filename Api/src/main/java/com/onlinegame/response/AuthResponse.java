package com.onlinegame.response;

public class AuthResponse {
	
	private String jwt;
	private boolean isAuth;
	
	
	
	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}



	public boolean isAuth() {
		return isAuth;
	}



	public void setAuth(boolean isAuth) {
		this.isAuth = isAuth;
	}



	public AuthResponse(String jwt, boolean isAuth) {
		super();
		this.jwt = jwt;
		this.isAuth = isAuth;
	}
	
	

}
