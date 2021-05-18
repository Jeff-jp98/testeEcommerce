package br.com.loja.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.loja.models.Produto;

public class ProdutoDTO {
	private Long id;
	private String titulo;
	private String descricao;
	private BigDecimal preco;
	private String urlImagem;
	
	public ProdutoDTO(Produto p) {
		this.id = p.getId();
		this.titulo = p.getTitulo();
		this.descricao = p.getDescricao();
		this.preco = p.getPreco();
		this.urlImagem = p.getUrlImagem();
	}

	public Long getId() {
		return id;
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
	
	public static List<ProdutoDTO> converter(List<Produto> produtos){
		List<ProdutoDTO> lista = new ArrayList<ProdutoDTO>();
		for(Produto p : produtos) {
			lista.add(new ProdutoDTO(p));
		}
		return lista;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + id);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoDTO other = (ProdutoDTO) obj;
		if (id != other.getId())
			return false;
		return true;
	}

}
