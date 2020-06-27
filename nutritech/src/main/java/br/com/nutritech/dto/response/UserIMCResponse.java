package br.com.nutritech.dto.response;

import java.math.BigDecimal;

import br.com.nutritech.util.DecimalUtil;

public class UserIMCResponse {

	private BigDecimal value;
	private String description;

	public BigDecimal getValue() {
		return value;
	}

	public String getValueFormatted() {
		return DecimalUtil.format(value);
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
