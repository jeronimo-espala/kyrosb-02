package com.service.springrest.service.impl;

import com.service.springrest.model.Cliente;
import com.service.springrest.repository.ClienteRepository;
import com.service.springrest.service.ClienteService;
import com.service.springrest.service.dto.ClienteDTO;
import com.service.springrest.service.error.ClienteNaoEncontradoException;
import com.service.springrest.service.mapper.ClienteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Override
    @Transactional
    public ClienteDTO save(ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        cliente = clienteRepository.save(cliente);
        return clienteMapper.toDto(cliente);
    }

    @Override
    public List<ClienteDTO> getAll() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clienteMapper.toDto(clientes);
    }

    @Override
    public ClienteDTO getById(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(ClienteNaoEncontradoException::new);
        return clienteMapper.toDto(cliente);
    }

    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }
}
