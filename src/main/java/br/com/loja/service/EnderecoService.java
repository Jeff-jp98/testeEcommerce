package br.com.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.dto.EnderecoDTOForm;
import br.com.loja.models.Endereco;
import br.com.loja.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository; 
	
	public Endereco salvar(EnderecoDTOForm e) {
		return repository.save(new Endereco(e));
	}
}
