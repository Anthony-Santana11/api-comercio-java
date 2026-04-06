package com.anthony.products.gestao.comercio.varianteProduto.model;

import com.anthony.products.gestao.comercio.produto.model.ProdutoModel;
import jakarta.persistence.*;


@Entity
@Table(name = "tbl_variante_produto")
public class VarianteProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_variante")
    private Integer id;
    @Column(name = "nome",  nullable = false,  length = 50)
    private String nome;
    @Column(name = "descricao",   nullable = false,  length = 100)
    private String descricao;
    @Column(name = "link_photo" , nullable = true ,  length = 255)
    private String link_foto;
    @ManyToOne
    @JoinColumn(name = "tbl_produto_id_produto")
    private ProdutoModel produto;

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

    public String getLink_foto() {
        return link_foto;
    }

    public void setLink_foto(String link_foto) {
        this.link_foto = link_foto;
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }
}
