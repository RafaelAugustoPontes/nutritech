package br.com.nutritech.service;

import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nutritech.dto.response.MotivationalQuoteResponse;
import br.com.nutritech.model.MotivationalQuote;
import br.com.nutritech.repository.MotivationalQuoteRepository;

@Service
public class MotivationalQuoteService {

	@Autowired
	private MotivationalQuoteRepository motivationalQuoteRepository;

	private ModelMapper modelMapper = new ModelMapper();

	public MotivationalQuoteResponse findRandom() {
		Long count = motivationalQuoteRepository.count();
		Random random = new Random();
		int randomId = random.nextInt(count.intValue() + 1);
		if (randomId == 0)
			randomId = 1;
		
		MotivationalQuote motivationalQuote = motivationalQuoteRepository.getOne(randomId);

		return modelMapper.map(motivationalQuote, MotivationalQuoteResponse.class);
	}

}
