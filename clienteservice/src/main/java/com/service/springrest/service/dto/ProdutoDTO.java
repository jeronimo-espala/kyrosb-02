package com.service.springrest.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.service.springrest.model.enumeration.TipoPessoaEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ProdutoDTO implements Serializable {

    private Long id;
    private String nome;
    private String descricao;
    private String status;
    private Long valorUnidade;
}
