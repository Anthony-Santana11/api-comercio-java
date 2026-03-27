package com.anthony.products.gestao.comercio.produto.service;

import com.anthony.products.gestao.comercio.cartegoria.model.CartegoriaModel;
import com.anthony.products.gestao.comercio.produto.dao.ProdutoDAO;
import com.anthony.products.gestao.comercio.produto.model.ProdutoModel;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
public class ProdutoServiceImpl implements IProdutoService{

    private final ProdutoDAO produtoDAO;


    public ProdutoServiceImpl(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    @Override
    public ProdutoModel salvar(ProdutoModel novo) {
        return produtoDAO.save(novo);
    }

    @Override
    public ProdutoModel atualizar(ProdutoModel produto) {
        return produtoDAO.save(produto);
    }

    @Override
    public ProdutoModel deletar(Integer id) {
       var produto = produtoDAO.findById(id).orElse(null);
       if (produto != null) {
           produtoDAO.deleteById(id);
       }
       return produto;
    }


    @Override
    public List<ProdutoModel> listartudo() {
        return (List<ProdutoModel>)produtoDAO.findAll();
    }

    @Override
    public List<ProdutoModel> listarPorCartegoria(CartegoriaModel cartegoria) {
        return (List<ProdutoModel>)produtoDAO.getProdutosByCartegoria(cartegoria) ;
    }

    @Override
    public List<ProdutoModel> listarPorNome(String nome) {
        return produtoDAO.getProdutosByNomeContainingIgnoreCase(nome);
    }

    @Override
    public List<ProdutoModel> listarPorPalavraChave(String palavra) {
        return produtoDAO.getProductByNomeContaining(palavra);
    }

    @Override
    public ProdutoModel listarPorId(Integer id) {
        return produtoDAO.findById(id).orElse(null);
    }
}
