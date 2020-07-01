package br.com.nutritech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nutritech.bo.gastoenergetico.GastoEnergeticoCalculator;
import br.com.nutritech.dto.response.DietResponse;
import br.com.nutritech.model.Diet;
import br.com.nutritech.model.DietType;
import br.com.nutritech.model.User;
import br.com.nutritech.model.Weight;
import br.com.nutritech.repository.DietRepository;

@Service
public class DietService {

	@Autowired
	private WeigthService weigthService;

	@Autowired
	private DietRepository repository;

	public DietResponse chooseDiet(User user) {
		Weight lastWeightByUser = weigthService.findLastWeightByUser(user);
		GastoEnergeticoCalculator calculator = new GastoEnergeticoCalculator(user.getHeight(),
				lastWeightByUser.getValue(), user.getIdade(), user.getGender());
		Double gastoEnergetico = calculator.execute();
		Diet diet = getDiet(user.getIsVegetarian(), gastoEnergetico);

		return new DietResponse(diet.getUrl());
	}

	private Diet getDiet(boolean isVegetarian, double gastoEnergetico) {
		if (gastoEnergetico <= 1400) {
			if (isVegetarian)
				return repository.findByType(DietType.VEGERATIAN_1200);
			return repository.findByType(DietType.NORMAL_1200);
		}

		if (gastoEnergetico > 1400 && gastoEnergetico <= 1600) {
			if (isVegetarian)
				return repository.findByType(DietType.VEGERATIAN_1400);
			return repository.findByType(DietType.NORMAL_1400);
		}

		if (isVegetarian)
			return repository.findByType(DietType.VEGERATIAN_1600);
		return repository.findByType(DietType.NORMAL_1600);
	}

}
