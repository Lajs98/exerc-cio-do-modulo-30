package br.com.lsantos;

import br.com.lsantos.dao.EstoqueDAO;
import br.com.lsantos.dao.MovimentacaoDAO;
import br.com.lsantos.domain.Movimentacao;

public class Main {

    public static void main(String[] args) {

        Long produtoId = 1L;

        Integer quantidadeVenda = 2;

        EstoqueDAO estoqueDAO =
                new EstoqueDAO();

        estoqueDAO.baixarEstoque(
                produtoId,
                quantidadeVenda
        );

        Movimentacao movimentacao =
                new Movimentacao();

        movimentacao.setProdutoId(produtoId);

        movimentacao.setTipo("SAIDA");

        movimentacao.setQuantidade(
                quantidadeVenda
        );

        MovimentacaoDAO movimentacaoDAO =
                new MovimentacaoDAO();

        movimentacaoDAO.cadastrar(
                movimentacao
        );
    }
}