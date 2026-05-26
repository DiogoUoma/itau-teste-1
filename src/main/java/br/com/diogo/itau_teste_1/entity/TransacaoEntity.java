package br.com.diogo.itau_teste_1.entity;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransacaoEntity {

    @NotNull
    private Double valor;

    @NotNull
    private OffsetDateTime dataHora;

}
