package br.com.nutritech.security;


import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.nutritech.model.User;
import br.com.nutritech.repository.UserRepository;

public class AutenticacaoFilter extends OncePerRequestFilter{

	private TokenService tokenService;
	private UserRepository userRepository;

	public AutenticacaoFilter(TokenService tokenService, UserRepository usuarioRepository) {
		this.tokenService = tokenService;
		this.userRepository = usuarioRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = extracted(request);
		boolean valido = tokenService.isTokenValido(token);
		
		if (valido) {
			autenticarCliente(token);
		}

		filterChain.doFilter(request, response);
	}

	private void autenticarCliente(String token) {
		Integer idUsuario = tokenService.getIdUser(token);
		Optional<User> usuario = userRepository.findById(idUsuario);
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario.get(), null, Collections.emptyList());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	private String extracted(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if (token == null || token.isEmpty())
			return null;
		
		return token;
	}

}
