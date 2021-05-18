package br.com.loja.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.loja.models.Transportadora;

public class TransportadoraDTO {

	private Long id;
	private String nome;
	private BigDecimal frete;
	private int dias;
	
	public TransportadoraDTO(Transportadora t) {
		this.id = t.getId();
		this.nome = t.getNome();
		this.frete = t.getFrete();
		this.dias = t.getDias();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getFrete() {
		return frete;
	}

	public void setFrete(BigDecimal frete) {
		this.frete = frete;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}
	
	public static List<TransportadoraDTO> converter(List<Transportadora> transportadoras){
		List<TransportadoraDTO> lista = new ArrayList<TransportadoraDTO>();
		for(Transportadora t : transportadoras) {
			lista.add(new TransportadoraDTO(t));
		}
		return lista;
	}
}
