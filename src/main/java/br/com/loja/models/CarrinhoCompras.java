package br.com.loja.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import br.com.loja.dto.ProdutoDTO;

@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION,proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CarrinhoCompras implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Map<CarrinhoItem, Integer> itens = new LinkedHashMap<>();
	
	public Collection<CarrinhoItem> getItens() {
		return itens.keySet();
	}

	public void add(CarrinhoItem item) {
		itens.put(item, getQuantidade(item) + 1);
	}

	public Integer getQuantidade(CarrinhoItem item) {
		if(!itens.containsKey(item)) {
			itens.put(item, 0);
		}
		return itens.get(item);
	}
	
	public int getQuantidade() {
		return this.itens.values().stream().reduce(0, 
				(proximo, acumulador) -> proximo + acumulador);
	}
	
	public BigDecimal getTotal(CarrinhoItem item) {
		return item.getTotal(getQuantidade(item));
	}
	
	public BigDecimal getTotal() {
		BigDecimal total = BigDecimal.ZERO;
		
		for (CarrinhoItem item : itens.keySet()) {
			total = total.add(getTotal(item));
		}
		return total ;
	}

	public void remover(ProdutoDTO produto) {
		CarrinhoItem carrinhoItem = new CarrinhoItem(produto);
		itens.remove(carrinhoItem);
	}


	
}
