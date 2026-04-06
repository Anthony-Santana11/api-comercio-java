package com.anthony.products.gestao.comercio.varianteProduto.dao;

import com.anthony.products.gestao.comercio.produto.model.ProdutoModel;
import com.anthony.products.gestao.comercio.varianteProduto.model.VarianteProdutoModel;
import org.springframework.data.repository.CrudRepository;

public interface varianteDAO extends CrudRepository<VarianteProdutoModel, Integer> {
    public VarianteProdutoModel findByProduto(ProdutoModel produto);
}
