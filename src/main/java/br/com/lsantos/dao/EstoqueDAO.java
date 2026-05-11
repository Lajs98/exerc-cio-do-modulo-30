package br.com.lsantos.dao;

import br.com.lsantos.domain.Estoque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EstoqueDAO {

    public void cadastrar(Estoque estoque) {

        String sql = """
                INSERT INTO tb_estoque
                (
                    produto_id,
                    quantidade
                )
                VALUES
                (
                    ?, ?
                )
                """;

        try {

            Connection connection =
                    ConnectionFactory.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setLong(1, estoque.getProdutoId());

            statement.setInt(2, estoque.getQuantidade());

            statement.executeUpdate();

            statement.close();

            connection.close();

            System.out.println("Estoque cadastrado com sucesso!");

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
    public Integer buscarQuantidadePorProduto(
            Long produtoId
    ) {

        String sql = """
            SELECT quantidade
            FROM tb_estoque
            WHERE produto_id = ?
            """;

        try {

            Connection connection =
                    ConnectionFactory.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setLong(1, produtoId);

            ResultSet resultSet =
                    statement.executeQuery();

            Integer quantidade = 0;

            if (resultSet.next()) {

                quantidade =
                        resultSet.getInt("quantidade");
            }

            resultSet.close();

            statement.close();

            connection.close();

            return quantidade;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return 0;
    }
    public void baixarEstoque(
            Long produtoId,
            Integer quantidadeBaixa
    ) {

        Integer quantidadeAtual =
                buscarQuantidadePorProduto(
                        produtoId
                );

        Integer novaQuantidade =
                quantidadeAtual - quantidadeBaixa;

        String sql = """
            UPDATE tb_estoque
            SET quantidade = ?
            WHERE produto_id = ?
            """;

        try {

            Connection connection =
                    ConnectionFactory.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setInt(1, novaQuantidade);

            statement.setLong(2, produtoId);

            statement.executeUpdate();

            statement.close();

            connection.close();

            System.out.println(
                    "Estoque baixado com sucesso!"
            );

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}