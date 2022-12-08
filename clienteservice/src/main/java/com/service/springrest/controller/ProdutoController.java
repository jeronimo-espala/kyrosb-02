package com.service.springrest.controller;

import com.service.springrest.service.ProdutoService;
import com.service.springrest.service.dto.ProdutoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/produtos")
@Slf4j
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	private static final String API_PRODUTOS = "/produtos";

	@GetMapping()
	public ResponseEntity<List<ProdutoDTO>> getAll() {
		log.debug("Requisição para recuperar todos os produtos");
		List<ProdutoDTO> produtos = produtoService.getAll();
		return ResponseEntity.ok(produtos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDTO> getById(@PathVariable Long id) {
		log.debug("Requisição para recuperar o produto por id: " + id);
		ProdutoDTO produto = produtoService.getById(id);
		return ResponseEntity.ok(produto);
	}

	@PostMapping
	public ResponseEntity<ProdutoDTO> save(@RequestBody ProdutoDTO produtoDTO) throws URISyntaxException {
		log.debug("Requisição para salvar o produto : " + produtoDTO);
		ProdutoDTO result = produtoService.save(produtoDTO);
		return ResponseEntity.created(new URI(String.format("%s%d", API_PRODUTOS, result.getId())))
				.body(result);
	}

	@PutMapping
	public ResponseEntity<ProdutoDTO> update(@RequestBody ProdutoDTO produtoDTO) {
		log.debug("Requisição para atualizar o produto: " + produtoDTO);
		ProdutoDTO result = produtoService.save(produtoDTO);
		return ResponseEntity.ok()
				.body(result);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		log.debug("Requisição para remover a tarefa: " + id);
		produtoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}