package br.com.raissafrota.comunicationmicrosservices.productapi.exception;

import lombok.Data;

@Data
public class ExceptionDetails {

    private int status;
    private String message;
}
