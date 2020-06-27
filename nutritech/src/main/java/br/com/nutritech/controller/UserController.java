package br.com.nutritech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nutritech.dto.request.UserRegisterRequest;
import br.com.nutritech.dto.response.UserIMCResponse;
import br.com.nutritech.dto.response.UserProfileResponse;
import br.com.nutritech.model.User;
import br.com.nutritech.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public void createUser(@RequestBody UserRegisterRequest request) {
		userService.createUser(request);
	}
	
	@GetMapping
	public UserProfileResponse getUserProfile() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) auth.getPrincipal();
		return userService.getUserProfile(user);
	}

	@GetMapping("/imc")
	public UserIMCResponse getIMC() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) auth.getPrincipal();
		return userService.calculateIMC(user);
	}

}
