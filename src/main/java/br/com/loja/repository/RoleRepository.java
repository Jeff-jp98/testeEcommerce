package br.com.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.loja.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String>{

}
