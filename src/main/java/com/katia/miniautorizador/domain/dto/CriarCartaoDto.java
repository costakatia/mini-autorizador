package com.katia.miniautorizador.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CriarCartaoDto {

    @JsonProperty
    private String numeroCartao;
    @JsonProperty
    private String senha;

}
