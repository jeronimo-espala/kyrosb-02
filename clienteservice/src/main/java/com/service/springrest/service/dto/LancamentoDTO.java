package com.service.springrest.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class LancamentoDTO implements Serializable {

    private Long id;
    private Long idCliente;
    private Long idProduto;
    private Long qtdeVendida;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataVenda;
    private Long valorTotal;
}
