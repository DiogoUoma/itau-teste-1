package br.com.diogo.itau_teste_1.controller;

import br.com.diogo.itau_teste_1.dto.EstatisticaResponse;
import br.com.diogo.itau_teste_1.entity.TransacaoEntity;
import br.com.diogo.itau_teste_1.service.TransacaoService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/transacao")
@AllArgsConstructor
public class TransacaoController {

    private final TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<Void> novaTransacao(@RequestBody TransacaoEntity transacao) {
        transacaoService.salvarNovaTransacao(transacao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deletaTransacoes() {
        transacaoService.limparTransacao();
        return ResponseEntity.ok().build();
    }


}
