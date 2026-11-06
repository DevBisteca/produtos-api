package br.com.barbosaDev.produtos_api.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record ProdutoEntradaDto(@NotBlank String nome, 
		@NotNull @Positive BigDecimal preco, 
		@NotBlank String descricao, 
		@NotNull @PositiveOrZero Integer quantidade) {

}
