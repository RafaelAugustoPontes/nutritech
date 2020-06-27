package br.com.nutritech.bo.imc;

import java.math.BigDecimal;

public class Imc {

	private BigDecimal value;
	private ImcStatus status;

	public Imc(BigDecimal value, ImcStatus status) {
		this.value = value;
		this.status = status;
	}

	public BigDecimal getValue() {
		return value;
	}

	public ImcStatus getStatus() {
		return status;
	}

	public String getDescription() {
		return status.getDescription();
	}

}
