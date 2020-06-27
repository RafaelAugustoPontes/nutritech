package br.com.nutritech.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.nutritech.model.Gender;

public class UserProfileResponse {

	private String fullname;
	private String email;
	private LocalDate birthdate;
	private Gender gender;
	private BigDecimal height;
	private Boolean isVegetarian;

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	
	public BigDecimal getHeight() {
		return height;
	}
	
	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getIsVegetarianDescription() {
		return isVegetarian ? "Sim" : "Não";
	}

	public void setIsVegetarian(Boolean isVegetarian) {
		this.isVegetarian = isVegetarian;
	}

}
