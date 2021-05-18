package br.com.loja.models;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.loja.dto.ProdutoDTO;

public class CarrinhoItem implements Serializable{
	private static final long serialVersionUID=1L;

	private ProdutoDTO produto;
	
	public CarrinhoItem(ProdutoDTO produto) {
		this.produto = produto;
	}

	public BigDecimal getPreco() {
		return produto.getPreco();
	}

	public ProdutoDTO getProduto() {
		return produto;
	}

	public void setProduto(ProdutoDTO produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		if(produto==null) {
			return 0;
		}
		final int prime = 31;
		int result = 1;
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
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
		CarrinhoItem other = (CarrinhoItem) obj;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}
	
	public BigDecimal getTotal(int quantidade) {
		return this.getPreco().multiply(new BigDecimal(quantidade));			
	}
}