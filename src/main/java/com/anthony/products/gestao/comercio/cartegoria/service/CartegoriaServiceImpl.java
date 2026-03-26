package com.anthony.products.gestao.comercio.cartegoria.service;

import com.anthony.products.gestao.comercio.cartegoria.dao.CartegoriaDAO;
import com.anthony.products.gestao.comercio.cartegoria.model.CartegoriaModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartegoriaServiceImpl implements ICartegoriaService{

    private final CartegoriaDAO cartegoriaDAO;

    public CartegoriaServiceImpl(CartegoriaDAO cartegoriaDAO) {
        this.cartegoriaDAO = cartegoriaDAO;
    }
    @Override
    public CartegoriaModel cadastrarNovaCartegoria(CartegoriaModel nova) {
        return cartegoriaDAO.save(nova);
    }

    @Override
    public CartegoriaModel excluirCartegoria(Integer id) {
        var cartegoria = cartegoriaDAO.findById(id).orElse(null);
        if (cartegoria != null) {
            cartegoriaDAO.deleteById(id);
        }
        return cartegoria;
    }

    @Override
    public CartegoriaModel atualizarCartegoria(CartegoriaModel cartegoria) {
        return cartegoriaDAO.save(cartegoria);
    }

    @Override
    public CartegoriaModel recuperarPeloId(Integer id) {
        return cartegoriaDAO.findById(id).orElse(null);
    }

    @Override
    // Por padrao o find all nao aceita listas entao deve ser feito um cast com o modelo para aceitar
    public List<CartegoriaModel> recuperarTodos() {
        return (List<CartegoriaModel>)cartegoriaDAO.findAll();
    }
}
