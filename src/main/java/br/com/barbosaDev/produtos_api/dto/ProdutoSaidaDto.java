package br.com.barbosaDev.produtos_api.dto;

import java.math.BigDecimal;

public record ProdutoSaidaDto(Long id, String nome, BigDecimal preco, String descricao, Integer quantidade) {

}
