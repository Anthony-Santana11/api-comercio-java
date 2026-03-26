package com.anthony.products.gestao.comercio.cliente.dao;

import com.anthony.products.gestao.comercio.cliente.model.ClientModel;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDAO extends CrudRepository<ClientModel, Integer> {
    ClientModel findByTelefone(String telefone);
}
