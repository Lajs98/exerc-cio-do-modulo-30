package br.com.lsantos.dao;

import br.com.lsantos.domain.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProdutoDAO {

    public Long cadastrar(Produto produto) {

        String sql = """
            INSERT INTO tb_produto
            (
                nome,
                descricao,
                codigo_barras,
                valor,
                marca,
                categoria,
                ativo
            )
            VALUES
            (
                ?, ?, ?, ?, ?, ?, ?
            )
            """;

        try {

            Connection connection =
                    ConnectionFactory.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(
                            sql,
                            Statement.RETURN_GENERATED_KEYS
                    );

            statement.setString(1, produto.getNome());

            statement.setString(2, produto.getDescricao());

            statement.setString(3, produto.getCodigoBarras());

            statement.setBigDecimal(4, produto.getValor());

            statement.setString(5, produto.getMarca());

            statement.setString(6, produto.getCategoria());

            statement.setBoolean(7, produto.getAtivo());

            statement.executeUpdate();

            ResultSet resultSet =
                    statement.getGeneratedKeys();

            Long produtoId = null;

            if (resultSet.next()) {

                produtoId =
                        resultSet.getLong(1);
            }

            resultSet.close();

            statement.close();

            connection.close();

            System.out.println("Produto cadastrado com sucesso!");

            return produtoId;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;
    }
}