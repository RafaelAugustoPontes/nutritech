package br.com.nutritech.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.nutritech.dto.request.WeightRequest;
import br.com.nutritech.dto.response.WeightResponse;
import br.com.nutritech.model.User;
import br.com.nutritech.model.Weight;
import br.com.nutritech.repository.WeigthRepository;

@Service
public class WeigthService {

	@Autowired
	private WeigthRepository weigthRepository;

	private ModelMapper modelMapper = new ModelMapper();

	public List<WeightResponse> findByUser(User user) {
		List<Weight> weights = weigthRepository.findByUserId(user.getId());
		return weights.stream().map(weight -> modelMapper.map(weight, WeightResponse.class))
				.collect(Collectors.toList());
	}
	
	public Weight findLastWeightByUser(User user) {
		return weigthRepository.findFirstByUserIdOrderByIdDesc(user.getId());
	}

	@Transactional
	public void save(User user, WeightRequest request) {
		Weight weight = new ModelMapper().map(request, Weight.class);
		weight.setUser(user);

		weigthRepository.save(weight);
	}

	@Transactional
	public void delete(Integer id) {
		weigthRepository.deleteById(id);
	}

}
