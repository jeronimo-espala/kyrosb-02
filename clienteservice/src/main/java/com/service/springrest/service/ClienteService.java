package com.service.springrest.service;

import com.service.springrest.model.Cliente;
import com.service.springrest.service.dto.ClienteDTO;

import java.util.List;

public interface ClienteService {

    Cliente save (Cliente cliente);

    List<Cliente> obterTodos();

    Cliente obterPorId(Long id);

}
