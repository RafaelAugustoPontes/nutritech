package br.com.nutritech.model;

public enum DietType {

	NORMAL_1200(false), NORMAL_1400(false), NORMAL_1600(false), VEGERATIAN_1200(true), VEGERATIAN_1400(true),
	VEGERATIAN_1600(true);

	private boolean isVegetarian;

	private DietType(boolean isVegetarian) {
		this.isVegetarian = isVegetarian;
	}

	public boolean isVegetarian() {
		return isVegetarian;
	}

}
