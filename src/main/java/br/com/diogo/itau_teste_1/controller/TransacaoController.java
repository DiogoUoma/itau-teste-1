package br.com.diogo.itau_teste_1.controller;

import br.com.diogo.itau_teste_1.dto.EstatisticaResponse;
import br.com.diogo.itau_teste_1.entity.TransacaoEntity;
import br.com.diogo.itau_teste_1.service.TransacaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.DoubleSummaryStatistics;

@RestController
@AllArgsConstructor
public class TransacaoController {

    private final TransacaoService transacaoService;

    @PostMapping("/transacao")
    public ResponseEntity<Void> novaTransacao(@RequestBody TransacaoEntity transacao) {
        transacaoService.salvarNovaTransacao(transacao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/transacao")
    public ResponseEntity<Void> deletaTransacoes() {
        transacaoService.limparTransacao();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/estatistica")
    public EstatisticaResponse calculaEstatisticas() {
        DoubleSummaryStatistics doubleSummaryStatistics = transacaoService.calcularEstatisticas();

        return new EstatisticaResponse(
                doubleSummaryStatistics.getCount(),
                doubleSummaryStatistics.getSum(),
                doubleSummaryStatistics.getAverage(),
                doubleSummaryStatistics.getCount() > 0 ? doubleSummaryStatistics.getMin() : 0.0,
                doubleSummaryStatistics.getCount() > 0 ? doubleSummaryStatistics.getMax() : 0.0
        );
    }

}
