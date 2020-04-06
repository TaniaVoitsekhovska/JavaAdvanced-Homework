package ua.lviv.home;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtils {

    private static EntityManagerFactory entityManagerFactory;

    private static EntityManagerFactory getEntityManagerFactory(){
        if(entityManagerFactory==null){
            entityManagerFactory=Persistence.createEntityManagerFactory("iShopPersistence");
        }
        return entityManagerFactory;
    }

    public static EntityManager getEntityManager(){
        return getEntityManagerFactory().createEntityManager();
    }
}
