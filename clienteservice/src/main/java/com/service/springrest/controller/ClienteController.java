package com.service.springrest.controller;

import com.service.springrest.model.Cliente;
import com.service.springrest.service.ClienteService;
import com.service.springrest.service.dto.ClienteDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@Slf4j
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	private static final String API_CLIENTES = "/clientes";

	@GetMapping()
	public ResponseEntity<List<Cliente>> getAll() {
		log.debug("Requisição para recuperar todos os clientes");
		List<Cliente> clienteList = clienteService.obterTodos();
		return ResponseEntity.ok(clienteList);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getById(@PathVariable Long id) {
		log.debug("Requisição para recuperar o cliente por id: " + id);
		Cliente cliente = clienteService.obterPorId(id);
		return ResponseEntity.ok(cliente);
	}

	@PostMapping
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) throws URISyntaxException {
		log.debug("REST requisição para salvar o cliente : {}", cliente);
		Cliente result = clienteService.save(cliente);
		return ResponseEntity.created(new URI(String.format("%s%d", API_CLIENTES, result.getId())))
				.body(result);
	}

}