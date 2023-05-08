package com.katia.miniautorizador.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CriarCartaoDto {

    private String numeroCartao;
    private String senha;

}
