package com.anthony.products.gestao.comercio.cliente.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_cliente")
public class ClientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer id;
    @Column(name = "nome_cliente", nullable = false, length = 50)
    private String nome;
    @Column(name = "telefone_cliente", nullable = false, length = 20)
    private String telefone;
    @Column(name = "cliente_email", nullable = false, length = 100)
    private String email;
    @Column(name = "cep", nullable = true, length = 20)
    private String cep;
    @Column(name = "logradouro", nullable = true, length = 100)
    private String logradouro;
    @Column(name = "numero", nullable = true, length = 10)
    private String numero;
    @Column(name = "complemento", nullable = true, length = 20)
    private String complemento;
    @Column(name = "bairro", nullable = true, length = 50)
    private String bairro;
    @Column(name = "cidade", nullable = true, length = 45)
    private String cidade;
    @Column(name = "estado", nullable = true, length = 2)
    private String estado;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
