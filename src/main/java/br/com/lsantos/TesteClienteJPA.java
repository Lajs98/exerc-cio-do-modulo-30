package br.com.lsantos;

import br.com.lsantos.dao.ClienteDAO;
import br.com.lsantos.domain.Cliente;

import java.time.LocalDateTime;

public class TesteClienteJPA {

    public static void main(String[] args) {

        ClienteDAO clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();

        cliente.setNome("Levi Santos");
        cliente.setCpf(11122233344L);
        cliente.setTelefone(19999999999L);
        cliente.setEmail("levi@email.com");
        cliente.setSexo("M");
        cliente.setEndereco("Rua Teste");
        cliente.setNumero(100);
        cliente.setCidade("Hortolandia");
        cliente.setEstado("SP");
        cliente.setDataCadastro(LocalDateTime.now());

        clienteDAO.cadastrar(cliente);

        cliente.setNome("Levi Santos Atualizado");

        clienteDAO.atualizar(cliente);

        System.out.println("\nLISTA DE CLIENTES:");

        clienteDAO.buscarTodos().forEach(c ->
                System.out.println(c.getNome()));

        clienteDAO.excluir(cliente.getId());
    }
}