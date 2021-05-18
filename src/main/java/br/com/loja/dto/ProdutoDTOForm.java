package br.com.loja.dto;

import java.math.BigDecimal;

public class ProdutoDTOForm {
	private String titulo;
	private String descricao;
	private BigDecimal preco;
	private String urlImagem;

	public ProdutoDTOForm(String titulo, String descricao, BigDecimal preco, String urlImagem) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.preco = preco;
		this.urlImagem = urlImagem;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

}
