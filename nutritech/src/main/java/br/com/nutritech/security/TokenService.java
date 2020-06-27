package br.com.nutritech.security;


import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.nutritech.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	@Value("${forum.jwt.expiration}")
	private String expiration;
	
	@Value("${forum.jwt.secret}")
	private String secret;

	public String gerarToken(Authentication authentication) {
		User principal = (User) authentication.getPrincipal();
		Date iat = new Date();
		Date dataExpiracao = new Date(iat.getTime() + Long.parseLong(expiration));
		return Jwts.builder()
		.setIssuer(principal.getFullname())
		.setSubject(principal.getId().toString())
		.setIssuedAt(iat)
		.setExpiration(dataExpiracao)
		.signWith(SignatureAlgorithm.HS256, secret)
		.compact();
	}

	public boolean isTokenValido(String token) {
		try {
			Jwts.parser()
				.setSigningKey(secret)
				.parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Integer getIdUser(String token) {
		Claims body = Jwts.parser()
		.setSigningKey(secret)
		.parseClaimsJws(token)
		.getBody();
		
		return Integer.valueOf(body.getSubject());
	}

}
