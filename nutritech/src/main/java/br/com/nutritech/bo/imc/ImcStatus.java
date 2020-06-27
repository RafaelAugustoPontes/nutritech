package br.com.nutritech.bo.imc;

public enum ImcStatus {

	SUBPESO_SEVERO("Subpeso severo"), 
	SUBPESO("Subpeso"), NORMAL("Normal"),
	SOBREPESO("Sobrepeso"), 
	OBESO("Obeso"),
	OBESO_MORBIDO("Obeso mórbido");

	private final String description;

	private ImcStatus(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public static ImcStatus find(Double imc) {
		if (imc < 16)
			return SUBPESO_SEVERO;
		if (imc >=16 && imc <= 19.9)
			return SUBPESO;
		if (imc >= 20 && imc <= 24.9)
			return NORMAL;
		if (imc >= 25 && imc <= 29.9)
			return SOBREPESO;
		if (imc >= 30 && imc <= 39.9)
			return OBESO;
		if (imc > 40)
			return OBESO_MORBIDO;

		throw new RuntimeException("Valor de IMC inválido");
	}

}
