package br.com.nutritech.service;

import java.time.LocalDate;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.nutritech.bo.imc.Imc;
import br.com.nutritech.bo.imc.ImcCalculator;
import br.com.nutritech.dto.request.UserRegisterRequest;
import br.com.nutritech.dto.request.WeightRequest;
import br.com.nutritech.dto.response.UserIMCResponse;
import br.com.nutritech.dto.response.UserProfileResponse;
import br.com.nutritech.model.User;
import br.com.nutritech.model.Weight;
import br.com.nutritech.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private WeigthService weigthService;

	private ModelMapper modelMapper = new ModelMapper();

	@Transactional
	public void createUser(UserRegisterRequest request) {
		Optional<User> userExistent = userRepository.findByEmail(request.getEmail());
		if (userExistent.isPresent())
			throw new RuntimeException("Usuário já cadastrado");

		if (!request.getPassword().equals(request.getPasswordConfirmation()))
			throw new RuntimeException("Senhas não conferem");

		User user = modelMapper.map(request, User.class);
		String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
		user.setPassword(encryptedPassword);
		userRepository.save(user);

		weigthService.save(user, new WeightRequest(request.getWeight(), LocalDate.now()));
	}

	@Transactional
	public UserIMCResponse calculateIMC(User user) {
		Weight lastWeight = weigthService.findLastWeightByUser(user);
		ImcCalculator calculator = new ImcCalculator(user.getHeight(), lastWeight.getValue());

		Imc imc = calculator.calculate();
		UserIMCResponse response = new UserIMCResponse();
		response.setDescription(imc.getDescription());
		response.setValue(imc.getValue());

		return response;
	}

	public UserProfileResponse getUserProfile(User user) {
		return modelMapper.map(user, UserProfileResponse.class);
	}

}
