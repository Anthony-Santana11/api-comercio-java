package com.anthony.products.gestao.comercio.varianteProduto.service;

import com.anthony.products.gestao.comercio.produto.model.ProdutoModel;
import com.anthony.products.gestao.comercio.varianteProduto.dao.varianteDAO;
import com.anthony.products.gestao.comercio.varianteProduto.model.VarianteProdutoModel;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class VarianteProdutoServiceImpl implements IVarianteProdutoService {
    private final varianteDAO varianteDAO;

    public VarianteProdutoServiceImpl(varianteDAO varianteDAO) {
        this.varianteDAO = varianteDAO;
    }

    @Override
    public VarianteProdutoModel adicionarVarianteProduto(VarianteProdutoModel varianteNova) {
        return varianteDAO.save(varianteNova);
    }

    @Override
    public VarianteProdutoModel atualizarVarianteProduto(VarianteProdutoModel varianteAtualizado) {
        return varianteDAO.save(varianteAtualizado);
    }

    @Override
    public List<VarianteProdutoModel> listarVariantePorProduto(ProdutoModel produto) {
        return Collections.singletonList(varianteDAO.findByProduto(produto));
    }

    @Override
    public VarianteProdutoModel listarVarianteProdutoPorVariante(Integer id) {
        return varianteDAO.findById(id).orElse(null);
    }
}
