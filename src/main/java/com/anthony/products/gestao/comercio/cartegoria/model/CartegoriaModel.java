package com.anthony.products.gestao.comercio.cartegoria.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_cartegoria")
public class CartegoriaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cartegoria",nullable = false)
    private Integer id;
    @Column(name = "nome_cartegoria", nullable = false, length = 50)
    private String nome;

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

}
