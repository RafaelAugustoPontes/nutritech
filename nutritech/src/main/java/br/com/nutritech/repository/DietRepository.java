package br.com.nutritech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nutritech.model.Diet;
import br.com.nutritech.model.DietType;

public interface DietRepository extends JpaRepository<Diet, Integer> {
	
	public Diet findByType(DietType type);

}
