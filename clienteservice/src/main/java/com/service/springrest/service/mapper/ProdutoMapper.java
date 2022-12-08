package com.service.springrest.service.mapper;

import com.service.springrest.model.Cliente;
import com.service.springrest.model.Produto;
import com.service.springrest.service.ProdutoService;
import com.service.springrest.service.dto.ClienteDTO;
import com.service.springrest.service.dto.ProdutoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ProdutoMapper extends EntityMapper<ProdutoDTO, Produto> {
}
