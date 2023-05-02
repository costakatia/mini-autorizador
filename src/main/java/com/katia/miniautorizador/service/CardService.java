package com.katia.miniautorizador.service;

import com.katia.miniautorizador.domain.dto.CartaoDto;
import com.katia.miniautorizador.domain.entity.Card;

import javax.validation.Valid;

public interface CardService {
    Card criar (@Valid Card cardDto);
    String validarCartao(String numeroCartao);

}
