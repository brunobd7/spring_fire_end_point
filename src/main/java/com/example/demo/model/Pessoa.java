package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="pessoas")
//@SequenceGenerator(name = "PESSOAS_ID_SEQ" , sequenceName = "PESSOAS_ID_SEQ")
public class Pessoa {

	@Id
	@GeneratedValue(generator ="PESSOAS_ID_SEQ")
	@GenericGenerator(name = "PESSOAS_ID_SEQ", strategy = "increment")
//	@SequenceGenerator(name = "PESSOAS_ID_SEQ" , sequenceName = "PESSOAS_ID_SEQ", allocationSize = 1)
	private Integer id;
	
	@Size(min=3, max =50)
	private String nome;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
