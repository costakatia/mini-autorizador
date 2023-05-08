package com.katia.miniautorizador.service;

import com.katia.miniautorizador.domain.dto.TransacaoDto;
import com.katia.miniautorizador.domain.entity.Card;

import java.text.ParseException;

public interface CardService {


    String retornaSaldo(String numeroCartao);

    Object criarCartao(Card cartaoDto) throws ParseException;

    Object transacao(TransacaoDto transacaoDto);


}
