package com.service.springrest.service.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Lancamento não encontrado")
public class LancamentoNaoEncontradoException extends RuntimeException{
}
