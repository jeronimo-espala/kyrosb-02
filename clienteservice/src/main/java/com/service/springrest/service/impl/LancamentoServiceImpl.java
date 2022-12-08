package com.service.springrest.service.impl;

import com.service.springrest.model.Lancamento;
import com.service.springrest.repository.LancamentoRepository;
import com.service.springrest.service.LancamentoService;
import com.service.springrest.service.ProdutoService;
import com.service.springrest.service.dto.LancamentoDTO;
import com.service.springrest.service.error.ClienteNaoEncontradoException;
import com.service.springrest.service.error.LancamentoNaoEncontradoException;
import com.service.springrest.service.mapper.LancamentoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LancamentoServiceImpl implements LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Autowired
    private LancamentoMapper lancamentoMapper;

    @Override
    @Transactional
    public LancamentoDTO save(LancamentoDTO lancamentoDTO) {
        Lancamento lancamento = lancamentoMapper.toEntity(lancamentoDTO);
        lancamento = lancamentoRepository.save(lancamento);
        return lancamentoMapper.toDto(lancamento);
    }

    @Override
    public List<LancamentoDTO> getAll() {
        List<Lancamento> lancamentos = lancamentoRepository.findAll();
        return lancamentoMapper.toDto(lancamentos);
    }

    @Override
    public LancamentoDTO getById(Long id) {
        Lancamento lancamentos = lancamentoRepository.findById(id).orElseThrow(LancamentoNaoEncontradoException::new);
        return lancamentoMapper.toDto(lancamentos);
    }

    @Override
    public void delete(Long id) {
        lancamentoRepository.deleteById(id);
    }
}
