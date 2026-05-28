package br.com.lsantos.dao;

import br.com.lsantos.domain.Cliente;
import br.com.lsantos.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class ClienteMySQLDAO {

    public void cadastrar(Cliente cliente) {

        EntityManager em =
                JPAUtil.getEntityManagerMySQL();

        try {

            em.getTransaction().begin();

            em.persist(cliente);

            em.getTransaction().commit();

            System.out.println("Cliente salvo no MySQL!");

        } catch (Exception e) {

            em.getTransaction().rollback();

            e.printStackTrace();

        } finally {

            em.close();
        }
    }
}