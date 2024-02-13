package com.example.repositorios.Concesionario;

import java.util.List;

import com.example.modelos.Concesionario;
import com.example.repositorios.JPARepository;

import jakarta.persistence.EntityManager;

public class JPAconcesionarioRepository  extends JPARepository implements ConcesionarioRepository{


    @Override
    public List<Concesionario> getAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin(); 
        List<Concesionario> Concesionarios = em.createQuery("FROM Concesionario", Concesionario.class).getResultList();    
        em.getTransaction().commit();
        return Concesionarios;
    }

    @Override
    public Concesionario getById(int id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Concesionario Concesionario = em.find(Concesionario.class,id);
        em.getTransaction().commit();
        return Concesionario;
    }

    
    @Override
    public Concesionario insert(Concesionario Concesionario) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(Concesionario);
        em.getTransaction().commit();
        return Concesionario;
    }

    @Override
    public Concesionario update(Concesionario Concesionario) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(Concesionario);
        em.getTransaction().commit();
        return Concesionario;
    }

    @Override
    public Boolean delete(Concesionario Concesionario) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.remove(Concesionario);
        
        if (Concesionario != null) {
        em.remove(Concesionario);
        em.getTransaction().commit();
        return true;
        } else {
        em.getTransaction().commit();
        return false;
        }
    }
}
