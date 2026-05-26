package br.com.diogo.itau_teste_1.service;

import br.com.diogo.itau_teste_1.entity.TransacaoEntity;
import br.com.diogo.itau_teste_1.exception.TransacaoInvalidaException;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
public class TransacaoService {

    private final List<TransacaoEntity> transacoesList = new ArrayList<>();

    public void salvarNovaTransacao(TransacaoEntity transacao) {
        if(transacao.getValor() == null || transacao.getDataHora() == null) {
            throw new TransacaoInvalidaException("Campos não podem ser vazios");
        }

        if(transacao.getValor() < 0 ){
            throw new TransacaoInvalidaException("O valor não pode ser negativo");
        }

        if(transacao.getDataHora().isAfter(OffsetDateTime.now())) {
            throw new TransacaoInvalidaException("A transação não pode ocorrer no futuro");
        }

        transacoesList.add(transacao);

    }

    public void limparTransacao() {
        transacoesList.clear();
    }

    public DoubleSummaryStatistics calcularEstatisticas() {
        //OffsetDateTime agora = OffsetDateTime.now();
        OffsetDateTime limite = OffsetDateTime.now().minusSeconds(60);

        return transacoesList.stream()
                .filter(transacao -> transacao.getDataHora().isAfter(limite))
                .mapToDouble(TransacaoEntity::getValor)
                .summaryStatistics();
    }

}
