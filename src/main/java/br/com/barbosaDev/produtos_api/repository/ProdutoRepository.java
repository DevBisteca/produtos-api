package br.com.barbosaDev.produtos_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.barbosaDev.produtos_api.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
