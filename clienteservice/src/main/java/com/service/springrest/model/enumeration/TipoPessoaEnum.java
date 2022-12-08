package com.service.springrest.model.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoPessoaEnum {

    PESSOA_FISICA(0),
    PESSOA_JURIDICA(1);

    private final Integer codigo;
}
