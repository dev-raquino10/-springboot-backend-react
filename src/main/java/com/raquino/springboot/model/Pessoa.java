package com.raquino.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "pessoas")
public class Pessoa {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name= "nome")
	private String nome;
		
	@Column(name= "tipo")
	private String tipo;
	
	@Column(name= "grupo")
	private String grupo;
	
	
	public Pessoa() {
		
	}


	public Pessoa(String nome, String tipo, String grupo) {
		super();
		this.nome = nome;
		this.tipo = tipo;
		this.grupo = grupo;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo= tipo;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	

}

