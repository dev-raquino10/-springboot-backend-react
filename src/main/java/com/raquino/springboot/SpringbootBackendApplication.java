package com.raquino.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.raquino.springboot.exception.ResourceNotFoundException;
import com.raquino.springboot.model.Pessoa;
import com.raquino.springboot.repository.PessoaRepository;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Override
	public void run(String... args) throws ResourceNotFoundException {
		this.pessoaRepository.save(new Pessoa("Rafael Aquino", "Ancião", "Martinez"));
		this.pessoaRepository.save(new Pessoa("Bruna Aquino", "Publicador(a)", "Martinez"));
		this.pessoaRepository.save(new Pessoa("Alexandre Aquino", "Ancião", "Bela Vista"));
		this.pessoaRepository.save(new Pessoa("Delma Aquino", "Publicador(a)", "Bela Vista"));
		
	}
	

}
