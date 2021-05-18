package br.com.loja.dto;

import br.com.loja.models.Endereco;

public class ClienteDTOForm {
	
	private String email;
	private String nome;
	private String senha;
	private String cpf;
	private Endereco endereco;
	
	public ClienteDTOForm(String email, String nome, String senha, String cpf, Endereco endereco) {
		this.email = email;
		this.nome = nome;
		this.senha = senha;
		this.cpf = cpf;
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEnderecos() {
		return endereco;
	}

	public void setEnderecos(Endereco endereco) {
		this.endereco = endereco;
	}
	

}
