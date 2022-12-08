package com.service.springrest.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DATA_NASC")
    private LocalDate dataNasc;

    @Column(name = "ENDERECO")
    private String endereco;

    @Column(name = "CPFCNPJ", unique = true)
    private String cpfCnpj;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "TIPO_PESSOA")
    private TipoPessoaEnum tipoPessoa;
}
