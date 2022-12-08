package com.service.springrest.service.impl;

import com.service.springrest.model.Produto;
import com.service.springrest.repository.ProdutoRepository;
import com.service.springrest.service.ProdutoService;
import com.service.springrest.service.dto.ProdutoDTO;
import com.service.springrest.service.error.ClienteNaoEncontradoException;
import com.service.springrest.service.mapper.ProdutoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoMapper produtoMapper;

    @Override
    @Transactional
    public ProdutoDTO save(ProdutoDTO produtoDTO) {
        Produto produto = produtoMapper.toEntity(produtoDTO);
        produto = produtoRepository.save(produto);
        return produtoMapper.toDto(produto);
    }

    @Override
    public List<ProdutoDTO> getAll() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtoMapper.toDto(produtos);
    }

    @Override
    public ProdutoDTO getById(Long id) {
        Produto produtos = produtoRepository.findById(id).orElseThrow(ClienteNaoEncontradoException::new);
        return produtoMapper.toDto(produtos);
    }

    @Override
    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }
}
