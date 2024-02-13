package com.example.repositorios.Cliente;

import com.example.modelos.Cliente;
import com.example.repositorios.JPARepository;

import jakarta.persistence.EntityManager;
import java.util.List;

public class JPAClientesRepository extends JPARepository implements ClienteRepository{
    
    @Override
    public List<Cliente> getAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<Cliente> clientes =  em.createQuery("FROM Cliente", Cliente.class).getResultList();
        for(Cliente cli : clientes ){
            System.out.println(cli.toString());
        }
        
        em.getTransaction().commit();
        return clientes;
    }

    @Override
    public Cliente getById(int id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Cliente cliente = em.find(Cliente.class,id);
        em.getTransaction().commit();
        return cliente;
    }

    
    @Override
    public Cliente insert(Cliente cliente) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        return cliente;
    }

    @Override
    public Cliente update(Cliente cliente) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(cliente);
        em.getTransaction().commit();
        return cliente;
    }

    @Override
    public Boolean delete(Cliente cliente) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.remove(cliente);
        
        if (cliente != null) {
        em.remove(cliente);
        em.getTransaction().commit();
        return true;
        } else {
        em.getTransaction().commit();
        return false;
        }
    }

    
}
