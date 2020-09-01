package br.unifacisa.banco.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.unifacisa.banco.domain.model.Agencia;
import br.unifacisa.banco.domain.repository.AgenciaRepository;

@RestController 
@RequestMapping("/agencias")
public class AgenciaController {
	
	@Autowired
	private AgenciaRepository agenciaRepository;
	
	@GetMapping
	public List<Agencia> listar() {
		return agenciaRepository.findAll();
	}
	

	@GetMapping("/{agenciaId}")
	public ResponseEntity<Agencia> buscar(@PathVariable Long agenciaId){
		Optional<Agencia> agencia = agenciaRepository.findById(agenciaId);
		
		if (agencia.isPresent())
			return ResponseEntity.ok(agencia.get());
		else
			return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Agencia adicionar(@RequestBody Agencia agencia) {
		return agenciaRepository.save(agencia);
	}
	
	@PutMapping("/{agenciaId}")
	public ResponseEntity<Agencia> atualizar(@PathVariable Long agenciaId, @RequestBody Agencia agencia){
		if (!agenciaRepository.existsById(agenciaId)) {
			return ResponseEntity.notFound().build();
		}
		else {
			agencia.setCodAgencia(agenciaId);
			agenciaRepository.save(agencia);
			
			return ResponseEntity.ok(agencia);
		}
	}
	
	@DeleteMapping("/{agenciaId}")
	public ResponseEntity<Void> remover(@PathVariable Long agenciaId) {
		if (!agenciaRepository.existsById(agenciaId)) {
			return ResponseEntity.notFound().build();
		}
		else {
			agenciaRepository.deleteById(agenciaId);
			return ResponseEntity.noContent().build();		
		}
	}
}
