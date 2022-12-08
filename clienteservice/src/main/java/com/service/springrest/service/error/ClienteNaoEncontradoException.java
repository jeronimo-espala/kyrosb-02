package com.service.springrest.service.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Grupo de Perfis não encontrado")
public class ClienteNaoEncontradoException extends RuntimeException{
}
