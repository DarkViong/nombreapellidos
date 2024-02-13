package com.example.repositorios.Coche;

import java.util.List;
import com.example.modelos.Coche;
import com.example.repositorios.JPARepository;

import jakarta.persistence.EntityManager;

public class JPAcocheRepositorio extends JPARepository implements CocheRepository {
    
    @Override
    public List<Coche> getAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<Coche> coches =  em.createQuery("FROM Coche", Coche.class).getResultList();
        for(Coche cli : coches ){
            System.out.println(cli.toString());
        }
        
        em.getTransaction().commit();
        return coches;
    }

    @Override
    public Coche getById(int id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Coche coche = em.find(Coche.class,id);
        em.getTransaction().commit();
        return coche;
    }

    
    @Override
    public Coche insert(Coche coche) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(coche);
        em.getTransaction().commit();
        return coche;
    }

    @Override
    public Coche update(Coche coche) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(coche);
        em.getTransaction().commit();
        return coche;
    }

    @Override
    public Boolean delete(Coche coche) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.remove(coche);
        
        if (coche != null) {
        em.remove(coche);
        em.getTransaction().commit();
        return true;
        } else {
        em.getTransaction().commit();
        return false;
        }
    }
}