package com.service.springrest.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "VALOR_UNIDADE")
    private Long valorUnidade;

    @OneToMany(mappedBy = "produto")
    private List<Lancamento> lancamentos = new ArrayList<>();

}
