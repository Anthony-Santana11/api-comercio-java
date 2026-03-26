package com.anthony.products.gestao.comercio.cartegoria.service;

import com.anthony.products.gestao.comercio.cartegoria.model.CartegoriaModel;

import java.util.List;

public interface ICartegoriaService {
    public CartegoriaModel cadastrarNovaCartegoria(CartegoriaModel nova);
    public CartegoriaModel excluirCartegoria(Integer id);
    public CartegoriaModel atualizarCartegoria(CartegoriaModel cartegoria);
    public CartegoriaModel recuperarPeloId(Integer id);
    public List<CartegoriaModel> recuperarTodos();
}
