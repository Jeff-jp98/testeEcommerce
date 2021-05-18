package br.com.loja.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.loja.dto.ProdutoDTOForm;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String descricao;
	private BigDecimal preco;
	private String urlImagem;
	
	public Produto() {
		
	}
	
	public Produto(ProdutoDTOForm p) {
		this.titulo = p.getTitulo();
		this.descricao = p.getDescricao();
		this.preco = p.getPreco();
		this.urlImagem=p.getUrlImagem();
	}
	

	public String getUrlImagem() {
		return urlImagem;
	}


	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}
	
}
