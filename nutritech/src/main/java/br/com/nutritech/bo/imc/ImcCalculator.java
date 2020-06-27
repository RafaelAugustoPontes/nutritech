package br.com.nutritech.bo.imc;

import java.math.BigDecimal;

public class ImcCalculator {

	private BigDecimal height;
	private BigDecimal weight;

	public ImcCalculator(BigDecimal height, BigDecimal weight) {
		this.height = height;
		this.weight = weight;
	}

	public Imc calculate() {
		Double imc = weight.doubleValue() / (height.doubleValue() * height.doubleValue());

		ImcStatus imcStatus = ImcStatus.find(imc);
		return new Imc(new BigDecimal(imc), imcStatus);
	}

}
