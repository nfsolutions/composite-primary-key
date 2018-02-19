package com.logicbig.example;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class ExampleMain2 {

    public static void main(String[] args) throws Exception {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("example-unit");
        try {
            persistEntity(emf);
            indexEntities(emf);
            runNativeQuery(emf);
            findEntityById(emf);
            indexEntities(emf);


        } finally {
            emf.close();
        }
    }

    private static void indexEntities(EntityManagerFactory emf) throws InterruptedException {
        FullTextEntityManager fullTextEntityManager
                = Search.getFullTextEntityManager(emf.createEntityManager());
        fullTextEntityManager.createIndexer().startAndWait();
    }

    private static void persistEntity(EntityManagerFactory emf) throws Exception {
        System.out.println("-- Persisting entity --");
        EntityManager em = emf.createEntityManager();

        Task task = new Task(5, 10);
        task.setTaskName("coding");
        task.setDate(new Date());

        em.getTransaction().begin();
        em.persist(task);
        em.getTransaction().commit();
        em.close();
    }

    private static void runNativeQuery(EntityManagerFactory emf) {
        System.out.println("-- Native query --");
        EntityManager em = emf.createEntityManager();
        ExampleMain.nativeQuery(em, "Select * from Task");
    }

    private static void findEntityById(EntityManagerFactory emf) {
        System.out.println("-- Finding entity --");
        EntityManager em = emf.createEntityManager();
        CompositeTaskId taskId = new CompositeTaskId(5, 10);
        Task task = em.find(Task.class, taskId);
        System.out.println(task);
        em.close();
    }
}