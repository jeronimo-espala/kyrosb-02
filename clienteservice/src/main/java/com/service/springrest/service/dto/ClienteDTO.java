package com.service.springrest.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ClienteDTO implements Serializable {

    private String nome;
    private LocalDate dataNasc;
    private String endereco;
    private String CPFCNPJ;
    private String tipoPessoa;

}
