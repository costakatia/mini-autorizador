package com.katia.miniautorizador.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data

public class TransacaoDto {

    private String numeroCartao;
    private String senha;
    private float valorTransacao;


}
