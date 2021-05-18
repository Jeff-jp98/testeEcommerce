package br.com.loja.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.loja.dto.EnderecoDTOForm;

@Entity
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String bairro;
	private String rua;
	private String cidade;
	private String estado;
	private String cep;
	private String numero;
	
	public Endereco() {
		
	}
	public Endereco(EnderecoDTOForm e) {
		this.bairro = e.getBairro();
		this.rua = e.getRua();
		this.cidade = e.getCidade();
		this.estado = e.getEstado();
		this.cep = e.getCep();
		this.numero = e.getNumero();
	}

	public Long getId() {
		return id;
	}

	public String getBairro() {
		return bairro;
	}

	public String getRua() {
		return rua;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public String getCep() {
		return cep;
	}

	public String getNumero() {
		return numero;
	}
	
	

}
