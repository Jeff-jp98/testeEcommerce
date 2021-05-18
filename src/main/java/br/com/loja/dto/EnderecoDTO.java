package br.com.loja.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.loja.models.Endereco;

public class EnderecoDTO {

	private String endereco;

	public EnderecoDTO(Endereco e) {
		this.endereco = e.getCidade()+", "+e.getBairro()+", "+e.getRua()+", "+e.getNumero();
	}

	public String getEndereco() {
		return endereco;
	}
	
	public static List<EnderecoDTO> converter (List<Endereco> enderecos){
		List<EnderecoDTO> lista = new ArrayList<EnderecoDTO>();
		for(Endereco e: enderecos) {
			lista.add(new EnderecoDTO(e));
		}
		return lista;
	}
	
}
