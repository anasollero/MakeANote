package br.com.fiap.makeanote.exceptions;

public record RestError (
    int cod,
    String message
) {}
