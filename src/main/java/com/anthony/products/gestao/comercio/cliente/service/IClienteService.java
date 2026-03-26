package com.anthony.products.gestao.comercio.cliente.service;

import com.anthony.products.gestao.comercio.cliente.model.ClientModel;

import java.util.List;

public interface IClienteService {
    public ClientModel cadastrarNovoCLiente(ClientModel novo);
    public ClientModel atualizarCliente(ClientModel cliente);
    public ClientModel recuperarPeloId(Integer id);
    public ClientModel recuperarClientePeloTelefone(String telefone);
    public List<ClientModel> recuperarTodos();
}
