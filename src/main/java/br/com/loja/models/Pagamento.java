package br.com.loja.models;

import java.math.BigDecimal;

public class Pagamento {

	private int parcela;
	private BigDecimal valor;
	private TipoPagamento tipo;
	
	public Pagamento(int parcela, BigDecimal valor, TipoPagamento tipo) {
		this.parcela = parcela;
		this.valor = valor;
		this.tipo = tipo;
	}
	
	public int getParcela() {
		return parcela;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public TipoPagamento getTipo() {
		return tipo;
	}
	
}
