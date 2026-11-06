package br.com.barbosaDev.produtos_api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.barbosaDev.produtos_api.dto.ProdutoEntradaDto;
import br.com.barbosaDev.produtos_api.dto.ProdutoSaidaDto;
import br.com.barbosaDev.produtos_api.services.ProdutoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	private final ProdutoService prodService;

	public ProdutoController(ProdutoService prodService) {
		this.prodService = prodService;
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public ProdutoSaidaDto cadastrarProduto(@RequestBody @Valid ProdutoEntradaDto dto) {
		return prodService.cadastrarProduto(dto);
	}

	@GetMapping
	public List<ProdutoSaidaDto> getProdutos() {
		return prodService.getProdutos();
	}

	@GetMapping("/{id}")
	public ProdutoSaidaDto getProduto(@PathVariable Long id) {
		return prodService.getProdutoPorId(id);
	}

	@PutMapping("/{id}")
	public ProdutoSaidaDto atualizarProdutoPorId(@PathVariable Long id, @RequestBody @Valid ProdutoEntradaDto dto) {
		return prodService.atualizarProdutoPorId(id, dto);
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void deletarProdutoPorId(@PathVariable Long id) {
		prodService.excluirProdutoPorId(id);
	}

}
