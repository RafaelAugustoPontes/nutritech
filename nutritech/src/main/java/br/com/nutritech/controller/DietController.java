package br.com.nutritech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nutritech.dto.response.DietResponse;
import br.com.nutritech.model.User;
import br.com.nutritech.service.DietService;

@RestController
@RequestMapping("/diets")
public class DietController {

	@Autowired
	private DietService dietService;

	@GetMapping
	public DietResponse getDiet() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) auth.getPrincipal();
		return dietService.chooseDiet(user);
	}

}
