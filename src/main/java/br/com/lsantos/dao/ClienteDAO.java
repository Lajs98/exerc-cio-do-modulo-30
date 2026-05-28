package br.com.lsantos.dao;

import br.com.lsantos.domain.Cliente;
import br.com.lsantos.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ClienteDAO {

    public void cadastrar(Cliente cliente) {

        EntityManager em = JPAUtil.getEntityManagerPostgres();

        try {
            em.getTransaction().begin();

            em.persist(cliente);

            em.getTransaction().commit();

            System.out.println("Cliente cadastrado com sucesso!");

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();

        } finally {
            em.close();
        }
    }

    public List<Cliente> buscarTodos() {

        EntityManager em = JPAUtil.getEntityManagerPostgres();

        try {
            return em.createQuery("SELECT c FROM Cliente c", Cliente.class)
                    .getResultList();

        } finally {
            em.close();
        }
    }

    public Cliente buscarPorId(Long id) {

        EntityManager em = JPAUtil.getEntityManagerPostgres();

        try {
            return em.find(Cliente.class, id);

        } finally {
            em.close();
        }
    }

    public void atualizar(Cliente cliente) {

        EntityManager em = JPAUtil.getEntityManagerPostgres();

        try {
            em.getTransaction().begin();

            em.merge(cliente);

            em.getTransaction().commit();

            System.out.println("Cliente atualizado com sucesso!");

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();

        } finally {
            em.close();
        }
    }

    public void excluir(Long id) {

        EntityManager em = JPAUtil.getEntityManagerPostgres();

        try {
            em.getTransaction().begin();

            Cliente cliente = em.find(Cliente.class, id);

            if (cliente != null) {
                em.remove(cliente);
                System.out.println("Cliente excluído com sucesso!");
            } else {
                System.out.println("Cliente não encontrado!");
            }

            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();

        } finally {
            em.close();
        }
    }
}