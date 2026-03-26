package com.anthony.products.gestao.comercio.cartegoria.controller;

import com.anthony.products.gestao.comercio.cartegoria.model.CartegoriaModel;
import com.anthony.products.gestao.comercio.cartegoria.service.ICartegoriaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartegoriaController {

    private final ICartegoriaService cartegoriaService;

    public CartegoriaController(ICartegoriaService cartegoriaService) {
        this.cartegoriaService = cartegoriaService;
    }

    @GetMapping("/cartegoria")
    public ResponseEntity<List<CartegoriaModel>> getAllCartegoria() {
        return ResponseEntity.ok(cartegoriaService.recuperarTodos());
    }

    @GetMapping("/cartegoria/{id}")
    public ResponseEntity<CartegoriaModel> getCartegoriaById(@PathVariable Integer id) {
        CartegoriaModel cartegoria = cartegoriaService.recuperarPeloId(id);
        if (cartegoria != null) {
            return ResponseEntity.ok(cartegoria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/cartegoria")
    public ResponseEntity<CartegoriaModel> createCartegoria(@RequestBody CartegoriaModel nova) {
      try {
          CartegoriaModel result = cartegoriaService.cadastrarNovaCartegoria(nova);
          if (result != null) {
              return ResponseEntity.ok(result);
          }
      } catch (Exception e) {
          System.out.println("erro ao cadastrar" + e.getMessage());;
      }
      return ResponseEntity.badRequest().build();

    }

    @PutMapping("/cartegoria/{id}")
    public ResponseEntity<CartegoriaModel> updateCartegoria(@PathVariable Integer id, @RequestBody CartegoriaModel cartegoria) {
        cartegoria.setId(id); // deve vir antes do try para garanir que seja definido antes de entrar nobloco de execuacao do try
        try{
            CartegoriaModel result = cartegoriaService.atualizarCartegoria(cartegoria);
            if (result != null) {
                return ResponseEntity.ok(result);
            }
        } catch (Exception e) {
            throw new RuntimeException(e + "Erro ao atualizar a cartegoria");
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/cartegoria/{id}")
    public ResponseEntity<Void> deleteCartegoria(@PathVariable Integer id) {
        try {
            CartegoriaModel result = cartegoriaService.excluirCartegoria(id);
            if (result != null) {
                return ResponseEntity.ok().build();
            }
        } catch (Exception e) {
            throw new RuntimeException(e + "Erro ao excluir a cartegoria, id nao encontrado");
        }
        return ResponseEntity.notFound().build();
    }

}
