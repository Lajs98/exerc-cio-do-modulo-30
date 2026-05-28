package br.com.lsantos;

import br.com.lsantos.dao.ClienteMySQLDAO;
import br.com.lsantos.domain.Cliente;

import java.time.LocalDateTime;

public class TesteClienteMySQL {

    public static void main(String[] args) {

        Cliente cliente = new Cliente();

        cliente.setNome("Cliente MySQL");
        cliente.setCpf(55566677788L);
        cliente.setTelefone(19988887777L);
        cliente.setEmail("mysql@email.com");
        cliente.setSexo("M");
        cliente.setEndereco("Rua MySQL");
        cliente.setNumero(200);
        cliente.setCidade("Campinas");
        cliente.setEstado("SP");
        cliente.setDataCadastro(LocalDateTime.now());

        ClienteMySQLDAO clienteMySQLDAO = new ClienteMySQLDAO();

        clienteMySQLDAO.cadastrar(cliente);
    }
}