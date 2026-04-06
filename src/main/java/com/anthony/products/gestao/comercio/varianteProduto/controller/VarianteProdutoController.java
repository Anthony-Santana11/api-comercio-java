package com.anthony.products.gestao.comercio.varianteProduto.controller;

import com.anthony.products.gestao.comercio.produto.model.ProdutoModel;
import com.anthony.products.gestao.comercio.varianteProduto.dao.varianteDAO;
import com.anthony.products.gestao.comercio.varianteProduto.model.VarianteProdutoModel;
import com.anthony.products.gestao.comercio.varianteProduto.service.VarianteProdutoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class VarianteProdutoController {

    private final VarianteProdutoServiceImpl varianteProdutoService;
    private final varianteDAO varianteDAO;

    public VarianteProdutoController(VarianteProdutoServiceImpl varianteProdutoService, varianteDAO varianteDAO) {
        this.varianteProdutoService = varianteProdutoService;
        this.varianteDAO = varianteDAO;
    }

    @GetMapping("/produto/variante/id/{id}")
    public ResponseEntity<VarianteProdutoModel> listarVarianteProduto(@PathVariable Integer id) {
        var result = varianteProdutoService.listarVarianteProdutoPorVariante(id);
        if (result != null) {
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/produto/variante")
    public ResponseEntity<List<VarianteProdutoModel>> listarVarianteProdutoPorVariante(@RequestParam (name = "idproduto") Integer idProduto) {
        ProdutoModel p = new ProdutoModel();
        p.setId(idProduto);
        return ResponseEntity.ok(varianteProdutoService.listarVariantePorProduto(p));
    }

    @PostMapping("/produto/variante")
    public ResponseEntity<VarianteProdutoModel> criarVarianteProduto(@RequestBody VarianteProdutoModel varianteProdutoModel) {
        try {
            ProdutoModel result = varianteProdutoService.adicionarVarianteProduto(varianteProdutoModel).getProduto();
            if (result != null) {
                return ResponseEntity.ok().body(varianteProdutoModel);
            }
        }  catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("produto/variante/{id}")
    public ResponseEntity<VarianteProdutoModel> atualizarVarianteProduto(@RequestBody VarianteProdutoModel varianteProdutoModel,  @PathVariable Integer id) {
        varianteProdutoModel.setId(id);
        try {
          var result = varianteProdutoService.atualizarVarianteProduto(varianteProdutoModel);
          if (result != null) {
              return ResponseEntity.ok().body(varianteProdutoModel);
          }
        }   catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
