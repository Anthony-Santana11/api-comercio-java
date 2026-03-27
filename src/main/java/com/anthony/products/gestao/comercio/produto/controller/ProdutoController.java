package com.anthony.products.gestao.comercio.produto.controller;

import com.anthony.products.gestao.comercio.cartegoria.model.CartegoriaModel;
import com.anthony.products.gestao.comercio.produto.model.ProdutoModel;
import com.anthony.products.gestao.comercio.produto.service.ProdutoServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {

    private final ProdutoServiceImpl produtoService;

    public ProdutoController(ProdutoServiceImpl produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/produto")
    public ResponseEntity<List<ProdutoModel>> listarProdutos() {
        return ResponseEntity.ok(produtoService.listartudo());
    }

    @GetMapping("/produto/{id}")
    public ResponseEntity<ProdutoModel> listarProdutoPorId(@PathVariable Integer id) {
        ProdutoModel result = produtoService.listarPorId(id);
        if (result != null) {
            return ResponseEntity.ok(produtoService.listarPorId(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/produto")
    public ResponseEntity<ProdutoModel> salvar(@RequestBody ProdutoModel novo) {
        try {
            ProdutoModel result = produtoService.salvar(novo);
            if (result != null) {
                return ResponseEntity.ok(result);
            }
        } catch (Exception e) {
            System.out.println("erro ao cadastrar" + e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/produto/{id}")
    public ResponseEntity<ProdutoModel> atualizar(@PathVariable Integer id, @RequestBody ProdutoModel produto) {
        produto.setId(id);
        try {
            ProdutoModel result = produtoService.atualizar(produto);
            if (result != null) {
                return ResponseEntity.ok(result);
            }
        } catch (Exception e) {
            throw new RuntimeException(e + "Erro ao atualizar o produto");
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/produto/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        try {
            ProdutoModel result = produtoService.deletar(id);
            if (result != null) {
                return ResponseEntity.ok().build();
            }
        } catch (Exception e) {
            throw new RuntimeException(e + "Erro ao deletar o produto");
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/produto/nome")
    public ResponseEntity<List<ProdutoModel>> listarPorNome(@RequestParam String nome) {
        try {
            List<ProdutoModel> result = produtoService.listarPorNome(nome);
            if (result != null && !result.isEmpty()) {
                return ResponseEntity.ok(result);
            }
        } catch (Exception e) {
            throw new RuntimeException(e + "Erro ao listar produtos por nome");
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/produto/search")
    public ResponseEntity<List<ProdutoModel>> listarPorNomeContaining(@RequestParam String key) {
        List<ProdutoModel> result = produtoService.listarPorNome(key);
        if (result.size() > 0 ) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/produto/cartegoria/{id}")
    public ResponseEntity<List<ProdutoModel>> listarPorCartegoria(@PathVariable Integer id) {
        CartegoriaModel cartegoria = new CartegoriaModel();
        cartegoria.setId(id);
        List<ProdutoModel> result = produtoService.listarPorCartegoria(cartegoria);
        if (result.size() > 0 ) {
            return ResponseEntity.ok(result);
        } else {
        return ResponseEntity.notFound().build();
    }

    }
}
