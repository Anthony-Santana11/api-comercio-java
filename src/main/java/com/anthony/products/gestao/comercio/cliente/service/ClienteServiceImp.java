package com.anthony.products.gestao.comercio.cliente.service;

import com.anthony.products.gestao.comercio.cliente.dao.ClienteDAO;
import com.anthony.products.gestao.comercio.cliente.model.ClientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteServiceImp implements IClienteService{


    private final ClienteDAO clienteDAO;

    public ClienteServiceImp(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    public ClientModel cadastrarNovoCLiente(ClientModel novo) {
       clienteDAO.save(novo);
         return novo;
    }

    @Override
    public ClientModel atualizarCliente(ClientModel cliente) {
        clienteDAO.save(cliente);
        return cliente;
    }

    @Override
    public ClientModel recuperarPeloId(Integer id) {
        return clienteDAO.findById(id).orElse(null);
    }

    @Override
    public ClientModel recuperarClientePeloTelefone(String telefone) {
        return clienteDAO.findByTelefone(telefone);
    }

    @Override
    public List<ClientModel> recuperarTodos() {
        return (List<ClientModel>) clienteDAO.findAll();
    }
}
