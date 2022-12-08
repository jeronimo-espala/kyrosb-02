package com.service.springrest.model;

import com.service.springrest.model.enumeration.TipoPessoaEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
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

    @OneToMany(mappedBy = "cliente")
    private List<Lancamento> lancamentos = new ArrayList<>();
}
