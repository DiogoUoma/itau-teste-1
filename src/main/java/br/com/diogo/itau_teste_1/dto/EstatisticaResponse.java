package br.com.diogo.itau_teste_1.dto;

public record EstatisticaResponse(
    long count,
    double sum,
    double avg,
    double min,
    double max
) { }
