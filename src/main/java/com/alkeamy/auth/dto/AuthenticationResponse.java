package com.alkeamy.auth.dto;


public class AuthenticationResponse {
	private String jwt;

	public AuthenticationResponse(String jwt) {
		super();
		this.setJwt(jwt);
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
	
}
