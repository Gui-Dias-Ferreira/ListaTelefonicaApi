package com.exemplointegracao.angularjsContato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exemplointegracao.angularjsContato.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer>{
	 void deleteById(Integer id);
}