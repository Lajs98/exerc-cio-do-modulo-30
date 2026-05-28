package br.com.lsantos;

import br.com.lsantos.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class TesteJPA {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManagerPostgres();

        System.out.println("Conexão JPA realizada com sucesso!");

        em.close();
    }
}