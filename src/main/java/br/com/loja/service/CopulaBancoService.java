package br.com.loja.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import br.com.loja.dto.ClienteDTOForm;
import br.com.loja.dto.EnderecoDTOForm;
import br.com.loja.dto.ProdutoDTOForm;
import br.com.loja.models.Cliente;
import br.com.loja.models.Endereco;
import br.com.loja.models.Produto;
import br.com.loja.models.Transportadora;
import br.com.loja.models.Usuario;
import br.com.loja.repository.ClienteRepository;
import br.com.loja.repository.EnderecoRepository;
import br.com.loja.repository.ProdutoRepository;
import br.com.loja.repository.TransportadoraRepository;
import br.com.loja.repository.UsuarioRepository;

@Service
public class CopulaBancoService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private TransportadoraRepository transportadoraRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Bean
	public void copular() {
		criarClienteUsuario();
		criarProduto();
		criarTransportadora();
	}
	
	private void criarClienteUsuario() {
		List<Cliente> result = clienteRepository.findAll();
		if(result.isEmpty()) {
			Endereco e1 = new Endereco(new EnderecoDTOForm("Centro", "Avenida Princioal", "São Luis", "MA", "12345678", "10"));
			Endereco e2 = new Endereco(new EnderecoDTOForm("Maiobão", "Avenida 1", "Paço do Lumiar", "MA", "87654321", "9"));
			ClienteDTOForm clienteDTOForm = new ClienteDTOForm("lorem@teste.com", "Lorem Ipsum", "12345", "12345678998", e1);
			Cliente c = new Cliente(clienteDTOForm);
			c.getEnderecos().add(e2);
			enderecoRepository.save(e1);
			enderecoRepository.save(e2);
			Cliente c2 = clienteRepository.save(c);
			criaUsuario(clienteDTOForm, c2);
		}
	}
	private void criaUsuario(ClienteDTOForm c, Cliente cliente) {
		Usuario usuario = new Usuario(c);
		usuario.setCliente(cliente);
		usuarioRepository.save(usuario);
	}
	private void criarProduto() {
		List<Produto> result = produtoRepository.findAll();
		if(result.isEmpty()) {
			Produto p1 = new Produto(new ProdutoDTOForm("Fogão", "Fogão de 4 bocas", new BigDecimal(499.99), "https://loja.mueller.ind.br/media/catalog/product/cache/895ea19bf2bbd3022431e4cf8a6b8973/f/r/fratello-4-bocas-branco---frente.jpg"));
			produtoRepository.save(p1);
			Produto p2 = new Produto(new ProdutoDTOForm("Geladeira", "Geladeira Duas portas", new BigDecimal(699.99), "https://www.efacil.com.br/wcsstore/ExtendedSitesCatalogAssetStore/Imagens/1000/2219384_01.jpg"));
			produtoRepository.save(p2);
			Produto p3 = new Produto(new ProdutoDTOForm("Televisao", "Televisão de 32", new BigDecimal(1299.99), "https://i.zst.com.br/thumbs/12/10/35/792313295.jpg"));
			produtoRepository.save(p3);
		}
	}
	private void criarTransportadora() {
		List<Transportadora> result = transportadoraRepository.findAll();
		if(result.isEmpty()) {
			Transportadora t1 = new Transportadora("Transport Fast", new BigDecimal(49.99), 3);
			transportadoraRepository.save(t1);
			Transportadora t2 = new Transportadora("Ultra Transport", new BigDecimal(9.99), 7);
			transportadoraRepository.save(t2);
			Transportadora t3 = new Transportadora("Transport Legal", new BigDecimal(0.0), 30);
			transportadoraRepository.save(t3);
		}
	}
}
