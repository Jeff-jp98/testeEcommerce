package br.com.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.loja.models.Transportadora;

@Repository
public interface TransportadoraRepository extends JpaRepository<Transportadora, Long>{

}
