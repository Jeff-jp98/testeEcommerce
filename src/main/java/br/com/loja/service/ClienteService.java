package br.com.loja.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.dto.ClienteDTO;
import br.com.loja.dto.ClienteDTOForm;
import br.com.loja.models.Cliente;
import br.com.loja.models.Usuario;
import br.com.loja.repository.ClienteRepository;
import br.com.loja.repository.UsuarioRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	@Autowired
	private UsuarioRepository uRepository;
	
	public Cliente salvar(ClienteDTOForm c) {
		Cliente cliente = repository.save(new Cliente(c));
		criaUsuario(c, cliente);
		return cliente;
	}
	
	public ClienteDTO getOne(Long Id) {
		Cliente cliente = repository.getOne(Id);
		return new ClienteDTO(cliente);
	}
	
	public ClienteDTO getOne(String nome) {
		Optional<Usuario> usuario = uRepository.findByEmail(nome);
		return new ClienteDTO(usuario.get().getCliente());
	}
	
	private void criaUsuario(ClienteDTOForm c, Cliente cliente) {
		Usuario usuario = new Usuario(c);
		usuario.setCliente(cliente);
		uRepository.save(usuario);
	}

}
