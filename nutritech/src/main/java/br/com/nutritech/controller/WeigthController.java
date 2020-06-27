package br.com.nutritech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nutritech.dto.request.WeightRequest;
import br.com.nutritech.dto.response.WeightResponse;
import br.com.nutritech.model.User;
import br.com.nutritech.service.WeigthService;

@RestController
@RequestMapping("/weigths")
public class WeigthController {

	@Autowired
	private WeigthService weightService;

	@GetMapping
	public List<WeightResponse> findAll() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) auth.getPrincipal();
		return weightService.findByUser(user);
	}

	@PostMapping
	public void save(@RequestBody WeightRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) auth.getPrincipal();
		weightService.save(user, request);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		weightService.delete(id);
	}

}
