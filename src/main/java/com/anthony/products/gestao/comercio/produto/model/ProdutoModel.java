package com.anthony.products.gestao.comercio.produto.model;

import com.anthony.products.gestao.comercio.cartegoria.model.CartegoriaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tbl_produto")
public class ProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto", nullable = false)
    private Integer id;
    @Column(name = "nome_produto", nullable = false, length = 45)
    private String nome;
    @Column(name = "descricao_produto", nullable = true, length = 200)
    private String descricao;
    @Column(name = "preco_produto", nullable = false)
    private Double preco;

    @ManyToMany
    @JoinTable(name = "tbl_cartegoria_produto",
            joinColumns = @JoinColumn(name = "id_produto"),
            inverseJoinColumns = @JoinColumn(name = "id_cartegoria"))
    private List<CartegoriaModel> cartegoria;
    @Column(name = "destaque", nullable = false)
    private int destaque;
    @Column(name = "disponivel", nullable = false)
    private int disponivel;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getDestaque() {
        return destaque;
    }

    public void setDestaque(int destaque) {
        this.destaque = destaque;
    }

    public int getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(int disponivel) {
        this.disponivel = disponivel;
    }

    public List<CartegoriaModel> getCartegoria() {
        return cartegoria;
    }

    public void setCartegoria(List<CartegoriaModel> cartegorias) {
        this.cartegoria = cartegorias;
    }
}
