package com.katia.miniautorizador.controller;


import com.katia.miniautorizador.domain.dto.CartaoDto;
import com.katia.miniautorizador.domain.entity.Card;
import com.katia.miniautorizador.service.CardService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@RequestMapping("/api/cartoes")
public class MiniAutorizadorController {

    @Autowired
    private CardService service;
    private String ResponseStatus;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Salva um novo cartao")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Cliente salvo com sucesso"),
            @ApiResponse(code = 400, message = "Erro de validação")
    })
    public String criarCartao(@RequestBody @Valid Card card) {
        return String.valueOf(service.criar(card));
    }


    @GetMapping("/{numeroCartao}")
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public String getCartao(@PathVariable
                               @ApiParam("Numero Do Cartao") String numeroCartao) {


        return service.validarCartao(numeroCartao);
    }


}

