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

import br.unifacisa.banco.domain.model.Conta;
import br.unifacisa.banco.domain.repository.ContaRepository;

@RestController
@RequestMapping("/contas")
public class ContaController {

	@Autowired
	private ContaRepository contaRepository;

	@GetMapping
	public List<Conta> listar() {
		return contaRepository.findAll();
	}

	@GetMapping("/{contaId}")
	public ResponseEntity<Conta> buscar(@PathVariable Long contaId) {
		Optional<Conta> conta = contaRepository.findById(contaId);

		if (conta.isPresent())
			return ResponseEntity.ok(conta.get());
		else
			return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Conta adicionar(@RequestBody Conta conta) {
		return contaRepository.save(conta);
	}

	@PutMapping("/{contaId}")
	public ResponseEntity<Conta> atulizar(@PathVariable Long contaId, @RequestBody Conta conta) {

		if (!contaRepository.existsById(contaId)) {
			return ResponseEntity.notFound().build();
		} else {
			conta.setNumeroConta(contaId);
			contaRepository.save(conta);
			return ResponseEntity.ok(conta);
		}
	}

	@DeleteMapping("/{contaId}")
	public ResponseEntity<Conta> remover(@PathVariable Long contaId) {
		
		if (!contaRepository.existsById(contaId)) {
			return ResponseEntity.notFound().build();
		} else {
			contaRepository.deleteById(contaId);
			return ResponseEntity.noContent().build();
		}
	}
}
