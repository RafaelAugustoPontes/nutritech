package br.com.nutritech.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;

public class WeightRequest {

	private BigDecimal value;
	private LocalDate date;

	public WeightRequest(BigDecimal value, LocalDate date) {
		this.value = value;
		this.date = date;
	}

	public WeightRequest() {
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}
