package com.exemplointegracao.angularjsContato.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exemplointegracao.angularjsContato.model.Operadora;
import com.exemplointegracao.angularjsContato.repository.OperadoraRepository;

@Controller
@RequestMapping(value="/api")
public class OperadoraController {
	
	@Autowired
	OperadoraRepository operadoraRepository;
	
	@GetMapping(path="/operadoras")
	  public @ResponseBody Iterable<Operadora> getAllOperadoras() {
	    return operadoraRepository.findAll();
	  }
}
