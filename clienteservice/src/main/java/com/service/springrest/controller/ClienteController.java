package com.service.springrest.controller;

import com.service.springrest.model.Cliente;
import com.service.springrest.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping("/employees")
	public String getEmployees() {
		Cliente cliente = new Cliente();
		cliente.setNome("vaivai");
		cliente.setDataNascimento(LocalDate.of(2022,01,01));
		clienteService.save(cliente);
		return "alguma coisa";
	}

}