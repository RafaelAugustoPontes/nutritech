package br.com.nutritech.bo.gastoenergetico;

import java.math.BigDecimal;

import br.com.nutritech.model.Gender;

public class GastoEnergeticoCalculator {

	private BigDecimal height;
	private BigDecimal weight;
	private Integer age;
	private Gender gender;

	public GastoEnergeticoCalculator(BigDecimal height, BigDecimal weight, Integer age, Gender gender) {
		this.height = height;
		this.weight = weight;
		this.age = age;
		this.gender = gender;
	}

	public Double execute() {
		if (Gender.MASCULINO.equals(this.gender)) {
			Double resultado = 66 + (13.7 * weight.doubleValue()) + (5.0 * height.doubleValue()) - (6.8 * age);

			return resultado;
		}
		return 665 + (9.6 * weight.doubleValue()) + (1.8 * height.doubleValue()) - (4.7 * age);
	}

}
