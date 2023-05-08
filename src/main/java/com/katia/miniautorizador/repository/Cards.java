package com.katia.miniautorizador.repository;

import com.katia.miniautorizador.domain.entity.Card;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface Cards extends MongoRepository<Card,String> {


    Card findCardByNumeroCartao(String numeroCartao);

    Card insert(Card novoSaldo);


}
