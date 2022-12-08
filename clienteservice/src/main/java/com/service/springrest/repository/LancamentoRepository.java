package com.service.springrest.repository;

import com.service.springrest.model.Lancamento;
import com.service.springrest.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
}
