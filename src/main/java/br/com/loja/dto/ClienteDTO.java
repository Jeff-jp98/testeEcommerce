package br.com.loja.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.loja.models.Cliente;
import br.com.loja.models.Endereco;

public class ClienteDTO {
	
	private Long id;
	private String nome;
	private List<Endereco> enderecos = new ArrayList<Endereco>();
	
	public ClienteDTO(Cliente cliente) {
		this.id=cliente.getId();
		this.nome = cliente.getNome();
		this.enderecos = cliente.getEnderecos();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
	public static List<ClienteDTO> converter (List<Cliente> clientes){
		List<ClienteDTO> lista = new ArrayList<ClienteDTO>();
		for(Cliente c: clientes) {
			lista.add(new ClienteDTO(c));
		}
		return lista;
	}
}
