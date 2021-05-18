package br.com.loja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.dto.TransportadoraDTO;
import br.com.loja.models.Transportadora;
import br.com.loja.repository.TransportadoraRepository;

@Service
public class TransportadoraService {
	
	@Autowired
	private TransportadoraRepository repository;
	
	public List<TransportadoraDTO> listar(){
		List<Transportadora> resultList = repository.findAll();
		return TransportadoraDTO.converter(resultList);
	}
	
	public TransportadoraDTO getOne(Long id) {
		Transportadora t = repository.getOne(id);
		return new TransportadoraDTO(t);
	}

}
