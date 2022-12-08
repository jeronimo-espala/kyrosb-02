package com.service.springrest.repository;

import com.service.springrest.model.Cliente;
import com.service.springrest.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
