package com.katia.miniautorizador.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "cartoes")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;


    @Column(name = "cartao", length = 100)
    @NotEmpty(message = "{campo.cartao.obrigatorio}")
    private String numeroCartao;


    @Column(name = "senha", length = 100)
    @NotEmpty(message = "{campo.senha.obrigatorio}")
    private String senha;

    @Column(name = "saldo", length = 100)
    private Double saldo;


}
