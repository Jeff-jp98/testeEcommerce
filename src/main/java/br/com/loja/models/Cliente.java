package br.com.loja.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.loja.dto.ClienteDTOForm;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String email;
	private String nome;
	private String senha;
	private String cpf;
	@OneToMany(fetch = FetchType.EAGER)
	private List<Endereco> enderecos = new ArrayList<Endereco>();
	
	public Cliente() {
		
	}

	public Cliente(ClienteDTOForm c) {
		this.email = c.getEmail();
		this.nome = c.getNome();
		this.senha = new BCryptPasswordEncoder().encode(c.getSenha());
		this.cpf = c.getCpf();
		this.enderecos.add(c.getEnderecos());
	}
	
	public Long getId() {
		return Id;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSenha() {
		return senha;
	}

	public String getCpf() {
		return cpf;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	
}
