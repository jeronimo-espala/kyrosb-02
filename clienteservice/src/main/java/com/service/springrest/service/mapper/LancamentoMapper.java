package com.service.springrest.service.mapper;

import com.service.springrest.model.Lancamento;
import com.service.springrest.model.Produto;
import com.service.springrest.service.dto.LancamentoDTO;
import com.service.springrest.service.dto.ProdutoDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface LancamentoMapper extends EntityMapper<LancamentoDTO, Lancamento> {

    @Override
    @Mapping(target = "produto.id", source = "idProduto")
    @Mapping(target = "cliente.id", source = "idCliente")
    Lancamento toEntity(LancamentoDTO lancamentoDTO);

    @Override
    @InheritInverseConfiguration
    LancamentoDTO toDto(Lancamento lancamento);
}
