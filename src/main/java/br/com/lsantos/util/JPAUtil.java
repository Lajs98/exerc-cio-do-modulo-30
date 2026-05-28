package br.com.lsantos.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory postgresFactory =
            Persistence.createEntityManagerFactory("postgresPU");

    private static final EntityManagerFactory mysqlFactory =
            Persistence.createEntityManagerFactory("mysqlPU");

    public static EntityManager getEntityManagerPostgres() {
        return postgresFactory.createEntityManager();
    }

    public static EntityManager getEntityManagerMySQL() {
        return mysqlFactory.createEntityManager();
    }
}