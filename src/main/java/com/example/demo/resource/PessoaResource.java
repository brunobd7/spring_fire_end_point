package com.example.demo.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Pessoa;
import com.example.demo.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {
	
	@Autowired
	PessoaRepository repository;
	
	
	@GetMapping
	public List<Pessoa> listar(){
		
		return repository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> salvar(@Valid @RequestBody Pessoa pessoa){
		
		Pessoa pessoaSalva = repository.save(pessoa);
		
		return ResponseEntity.ok(pessoaSalva);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Pessoa> deletar(@PathVariable Integer id){
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
