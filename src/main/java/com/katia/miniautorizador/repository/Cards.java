package com.katia.miniautorizador.repository;

import com.katia.miniautorizador.domain.entity.Card;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Cards extends MongoRepository<Card,String> {


    Card findCardByNumeroCartao(String numeroCartao);

    Card insert(Card novoSaldo);


}
