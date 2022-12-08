package com.service.springrest.service.mapper;

import com.service.springrest.model.Cliente;
import com.service.springrest.service.dto.ClienteDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ClienteMapper extends EntityMapper<ClienteDTO, Cliente> {
}
