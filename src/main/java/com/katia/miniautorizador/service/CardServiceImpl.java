package com.katia.miniautorizador.service;


import com.katia.miniautorizador.domain.dto.CartaoDto;
import com.katia.miniautorizador.domain.entity.Card;
import com.katia.miniautorizador.repository.Cards;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
public class CardServiceImpl implements CardService {
    @Autowired
    private Cards repository;


    @Override
    public Card criar(Card card) {
        CartaoDto cardDto = new CartaoDto();
        cardDto.setNumeroCartao(card.getNumeroCartao());
        cardDto.setSenha(card.getSenha());
        cardDto.setSaldo(card.getSaldo());
        repository.insert(card);

        return card;

    }

    @Override
    public String validarCartao(String numeroCartao) {
        Card numerCartao = repository.findCardByNumeroCartao(numeroCartao);
        if (numerCartao == null) {
            return HttpStatus.NOT_FOUND.toString();
        }

        return numerCartao.getSaldo().toString();
    }


}


