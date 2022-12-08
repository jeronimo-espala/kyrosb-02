package com.service.springrest.service;

import com.service.springrest.service.dto.ProdutoDTO;
import com.service.springrest.service.dto.ProdutoDTO;

import java.util.List;

public interface ProdutoService {

    ProdutoDTO save (ProdutoDTO produtoDTO);

    List<ProdutoDTO> getAll();

    ProdutoDTO getById(Long id);

    void delete(Long id);

}
