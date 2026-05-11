package br.com.lsantos.dao;

import br.com.lsantos.domain.Movimentacao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MovimentacaoDAO {

    public void cadastrar(Movimentacao movimentacao) {

        String sql = """
                INSERT INTO tb_movimentacao
                (
                    produto_id,
                    tipo,
                    quantidade
                )
                VALUES
                (
                    ?, ?, ?
                )
                """;

        try {

            Connection connection =
                    ConnectionFactory.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setLong(
                    1,
                    movimentacao.getProdutoId()
            );

            statement.setString(
                    2,
                    movimentacao.getTipo()
            );

            statement.setInt(
                    3,
                    movimentacao.getQuantidade()
            );

            statement.executeUpdate();

            statement.close();

            connection.close();

            System.out.println(
                    "Movimentação cadastrada!"
            );

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}