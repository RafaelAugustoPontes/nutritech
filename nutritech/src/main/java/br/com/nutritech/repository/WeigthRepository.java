package br.com.nutritech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nutritech.model.Weight;

public interface WeigthRepository extends JpaRepository<Weight, Integer> {

	List<Weight> findByUserId(Integer id);

	Weight findFirstByUserIdOrderByIdDesc(Integer id);

}
