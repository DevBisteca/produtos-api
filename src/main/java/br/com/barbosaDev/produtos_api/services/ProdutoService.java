package br.com.barbosaDev.produtos_api.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import br.com.barbosaDev.produtos_api.dto.ProdutoEntradaDto;
import br.com.barbosaDev.produtos_api.dto.ProdutoSaidaDto;
import br.com.barbosaDev.produtos_api.entities.Produto;
import br.com.barbosaDev.produtos_api.repository.ProdutoRepository;

@Service
public class ProdutoService {

	private final ProdutoRepository prodRepository;

	public ProdutoService(ProdutoRepository prodRepository) {
		this.prodRepository = prodRepository;
	}

	public List<ProdutoSaidaDto> getProdutos() {
		return prodRepository.findAll().stream().map(prod -> new ProdutoSaidaDto(prod.getId(), prod.getNome(),
				prod.getPreco(), prod.getDescricao(), prod.getQuantidade())).toList();

	}

	public ProdutoSaidaDto getProdutoPorId(Long id) {
		Produto prod = prodRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Produto não encontrado!"));
		return new ProdutoSaidaDto(prod.getId(), prod.getNome(), prod.getPreco(), prod.getDescricao(),
				prod.getQuantidade());
	}

	public ProdutoSaidaDto cadastrarProduto(ProdutoEntradaDto dto) {
		Produto prod = new Produto(dto.nome(), dto.preco(), dto.descricao(), dto.quantidade());
		Produto prodSalvo = prodRepository.save(prod);
		return new ProdutoSaidaDto(prodSalvo.getId(), prodSalvo.getNome(), prodSalvo.getPreco(),
				prodSalvo.getDescricao(), prodSalvo.getQuantidade());
	}

	public ProdutoSaidaDto atualizarProdutoPorId(Long id, ProdutoEntradaDto dto) {
		Produto prod = prodRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Produto não encontrado!"));
		prod.setNome(dto.nome());
		prod.setPreco(dto.preco());
		prod.setDescricao(dto.descricao());
		prod.setQuantidade(dto.quantidade());
		Produto prodSalvo = prodRepository.save(prod);

		return new ProdutoSaidaDto(prodSalvo.getId(), prodSalvo.getNome(), prodSalvo.getPreco(),
				prodSalvo.getDescricao(), prodSalvo.getQuantidade());
	}

	public void excluirProdutoPorId(Long id) {
		Produto prod = prodRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Produto não encontrado!"));
		prodRepository.delete(prod);
	}

}
