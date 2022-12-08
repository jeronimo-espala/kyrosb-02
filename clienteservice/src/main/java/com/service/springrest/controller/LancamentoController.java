package com.service.springrest.controller;

import com.service.springrest.service.LancamentoService;
import com.service.springrest.service.dto.LancamentoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/lancamentos")
@Slf4j
public class LancamentoController {

	@Autowired
	private LancamentoService lancamentoService;

	private static final String API_LANCAMENTOS = "/lancamentos";

	@GetMapping()
	public ResponseEntity<List<LancamentoDTO>> getAll() {
		log.debug("Requisição para recuperar todos os lancamentos");
		List<LancamentoDTO> lancamentos = lancamentoService.getAll();
		return ResponseEntity.ok(lancamentos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<LancamentoDTO> getById(@PathVariable Long id) {
		log.debug("Requisição para recuperar o lancamento por id: " + id);
		LancamentoDTO lancamento = lancamentoService.getById(id);
		return ResponseEntity.ok(lancamento);
	}

	@PostMapping
	public ResponseEntity<LancamentoDTO> save(@RequestBody LancamentoDTO clienteDTO) throws URISyntaxException {
		log.debug("Requisição para salvar o lancamento : " + clienteDTO);
		LancamentoDTO result = lancamentoService.save(clienteDTO);
		return ResponseEntity.created(new URI(String.format("%s%d", API_LANCAMENTOS, result.getId())))
				.body(result);
	}

	@PutMapping
	public ResponseEntity<LancamentoDTO> update(@RequestBody LancamentoDTO clienteDTO) {
		log.debug("Requisição para atualizar o lancamento: " + clienteDTO);
		LancamentoDTO result = lancamentoService.save(clienteDTO);
		return ResponseEntity.ok()
				.body(result);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		log.debug("Requisição para remover a tarefa: " + id);
		lancamentoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}