package br.com.lsantos;

import br.com.lsantos.dao.ConnectionFactory;

import java.sql.Connection;

public class TesteConexao {

    public static void main(String[] args) {

        try {

            Connection connection =
                    ConnectionFactory.getConnection();

            System.out.println("Conectado com sucesso!");

            connection.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}