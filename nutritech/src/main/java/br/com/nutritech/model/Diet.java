package br.com.nutritech.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DIET")
public class Diet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String url;
	
	//AQUI TEREMOS TODOS OS TIPOS DE DIETA PARA O SISTEMA SABER QUAL GERAR
	@Enumerated(EnumType.STRING)
	private DietType type;

	@OneToMany(mappedBy = "diet")
	private Set<UserDiet> userDiets;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Set<UserDiet> getUserDiets() {
		return userDiets;
	}

	public void setUserDiets(Set<UserDiet> userDiets) {
		this.userDiets = userDiets;
	}

}
