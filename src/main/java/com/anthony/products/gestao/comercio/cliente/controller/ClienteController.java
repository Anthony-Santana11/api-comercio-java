package com.anthony.products.gestao.comercio.cliente.controller;


import com.anthony.products.gestao.comercio.cliente.model.ClientModel;
import com.anthony.products.gestao.comercio.cliente.service.IClienteService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    private final IClienteService clienteService;

    public ClienteController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/clientes")
    public ResponseEntity<List<ClientModel>> getAll(){
        return ResponseEntity.ok(clienteService.recuperarTodos());
    }

    @GetMapping("/clientes/busca")
    public ResponseEntity<ClientModel> getByTelefone(@RequestParam(name = "telefone") String telefone) {
        ClientModel result = clienteService.recuperarClientePeloTelefone(telefone);
        if (result != null) {
            return ResponseEntity.ok(clienteService.recuperarClientePeloTelefone(telefone));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<ClientModel> getById(@PathVariable Integer id) {
        // devemos chamar o serviço para recuperar o cliente pelo “id”, e verificar se o resultado é nulo ou não
        ClientModel result = clienteService.recuperarPeloId(id);
        // condição para verificar se o resultado é nulo ou não, caso seja nulo,
        // devemos retornar um status de resposta 404 (not found),
        // caso contrário, devemos retornar o cliente encontrado com um status de resposta 200 (ok)
        if (result != null){
            return ResponseEntity.ok(clienteService.recuperarPeloId(id));
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/clientes")
    public ResponseEntity<ClientModel> create(@RequestBody ClientModel novo) {
        /*
        * utilizamos o bloco de try/catch para verificar se ocorre alguma excecao e caso ocorra capturamos e exibimos uma mensagem  */
         try {
             ClientModel result = clienteService.cadastrarNovoCLiente(novo);
             if (result != null){
                 return ResponseEntity.ok(clienteService.cadastrarNovoCLiente(novo));
             }
         } catch (Exception e) {
             System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
         }
         return ResponseEntity.badRequest().build();
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<ClientModel> update(@PathVariable Integer id, @RequestBody ClientModel cliente) {
        cliente.setId(id);
        try{
            ClientModel result = clienteService.atualizarCliente(cliente);
            if (result != null){
                return ResponseEntity.ok(clienteService.atualizarCliente(cliente));
            }
        } catch (Exception e) {
            System.out.println("Erro ao atualizar cliente: " + e.getMessage());
        }
        return ResponseEntity.notFound().build();
    }
}
