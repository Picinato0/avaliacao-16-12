package com.questao.avaliacao04.exceptions;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TipoProdutoNaoEncontradoException extends ServiceException {

    public TipoProdutoNaoEncontradoException(String message) {
        super(message);
    }
}