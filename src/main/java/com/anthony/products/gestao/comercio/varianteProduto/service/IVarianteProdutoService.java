package com.anthony.products.gestao.comercio.varianteProduto.service;

import com.anthony.products.gestao.comercio.produto.model.ProdutoModel;
import com.anthony.products.gestao.comercio.varianteProduto.model.VarianteProdutoModel;

import java.util.List;

public interface IVarianteProdutoService {
    public VarianteProdutoModel adicionarVarianteProduto(VarianteProdutoModel varianteNova);
    public VarianteProdutoModel atualizarVarianteProduto(VarianteProdutoModel varianteAtualizado);
    public List<VarianteProdutoModel> listarVariantePorProduto(ProdutoModel produto);
    public VarianteProdutoModel listarVarianteProdutoPorVariante(Integer id);
}
