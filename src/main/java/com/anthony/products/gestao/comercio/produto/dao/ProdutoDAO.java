package com.anthony.products.gestao.comercio.produto.dao;

import com.anthony.products.gestao.comercio.cartegoria.model.CartegoriaModel;
import com.anthony.products.gestao.comercio.produto.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoDAO extends JpaRepository<ProdutoModel, Integer> {

    public List<ProdutoModel> getProdutosByNomeContainingIgnoreCase(String nome);

   public List<ProdutoModel> getProdutosByCartegoria(CartegoriaModel cartegoria);

    public List<ProdutoModel> getProductByNomeContaining(String palavra);

}
