package br.com.nutritech.dto;

public class TokenDTO {

	private String token;
	private String username;

	public TokenDTO(String token, String username) {
		this.token = token;
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public String getUsername() {
		return username;
	}

}
