package com.questao.avaliacao04.exceptions;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FornecedorNaoEncontradoException extends ServiceException {

    public FornecedorNaoEncontradoException(String message) {
        super(message);
    }
}