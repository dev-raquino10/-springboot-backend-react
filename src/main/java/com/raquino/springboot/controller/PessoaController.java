package com.raquino.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raquino.springboot.exception.ResourceNotFoundException;
import com.raquino.springboot.model.Pessoa;
import com.raquino.springboot.repository.PessoaRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	//retorna todas as pessoas cadastradas
	@GetMapping("/pessoas")
	public List<Pessoa> getAllPessoas() {
		return pessoaRepository.findAll();
	}
	
	@PostMapping("/pessoas")
	public Pessoa createPessoa(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	// get Pessoa by id rest api
	@GetMapping("/pessoas/{id}")
	public ResponseEntity<Pessoa> getPessoaById(@PathVariable Long id) {
		Pessoa pessoa = pessoaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Pessoa not exist with id :" + id));
		return ResponseEntity.ok(pessoa);
	}
	
	// update Pessoa rest api
	
	@PutMapping("/pessoas/{id}")
	public ResponseEntity<Pessoa> updatePessoa(@PathVariable Long id, @RequestBody Pessoa pessoaDetails){
		Pessoa pessoa = pessoaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Pessoa not exist with id :" + id));
		
		pessoa.setNome(pessoaDetails.getNome());
		pessoa.setTipo(pessoaDetails.getTipo());
		pessoa.setGrupo(pessoaDetails.getGrupo());
		
		Pessoa updatedPessoa = pessoaRepository.save(pessoa);
		return ResponseEntity.ok(updatedPessoa);
	}
	
	// delete Pessoa rest api
	@DeleteMapping("/pessoas/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePessoa(@PathVariable Long id){
		Pessoa pessoa = pessoaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Pessoa not exist with id :" + id));
		
		pessoaRepository.delete(pessoa);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
