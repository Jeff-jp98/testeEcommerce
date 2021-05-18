package br.com.loja.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.loja.dto.ProdutoDTO;
import br.com.loja.dto.ProdutoDTOForm;
import br.com.loja.models.Produto;
import br.com.loja.service.ProdutoService;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping("/cadastro")
	public String cadastro() {
		return "produtoForm";
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<ProdutoDTO> salvar(ProdutoDTOForm produto, UriComponentsBuilder uriBuilder){
		Produto p = produtoService.salvar(produto);
		URI uri = uriBuilder.path("/produto/resposta/{id}").buildAndExpand(p.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProdutoDTO(p));
	}
	
	@GetMapping(value = "resposta/{id}")
	public ProdutoDTO getProduto(@PathVariable Long id) {
		ProdutoDTO result = produtoService.getOne(id);
		return result;
	}
	
}
