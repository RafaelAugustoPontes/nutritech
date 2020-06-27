package br.com.nutritech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nutritech.dto.response.MotivationalQuoteResponse;
import br.com.nutritech.service.MotivationalQuoteService;

@RestController
@RequestMapping("/motivational-quotes")
public class MotivationalQuoteController {

	@Autowired
	private MotivationalQuoteService service;

	@GetMapping
	public MotivationalQuoteResponse getRandom() {
		return service.findRandom();
	}

}
