package br.com.loja.models;

public enum TipoPagamento {

	BOLETO ("Boleto"), 
	CREDITO ("Credito"), 
	PIX ("Pix");
	
	private String tipo;

	TipoPagamento(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}
}
