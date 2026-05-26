package br.com.diogo.itau_teste_1.exception;

public class TransacaoInvalidaException extends RuntimeException{

    public TransacaoInvalidaException(String message) {
        super(message);
    }

}
