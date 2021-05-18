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

import br.com.loja.dto.ClienteDTO;
import br.com.loja.dto.ClienteDTOForm;
import br.com.loja.dto.EnderecoDTOForm;
import br.com.loja.models.Cliente;
import br.com.loja.models.Endereco;
import br.com.loja.service.ClienteService;
import br.com.loja.service.EnderecoService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	@Autowired
	private EnderecoService enderecoService;
	
	@RequestMapping("/cadastro")
	public String cadastro() {
		return "clienteForm";
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<ClienteDTO> salvar(ClienteDTOForm cliente, EnderecoDTOForm endereco, UriComponentsBuilder uriBuilder){
		System.out.println("fui chamado");
		if(endereco==null) {
			System.out.println("não deu certo");
		}
		Endereco e = enderecoService.salvar(endereco);
		cliente.setEnderecos(e);
		Cliente c = clienteService.salvar(cliente);
		URI uri = uriBuilder.path("/cliente/resposta/{id}").buildAndExpand(c.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDTO(c));
	}
	
	@GetMapping(value = "/resposta/{id}")
	public ClienteDTO getCliente(@PathVariable Long id) {
		ClienteDTO result = clienteService.getOne(id);
		return result;
	}
	
}
