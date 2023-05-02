package com.katia.miniautorizador.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CartaoDto {

    @JsonProperty
    private String numeroCartao;
    @JsonProperty
    private String senha;
    @JsonProperty
    private Double saldo;

    private HttpStatusCode statusCode;

}
