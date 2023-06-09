package com.katia.miniautorizador.controller;


import com.katia.miniautorizador.domain.dto.TransacaoDto;
import com.katia.miniautorizador.domain.entity.Card;
import com.katia.miniautorizador.service.CardService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;

@RestController
@Slf4j
@RequestMapping("/api/cartoes")
public class MiniAutorizadorController {

    @Autowired
    private CardService service;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    
    public String criarCartao(@RequestBody @Valid Card card) throws ParseException {
        return String.valueOf(service.criarCartao(card));
    }


    @GetMapping("/{numeroCartao}")
    @ResponseStatus(code = HttpStatus.OK)
    public String getCartao(@PathVariable
                               @ApiParam("Numero Do Cartao") String numeroCartao) {


        return service.retornaSaldo(numeroCartao);

    }
    @PostMapping("transacoes")
    public String realizarTransacao(@RequestBody @Valid TransacaoDto transacaoDto){
        return String.valueOf(service.transacao(transacaoDto));
    }


}

