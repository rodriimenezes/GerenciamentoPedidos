/*
CONEXÃO COM O BANCO DE DADOS
*/
package br.estacio.gerenciamentopedidos.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexaoDB {
    private static final EntityManagerFactory FACTORY = 
        Persistence.createEntityManagerFactory("gerenciamentoPedidos");
    
    public static EntityManager getEntityManager(){
        return FACTORY.createEntityManager();
    }
}
