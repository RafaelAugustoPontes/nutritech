package br.com.nutritech.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nutritech.dto.LoginDTO;
import br.com.nutritech.dto.TokenDTO;
import br.com.nutritech.model.User;
import br.com.nutritech.security.TokenService;


@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private TokenService tokenService;

	@PostMapping
	public ResponseEntity<?> autenticar(@RequestBody LoginDTO loginForm) {
		try {
			UsernamePasswordAuthenticationToken dadosLogin = loginForm.converter();
			Authentication authentication = authManager.authenticate(dadosLogin);
			User principal = (User) authentication.getPrincipal();
			String token = tokenService.gerarToken(authentication);
			return ResponseEntity.ok(new TokenDTO(token, principal.getFullname()));
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
	}

}
