package com.service.springrest.service.impl;

import com.service.springrest.model.Cliente;
import com.service.springrest.repository.ClienteRepository;
import com.service.springrest.service.ClienteService;
import com.service.springrest.service.dto.ClienteDTO;
import com.service.springrest.service.error.ClienteNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> obterTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente obterPorId(Long id) {
        return clienteRepository.findById(id).orElseThrow(ClienteNaoEncontradoException::new);
    }
}
