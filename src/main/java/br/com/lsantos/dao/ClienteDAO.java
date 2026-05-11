package br.com.lsantos.dao;

import br.com.lsantos.domain.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void cadastrar(Cliente cliente) {

        String sql = """
                INSERT INTO tb_cliente
                (
                    nome,
                    cpf,
                    telefone,
                    email,
                    sexo,
                    endereco,
                    numero,
                    cidade,
                    estado
                )
                VALUES
                (
                    ?, ?, ?, ?, ?, ?, ?, ?, ?
                )
                """;

        try {

            Connection connection =
                    ConnectionFactory.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(1, cliente.getNome());

            statement.setLong(2, cliente.getCpf());

            statement.setLong(3, cliente.getTelefone());

            statement.setString(4, cliente.getEmail());

            statement.setString(5, cliente.getSexo());

            statement.setString(6, cliente.getEndereco());

            statement.setInt(7, cliente.getNumero());

            statement.setString(8, cliente.getCidade());

            statement.setString(9, cliente.getEstado());

            statement.executeUpdate();

            statement.close();

            connection.close();

            System.out.println("Cliente cadastrado com sucesso!");

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    public List<Cliente> buscarTodos() {

        List<Cliente> clientes =
                new ArrayList<>();

        String sql =
                "SELECT * FROM tb_cliente";

        try {

            Connection connection =
                    ConnectionFactory.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            ResultSet resultSet =
                    statement.executeQuery();

            while (resultSet.next()) {

                Cliente cliente =
                        new Cliente();

                cliente.setId(
                        resultSet.getLong("id"));

                cliente.setNome(
                        resultSet.getString("nome"));

                cliente.setCpf(
                        resultSet.getLong("cpf"));

                cliente.setTelefone(
                        resultSet.getLong("telefone"));

                cliente.setEmail(
                        resultSet.getString("email"));

                cliente.setSexo(
                        resultSet.getString("sexo"));

                cliente.setEndereco(
                        resultSet.getString("endereco"));

                cliente.setNumero(
                        resultSet.getInt("numero"));

                cliente.setCidade(
                        resultSet.getString("cidade"));

                cliente.setEstado(
                        resultSet.getString("estado"));

                clientes.add(cliente);
            }

            resultSet.close();

            statement.close();

            connection.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return clientes;
    }
    public void atualizar(Cliente cliente) {

        String sql = """
            UPDATE tb_cliente
            SET
                nome = ?,
                cpf = ?,
                telefone = ?,
                email = ?,
                sexo = ?,
                endereco = ?,
                numero = ?,
                cidade = ?,
                estado = ?
            WHERE id = ?
            """;

        try {

            Connection connection =
                    ConnectionFactory.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(1, cliente.getNome());

            statement.setLong(2, cliente.getCpf());

            statement.setLong(3, cliente.getTelefone());

            statement.setString(4, cliente.getEmail());

            statement.setString(5, cliente.getSexo());

            statement.setString(6, cliente.getEndereco());

            statement.setInt(7, cliente.getNumero());

            statement.setString(8, cliente.getCidade());

            statement.setString(9, cliente.getEstado());

            statement.setLong(10, cliente.getId());

            statement.executeUpdate();

            statement.close();

            connection.close();

            System.out.println("Cliente atualizado com sucesso!");

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
    public void excluir(Long id) {

        String sql =
                "DELETE FROM tb_cliente WHERE id = ?";

        try {

            Connection connection =
                    ConnectionFactory.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setLong(1, id);

            statement.executeUpdate();

            statement.close();

            connection.close();

            System.out.println("Cliente excluído com sucesso!");

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}