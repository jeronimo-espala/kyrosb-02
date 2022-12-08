package com.service.springrest.service;

import com.service.springrest.model.Cliente;
import com.service.springrest.service.dto.ClienteDTO;

import java.util.List;

public interface ClienteService {

    ClienteDTO save (ClienteDTO clienteDTO);

    List<ClienteDTO> getAll();

    ClienteDTO getById(Long id);

    void delete(Long id);

}
