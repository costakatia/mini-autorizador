package com.katia.miniautorizador.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TransacaoDto {

    private String numeroCartao;

    private String senha;

    private float valorTransacao;


}
