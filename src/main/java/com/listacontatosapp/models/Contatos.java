package com.listacontatosapp.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Contatos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull(message = "O nome do contato não poder ser nulo")
	@NotEmpty(message = "O nome do contato não poder ser vazio")
	private String nome;
	
	@NotNull(message = "O e-mail do contato não poder ser nulo")
	@NotEmpty(message = "O e-mail do contato não poder ser vazio")
	private String email;
	
	@NotNull(message = "O numero do contato não poder ser nulo")
	@NotEmpty(message = "O numero do contato não poder ser vazio")
	private String contato;
	
	@NotNull(message = "O recado não poder ser nulo")
	@NotEmpty(message = "O recado não poder ser vazio")
	private String recado;
	private String endereco;
	private String cidade;
	private String estado;
	private String numeroCasa;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public String getRecado() {
		return recado;
	}
	public void setRecado(String recado) {
		this.recado = recado;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getNumeroCasa() {
		return numeroCasa;
	}
	public void setNumeroCasa(String numeroCasa) {
		this.numeroCasa = numeroCasa;
	}
	
	
}
