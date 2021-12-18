package com.questao.avaliacao04.exceptions;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ProdutoExistenteException extends ServiceException {
    public ProdutoExistenteException(String message) {
        super(message);
    }
}
