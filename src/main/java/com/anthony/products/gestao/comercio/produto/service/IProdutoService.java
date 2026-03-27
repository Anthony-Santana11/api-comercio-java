package com.anthony.products.gestao.comercio.produto.service;

import com.anthony.products.gestao.comercio.cartegoria.model.CartegoriaModel;
import com.anthony.products.gestao.comercio.produto.model.ProdutoModel;

import java.util.List;

public interface IProdutoService {
    public ProdutoModel salvar(ProdutoModel novo);
    public ProdutoModel atualizar(ProdutoModel produto);
    public ProdutoModel deletar(Integer id);
    public List<ProdutoModel> listartudo();

    public List<ProdutoModel> listarPorCartegoria(CartegoriaModel cartegoria);

    List<ProdutoModel> listarPorNome(String nome);

    List<ProdutoModel> listarPorPalavraChave(String palavra);

    public ProdutoModel listarPorId(Integer id);
}
