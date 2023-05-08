package com.katia.miniautorizador.service;


import com.katia.miniautorizador.domain.dto.CriarCartaoDto;
import com.katia.miniautorizador.domain.dto.TransacaoDto;
import com.katia.miniautorizador.domain.entity.Card;
import com.katia.miniautorizador.repository.Cards;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

import static com.katia.miniautorizador.enums.ValidaTransacao.*;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Service
@Slf4j
public class CardServiceImpl implements CardService {
    @Autowired
    private Cards repository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public String retornaSaldo(String numeroCartao) {
        Optional<Card> card = Optional.ofNullable(repository.findCardByNumeroCartao(numeroCartao));
        if (card.isEmpty()) {
            return HttpStatus.NOT_FOUND.toString();
        }
        return String.valueOf(card.get().getSaldo());
    }

    @Override
    public Object criarCartao(Card card) {
        Card card1 = repository.findCardByNumeroCartao(card.getNumeroCartao());

        if (card1 != null) {
            return UNPROCESSABLE_ENTITY;
        }
        return convertToDto(repository.insert(card));
    }

    @Override
    @Transactional
    public Object transacao(TransacaoDto transacaoDto) {
        Card card1 = repository.findCardByNumeroCartao(transacaoDto.getNumeroCartao());

        Object CARTAO_INEXISTENTE1 = getObject(transacaoDto, card1);
        if (CARTAO_INEXISTENTE1 != null) return CARTAO_INEXISTENTE1;
        Card novoSaldo = debitar(card1, transacaoDto);
        repository.save(novoSaldo);
        return ResponseEntity.ok(CREATED);

    }

    private static Object getObject(TransacaoDto transacaoDto, Card card1) {
        if (card1.getNumeroCartao() == null) {
            return ResponseEntity.unprocessableEntity().body(CARTAO_INEXISTENTE).toString();
        } else if (card1.getSaldo() < transacaoDto.getValorTransacao()) {

            return ResponseEntity.unprocessableEntity().body(SALDO_INSUFICIENTE);

        } else if (!Objects.equals(card1.getSenha(), transacaoDto.getSenha())) {

            return ResponseEntity.status(UNPROCESSABLE_ENTITY).body(SENHA_INVALIDA);
        }
        return null;
    }

    private Card debitar(Card card, TransacaoDto transacaoDto) {
        float valorDebto = card.getSaldo();
        float v = valorDebto - transacaoDto.getValorTransacao();
        card.setSaldo(v);
        return card;
    }


    private CriarCartaoDto convertToDto(Card card) {
        CriarCartaoDto cardDto = modelMapper.map(card, CriarCartaoDto.class);
        cardDto.setNumeroCartao(card.getNumeroCartao());
        cardDto.setSenha(card.getSenha());
        return cardDto;

    }


}


