package com.service.springrest.controller;

import com.service.springrest.service.ClienteService;
import com.service.springrest.service.dto.ClienteDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@Slf4j
public class LancamentoController {

	@Autowired
	private ClienteService clienteService;

	private static final String API_CLIENTES = "/clientes";

	@GetMapping()
	public ResponseEntity<List<ClienteDTO>> getAll() {
		log.debug("Requisição para recuperar todos os clientes");
		List<ClienteDTO> clienteList = clienteService.getAll();
		return ResponseEntity.ok(clienteList);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteDTO> getById(@PathVariable Long id) {
		log.debug("Requisição para recuperar o cliente por id: " + id);
		ClienteDTO cliente = clienteService.getById(id);
		return ResponseEntity.ok(cliente);
	}

	@PostMapping
	public ResponseEntity<ClienteDTO> save(@RequestBody ClienteDTO clienteDTO) throws URISyntaxException {
		log.debug("Requisição para salvar o cliente : " + clienteDTO);
		ClienteDTO result = clienteService.save(clienteDTO);
		return ResponseEntity.created(new URI(String.format("%s%d", API_CLIENTES, result.getId())))
				.body(result);
	}

	@PutMapping
	public ResponseEntity<ClienteDTO> update(@RequestBody ClienteDTO clienteDTO) {
		log.debug("Requisição para atualizar o cliente: " + clienteDTO);
		ClienteDTO result = clienteService.save(clienteDTO);
		return ResponseEntity.ok()
				.body(result);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		log.debug("Requisição para remover a tarefa: " + id);
		clienteService.delete(id);
		return ResponseEntity.noContent().build();
	}
}