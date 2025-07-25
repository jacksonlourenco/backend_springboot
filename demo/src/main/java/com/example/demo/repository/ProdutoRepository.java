package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Produto;
import com.example.demo.model.exception.ResourceNotFoundException;

@Repository
public class ProdutoRepository {

    // #region Atributos
    private List<Produto> produtos = new ArrayList<Produto>();
    private Integer ultimoId = 0;

    // #endregion

    // #region Métodos
    /**
     * Retorna uma lista de produto do repositório.
     * 
     * @return O produto adicionado.
     */
    public List<Produto> obterTodos() {
        return produtos;
    }

    /**
     * Metodo que retorna um produto pelo ID
     * 
     * @parm id do produto que será localizado
     * @return O produto localizado ou vazio se não encontrado
     */
    public Optional<Produto> obterPorId(Integer id) {
        return produtos.stream()
                .filter(produto -> produto.getId() == id)
                .findFirst();
    }

    /**
     * Adiciona um produto ao repositório e atribui um ID único.
     * O ID é incrementado automaticamente a cada novo produto adicionado.
     * 
     * @param Produto a ser adicionado ao repositório.
     * @return O produto adicionado com o ID atribuído.
     */
    public Produto adicionar(Produto produto) {
        ultimoId++;
        produto.setId(ultimoId);
        produtos.add(produto);
        return produto;
    }

    /**
     * Método para deletar um produto do repositório pelo ID.
     * 
     * @param id do produto a ser deletado.
     */
    public void deletar(Integer id) {
        produtos.removeIf(produto -> produto.getId() == id);
    }

    /**
     * Método para atualizar um produto no repositório.
     * 
     * @param produto a ser atualizado.
     * @return O produto atualizado ou null se o produto não existir.
     */
    public Produto atualizar(Produto produto) {
        Optional<Produto> produtoExistente = obterPorId(produto.getId());

        if (produtoExistente.isEmpty()) {
            throw new ResourceNotFoundException("Produto não encontrado.");
        }

        deletar(produto.getId());
        produtos.add(produto);
        return produto;
    }
    // #endregion

}
