package br.com.loja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.dto.ProdutoDTO;
import br.com.loja.dto.ProdutoDTOForm;
import br.com.loja.models.Produto;
import br.com.loja.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository; 
	
	public List<ProdutoDTO> listar(){
		List<Produto> resultList = repository.findAll();
		return ProdutoDTO.converter(resultList);
	}
	
	public Produto salvar(ProdutoDTOForm p) {
		return repository.save(new Produto(p));
	}
	
	public ProdutoDTO getOne(Long id) {
		return new ProdutoDTO(repository.getOne(id));
	}
	
}
