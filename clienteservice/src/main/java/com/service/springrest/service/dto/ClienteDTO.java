package com.service.springrest.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.service.springrest.model.TipoPessoaEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ClienteDTO implements Serializable {

    private Long id;
    private String nome;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataNasc;
    private String endereco;
    private String cpfCnpj;
    private TipoPessoaEnum tipoPessoa;
}
