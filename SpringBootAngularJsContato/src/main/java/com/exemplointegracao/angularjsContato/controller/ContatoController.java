package com.exemplointegracao.angularjsContato.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exemplointegracao.angularjsContato.model.Contato;
import com.exemplointegracao.angularjsContato.repository.ContatoRepository;

@Controller
@RequestMapping(value = "/api")
public class ContatoController {

	@Autowired
	ContatoRepository contatoRepository;

	@GetMapping(path = "/contatos")
	public @ResponseBody Iterable<Contato> getAllContatos() {
		return contatoRepository.findAll();
	}
	
	@GetMapping(path="/detalhesContato/{id}")
	public ResponseEntity<Contato> getOneContato(@PathVariable(value="id")int id){
		Optional<Contato> contatoO = contatoRepository.findById(id);
		if (!contatoO.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Contato>(contatoO.get(), HttpStatus.OK);
		}
	}

	@PostMapping(path = "/contatos")
	// @ResponseBody = BackEnd enviando uma resposta para o front em json.
	// @RequestBody = Quando o front enviando para BackEnd.
	public @ResponseBody Contato contato(@RequestBody Contato contato) {
		return contatoRepository.save(contato);
	}

	@DeleteMapping("/contatos/{id}")
	public @ResponseBody ResponseEntity<Integer> delete(@PathVariable Integer id) {
		Optional<Contato> contatoO = contatoRepository.findById(id);
		if (!contatoO.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			contatoRepository.delete(contatoO.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
